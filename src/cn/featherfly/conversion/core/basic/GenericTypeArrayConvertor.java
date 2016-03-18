package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.core.Convertor;


/**
 * <p>
 * 数组转换器
 * </p>
 * @param <A> 数组自身类型
 * @param <E> 数组项类型
 * @author 钟冀
 */
public class GenericTypeArrayConvertor<A, E> extends ArrayConvertor<A, GenericType<A>, E, GenericType<E>>{

    /**
     * @param convertor conversion
     */
    public GenericTypeArrayConvertor(Convertor<E> convertor) {
        super(convertor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<A> generecType) {
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected GenericType<E> getArrayItemGenericType(GenericType<A> genericType) {
        return null;
    }
}
