
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.GenericType;

/**
 * <p>
 * String类转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringConvertor extends AbstractBasicConvertor<String, GenericType<String>>{

    /**
     */
    public StringConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(String value, GenericType<String> genericType) {
        if (value != null) {
            return value;
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToObject(String value, GenericType<String> genericType) {
        return value;
    }
}
