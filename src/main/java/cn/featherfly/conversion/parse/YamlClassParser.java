package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.GenericClass;

/**
 * <p>
 * json class类协议解析器
 * </p>
 *
 * @author 钟冀
 */
public class YamlClassParser extends YamlParser<GenericClass<Class<?>>> {
    /**
     */
    public YamlClassParser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<?> to) {
        if (to == null) {
            return false;
        }
        return to.getClass() == GenericClass.class;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T doParse(String content, GenericClass<Class<?>> gt) {
        if (Lang.isEmpty(content)) {
            return null;
        }
        try {
            Content objContent = getContent(content);
            String className = objContent.className;
            String yamlContent = objContent.content;

            if (Lang.isEmpty(className)) {
                className = gt.getType().getName();
            }

            if (Lang.isEmpty(className)) {
                throw new IllegalArgumentException("parse(String content)必须显示指定类型（class）");
            }
            return (T) objectMapper.readerFor(Class.forName(className)).readValue(yamlContent);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }
}
