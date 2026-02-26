package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.string.ToStringConvertor;

/**
 * 数组转换器.
 *
 * @author 钟冀
 * @param <A> 数组自身类型
 * @param <E> 数组项类型
 */
public class GenericTypeArrayConvertor<A, E> extends ArrayConvertor<A, Type<A>, E, Type<E>> {

    /**
     * Instantiates a new generic type array convertor.
     *
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
