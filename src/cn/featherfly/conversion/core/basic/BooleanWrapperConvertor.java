
package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;


/**
 * <p>
 * 布尔包装类转换器
 * </p>
 *
 * @author 钟冀
 */
public class BooleanWrapperConvertor extends AbstractBasicConvertor<Boolean, GenericType<Boolean>>{

    /**
     */
    public BooleanWrapperConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Boolean value, GenericType<Boolean> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Boolean doToObject(String value, GenericType<Boolean> genericType) {
        return Boolean.parseBoolean(value);
    }

}
