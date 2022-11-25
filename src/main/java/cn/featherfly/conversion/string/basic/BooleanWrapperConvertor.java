
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;


/**
 * <p>
 * 布尔包装类转换器
 * </p>
 *
 * @author 钟冀
 */
public class BooleanWrapperConvertor extends AbstractBasicConvertor<Boolean, Type<Boolean>>{

    /**
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
