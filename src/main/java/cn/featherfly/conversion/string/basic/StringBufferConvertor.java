
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * StringBuffer类转换器.
 *
 * @author 钟冀
 */
public class StringBufferConvertor extends AbstractBasicConvertor<StringBuffer, Type<StringBuffer>> {

    /**
     * Instantiates a new string buffer convertor.
     */
    public StringBufferConvertor() {
        super();
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
