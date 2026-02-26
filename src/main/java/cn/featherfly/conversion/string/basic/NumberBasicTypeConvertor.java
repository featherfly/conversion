
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.Num;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.Type;

/**
 * 基础类型转换器.
 *
 * @author 钟冀
 * @param <T> 转换器对应的转换类型
 */
public abstract class NumberBasicTypeConvertor<T extends Number> extends NumberConvertor<T> {

    /**
     * Instantiates a new number basic type convertor.
     */
    protected NumberBasicTypeConvertor() {
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
