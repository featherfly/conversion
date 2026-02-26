
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * 布尔转换器.
 *
 * @author 钟冀
 */
public class BooleanConvertor extends AbstractBasicConvertor<Boolean, Type<Boolean>> {

    /**
     * Instantiates a new boolean convertor.
     */
    public BooleanConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Boolean> getSourceType() {
        return boolean.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Boolean doToObject(String value, Type<Boolean> genericType) {
        return Boolean.parseBoolean(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Boolean value, Type<Boolean> genericType) {
        if (value == null) {
            return "";
        }
        return value + "";
    }

}
