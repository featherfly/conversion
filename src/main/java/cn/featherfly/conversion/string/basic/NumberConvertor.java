
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.Num;
import cn.featherfly.common.lang.Str;

/**
 * <p>
 * 数字类型转换器
 * </p>
 *
 * @param <T> 转换器对应的转换类型
 * @author 钟冀
 */
public abstract class NumberConvertor<T extends Number> extends AbstractBasicConvertor<T, Type<T>> {

    /**
     */
    public NumberConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(T value, Type<T> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, Type<T> genericType) {
        if (Str.isNotBlank(value)) {
            return Num.parse(value, getSourceType());
        }
        return null;
    }
}
