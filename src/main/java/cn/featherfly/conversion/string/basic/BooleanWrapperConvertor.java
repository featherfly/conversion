
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * 布尔包装类转换器.
 *
 * @author 钟冀
 */
public class BooleanWrapperConvertor extends AbstractBasicConvertor<Boolean, Type<Boolean>> {

    /**
     * Instantiates a new boolean wrapper convertor.
     */
    public BooleanWrapperConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Boolean value, Type<Boolean> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Boolean doToObject(String value, Type<Boolean> genericType) {
        return Boolean.parseBoolean(value);
    }

}
