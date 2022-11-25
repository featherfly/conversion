
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * StringBuilder类转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBuilderConvertor extends AbstractBasicConvertor<StringBuilder, Type<StringBuilder>> {

    /**
     */
    public StringBuilderConvertor() {
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
