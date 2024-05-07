
package cn.featherfly.conversion.parse;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;

/**
 * <p>
 * json BeanProperty协议解析器
 * </p>
 *
 * @author 钟冀
 */
public class JsonBeanPropertyParser extends JsonParser<BeanProperty<?, ?>> {

    /**
     */
    public JsonBeanPropertyParser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(cn.featherfly.common.lang.reflect.Type<?> to) {
        if (to == null) {
            return false;
        }
        return to.getClass() == BeanProperty.class;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T doParse(String content, BeanProperty<?, ?> toBeanProperty) {
        if (Lang.isEmpty(content)) {
            return null;
        }
        try {
            Content objContent = getContent(content);
            String className = objContent.className;
            String jsonContent = objContent.content;

            Type toType = null;

            if (Lang.isEmpty(className)) {
                if (toBeanProperty == null) {
                    throw new IllegalArgumentException("当没有指定类型时，toBeanProperty不能为空");
                }
                if (toBeanProperty.getType().isInterface()) {
                    if (ClassUtils.isParent(Collection.class, toBeanProperty.getType())) {
                        toType = toBeanProperty.getField().getType();
                    } else if (ClassUtils.isParent(Map.class, toBeanProperty.getType())) {
                        toType = toBeanProperty.getField().getType();
                    } else {
                        throw new IllegalArgumentException("要设置的目标是接口（interface），请显示指定类型（class）");
                    }
                } else {
                    toType = toBeanProperty.getType();
                }
            } else {
                if (objContent.isMulty) {
                    if (toBeanProperty.getField().getType().isArray()) {
                        toType = Array.newInstance(Class.forName(objContent.className), 0).getClass();
                    } else {
                        toType = createParameterizedType(toBeanProperty.getField().getType(), null,
                            Class.forName(objContent.className));
                    }
                } else {
                    toType = Class.forName(className);
                }
            }
            if (toType instanceof ParameterizedType) {
                final Type parameterizedType = toType;
                return (T) objectMapper.readerFor(new TypeReference<T>() {
                    /**
                     * {@inheritDoc}
                     */
                    @Override
                    public Type getType() {
                        return parameterizedType;
                    }
                }).readValue(jsonContent);
            } else {
                return (T) objectMapper.readerFor((Class<?>) toType).readValue(jsonContent);
            }
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }
}
