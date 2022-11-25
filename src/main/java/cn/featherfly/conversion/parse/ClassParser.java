
package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;

/**
 * <p>
 * class类协议解析器
 * </p>
 *
 * @param <G> 解析的目标类型描述
 * @author 钟冀
 */
public class ClassParser<G extends Type<?>> extends AbstractIterableParser<G> {
    /**
     * 协议字符串常量
     */
    public static final String PROTOCOL = "class";

    /**
     */
    public ClassParser() {
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T doParseContent(String content, G to) {
        if (Lang.isEmpty(content)) {
            return null;
        }
        try {
            return (T) Class.forName(Strings.trim(content)).newInstance();
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
