package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * json class类协议解析器
 * </p>
 *
 * @author 钟冀
 */
public class JsonClassParser extends JsonParser<ClassType<Class<?>>> {
    /**
     */
    public JsonClassParser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<?> to) {
        if (to == null) {
            return false;
        }
        return to.getClass() == ClassType.class;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T doParse(String content, ClassType<Class<?>> gt) {
        if (Lang.isEmpty(content)) {
            return null;
        }
        try {
            Content objContent = getContent(content);
            String className = objContent.className;
            String jsonContent = objContent.content;

            if (Lang.isEmpty(className)) {
                className = gt.getType().getName();
            }

            if (Lang.isEmpty(className)) {
                throw new IllegalArgumentException("parse(String content)必须显示指定类型（class）");
            }
            return (T) objectMapper.readerFor(Class.forName(className)).readValue(jsonContent);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }
}
