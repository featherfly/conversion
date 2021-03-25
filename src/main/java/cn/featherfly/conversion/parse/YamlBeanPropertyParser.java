
package cn.featherfly.conversion.parse;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.Lang;

/**
 * <p>
 * json BeanProperty协议解析器
 * </p>
 *
 * @author 钟冀
 */
public class YamlBeanPropertyParser extends YamlParser<BeanProperty<?>> {

    /**
     */
    public YamlBeanPropertyParser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<?> to) {
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
    protected <T> T doParse(String content, BeanProperty<?> toBeanProperty) {
        if (Lang.isEmpty(content)) {
            return null;
        }
        try {
            Content objContent = getContent(content);
            String className = objContent.className;
            String yamlContent = objContent.content;

            Type toType = null;
            Class<?> classType = null;

            if (Lang.isEmpty(className)) {
                if (toBeanProperty == null) {
                    throw new IllegalArgumentException("当没有指定类型时，toBeanProperty不能为空");
                }
                if (toBeanProperty.getType().isInterface()) {
                    if (ClassUtils.isParent(Collection.class, toBeanProperty.getType())) {
                        toType = toBeanProperty.getField().getGenericType();
                    } else if (ClassUtils.isParent(Map.class, toBeanProperty.getType())) {
                        toType = toBeanProperty.getField().getGenericType();
                    } else {
                        throw new IllegalArgumentException("要设置的目标是接口（interface），请显示指定类型（class）");
                    }
                } else {
                    toType = toBeanProperty.getType();
                }
                classType = ClassUtils.forName(toType.getTypeName());
            } else {
                classType = Class.forName(objContent.className);
                if (objContent.isMulty) {
                    if (toBeanProperty.getField().getType().isArray()) {
                        toType = Array.newInstance(classType, 0).getClass();
                    } else {
                        toType = createParameterizedType(toBeanProperty.getField().getType(), null, classType);
                    }
                } else {
                    toType = classType;
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
                }).readValue(yamlContent);
            } else {
                return (T) objectMapper.readerFor((Class<?>) toType).readValue(yamlContent);
            }
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }
}
