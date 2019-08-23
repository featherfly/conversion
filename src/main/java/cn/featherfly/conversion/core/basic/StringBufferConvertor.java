
package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;

/**
 * <p>
 * StringBuffer类转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBufferConvertor extends AbstractBasicConvertor<StringBuffer, GenericType<StringBuffer>>{

    /**
     */
    public StringBufferConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(StringBuffer value,
            GenericType<StringBuffer> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected StringBuffer doToObject(String value,
            GenericType<StringBuffer> genericType) {
        if (value != null) {
            return new StringBuffer(value);
        }
        return null;
    }
}
