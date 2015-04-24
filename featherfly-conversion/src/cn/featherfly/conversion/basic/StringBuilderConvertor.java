
package cn.featherfly.conversion.basic;

import cn.featherfly.common.lang.GenericType;

/**
 * <p>
 * StringBuilder类转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBuilderConvertor extends AbstractBasicConvertor<StringBuilder, GenericType<StringBuilder>>{

    /**
     */
    public StringBuilderConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(StringBuilder value,
            GenericType<StringBuilder> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected StringBuilder doToObject(String value,
            GenericType<StringBuilder> genericType) {
        if (value != null) {
            return new StringBuilder(value);
        }
        return null;
    }
}
