
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * StringBuilder类转换器.
 *
 * @author 钟冀
 */
public class StringBuilderConvertor extends AbstractBasicConvertor<StringBuilder, Type<StringBuilder>> {

    /**
     * Instantiates a new string builder convertor.
     */
    public StringBuilderConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(StringBuilder value, Type<StringBuilder> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected StringBuilder doToObject(String value, Type<StringBuilder> genericType) {
        if (value != null) {
            return new StringBuilder(value);
        }
        return null;
    }
}
