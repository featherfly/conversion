
package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.Type;

/**
 * class类协议解析器.
 *
 * @author 钟冀
 */
public class ClassFieldParser extends AbstractIterableParser<Type<?>> {

    /** 协议字符串常量. */
    public static final String PROTOCOL = "field";

    /**
     * Instantiates a new class field parser.
     */
    public ClassFieldParser() {
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
        String[] strs = parseContent(content);
        if (strs.length != 2) {
            throw new ParseException("format error " + content);
        }
        String className = strs[0];
        String fieldName = strs[1];
        return (T) getValue(className, fieldName);
    }

    private String[] parseContent(String str) {
        StringBuilder sb = new StringBuilder();
        boolean afterDot = false;
        boolean find = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c) && afterDot) {
                find = true;
            }
            if (c == '.') {
                afterDot = true;
                if (find) {
                    return new String[] { sb.toString(), str.substring(i + 1) };
                }
            } else {
                afterDot = false;
            }
            sb.append(c);
        }
        return new String[] { sb.toString() };
    }

    private Object getValue(String className, String fieldName) {
        try {
            return getValue(Class.forName(className), fieldName);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    private Object getValue(Class<?> type, String fieldName) {
        return ClassUtils.getFieldValue(type, fieldName);
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
