
package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.lang.StringUtils;

/**
 * <p>
 * 基础类型转换器
 * </p>
 * @param <T> 转换器对应的转换类型
 * @author 钟冀
 */
public abstract class NumberBasicTypeConvertor<T extends Number> extends NumberConvertor<T> {

    /**
     */
    public NumberBasicTypeConvertor() {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, GenericType<T> genericType) {
        if (StringUtils.isNotBlank(value)) {
            return NumberUtils.parse(value, getGenricType());
        }
        return NumberUtils.parse("-1", getGenricType());
    }
}
