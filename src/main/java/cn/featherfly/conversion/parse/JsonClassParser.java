package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;

/**
 * json class类协议解析器.
 *
 * @author 钟冀
 */
public class JsonClassParser extends JsonParser<ClassType<Class<?>>> {

    /**
     * Instantiates a new json class parser.
     */
    public JsonClassParser() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<?> to) {
        return to == null ? true : to.getClass() == ClassType.class;
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
        Content objContent = getContent(content);
        String className = objContent.className;
        String jsonContent = objContent.content;

        if (Lang.isEmpty(className) && gt != null) {
            className = gt.getType().getName();
        }

        if (Lang.isEmpty(className)) {
            throw new ParseException("parse没有在content中找到类型，也没有设置ClassType<Class<?>>参数");
        }
        try {
            return (T) objectMapper.readerFor(Class.forName(className)).readValue(jsonContent);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }
}
