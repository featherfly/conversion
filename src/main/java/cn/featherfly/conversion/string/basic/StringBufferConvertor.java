
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * StringBuffer类转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBufferConvertor extends AbstractBasicConvertor<StringBuffer, Type<StringBuffer>>{

    /**
     */
    public StringBufferConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(StringBuffer value,
            Type<StringBuffer> genericType) {
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
            Type<StringBuffer> genericType) {
        if (value != null) {
            return new StringBuffer(value);
        }
        return null;
    }
}
