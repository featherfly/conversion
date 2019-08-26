
package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;



/**
 * <p>
 * class类协议解析器
 * </p>
 * @param <G> 解析的目标类型描述
 * @author 钟冀
 */
public class ClassParser<G extends GenericType<?>> extends AbstractIterableParser<G>{
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
        if (LangUtils.isEmpty(content)) {
            return null;
        }
        try {
            return (T) Class.forName(StringUtils.trim(content)).newInstance();
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<?> to) {
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
