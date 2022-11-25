
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * String类转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringConvertor extends AbstractBasicConvertor<String, Type<String>>{

    /**
     */
    public StringConvertor() {
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
