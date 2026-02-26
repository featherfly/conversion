
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * String类转换器.
 *
 * @author 钟冀
 */
public class StringConvertor extends AbstractBasicConvertor<String, Type<String>> {

    /**
     * Instantiates a new string convertor.
     */
    public StringConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(String value, Type<String> genericType) {
        if (value != null) {
            return value;
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToObject(String value, Type<String> genericType) {
        return value;
    }
}
