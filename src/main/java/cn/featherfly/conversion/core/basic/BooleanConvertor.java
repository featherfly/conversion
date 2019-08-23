
package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;


/**
 * <p>
 * 布尔转换器
 * </p>
 *
 * @author 钟冀
 */
public class BooleanConvertor extends AbstractBasicConvertor<Boolean, GenericType<Boolean>>{

    /**
     */
    public BooleanConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Boolean> getType() {
        return boolean.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Boolean doToObject(String value, GenericType<Boolean> genericType) {
        return Boolean.parseBoolean(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Boolean value, GenericType<Boolean> genericType) {
        if (value == null) {
            return "";
        }
        return value + "";
    }

}
