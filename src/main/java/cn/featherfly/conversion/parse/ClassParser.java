
package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.Type;

/**
 * class类协议解析器.
 *
 * @author 钟冀
 */
public class ClassParser extends AbstractIterableParser<Type<?>> {

    /** 协议字符串常量. */
    public static final String PROTOCOL = "class";

    /**
     * Instantiates a new class parser.
     */
    public ClassParser() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T doParseContent(String content, Type<?> to) {
        if (Lang.isEmpty(content)) {
            return null;
        }
        try {
            return (T) Class.forName(Str.trim(content)).newInstance();
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<?> to) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProtocol() {
        return PROTOCOL;
    }
}
