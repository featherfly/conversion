
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.Num;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.Type;

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
        if (Str.isNotBlank(value)) {
            return Num.parse(value, getSourceType());
        }
        return Num.parse("-1", getSourceType());
    }
}
