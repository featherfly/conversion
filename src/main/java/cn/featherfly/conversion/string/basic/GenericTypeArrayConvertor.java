package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.string.ToStringConvertor;

/**
 * <p>
 * 数组转换器
 * </p>
 *
 * @param <A> 数组自身类型
 * @param <E> 数组项类型
 * @author 钟冀
 */
public class GenericTypeArrayConvertor<A, E> extends ArrayConvertor<A, Type<A>, E, Type<E>> {

    /**
     * @param convertor conversion
     */
    public GenericTypeArrayConvertor(ToStringConvertor<E> convertor) {
        super(convertor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<A> generecType) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Type<E> getArrayItemType(Type<A> genericType) {
        return null;
    }
}
