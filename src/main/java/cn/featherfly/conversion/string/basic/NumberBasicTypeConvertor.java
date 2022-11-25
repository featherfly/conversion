
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.lang.Strings;

/**
 * <p>
 * 基础类型转换器
 * </p>
 *
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
    protected T doToObject(String value, Type<T> genericType) {
        if (Strings.isNotBlank(value)) {
            return NumberUtils.parse(value, getSourceType());
        }
        return NumberUtils.parse("-1", getSourceType());
    }
}
