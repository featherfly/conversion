
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.lang.StringUtils;

/**
 * <p>
 * 数字类型转换器
 * </p>
 * @param <T> 转换器对应的转换类型
 * @author 钟冀
 */
public abstract class NumberConvertor<T extends Number> extends AbstractBasicConvertor<T, GenericType<T>> {

    /**
     */
    public NumberConvertor() {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(T value, GenericType<T> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, GenericType<T> genericType) {
        if (StringUtils.isNotBlank(value)) {
            return NumberUtils.parse(value, getSourceType());
        }
        return null;
    }
}
