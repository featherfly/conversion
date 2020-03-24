package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.conversion.string.ToStringConvertor;


/**
 * <p>
 * 数组转换器
 * </p>
 * @param <A> 数组自身类型
 * @param <E> 数组项类型
 * @author 钟冀
 */
public class GenericClassArrayConvertor<A, E> extends ArrayConvertor<A, GenericClass<A>, E, GenericClass<E>>{

    /**
     * @param convertor conversion
     */
    public GenericClassArrayConvertor(ToStringConvertor<E> convertor) {
        super(convertor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<A> generecType) {
        if (generecType == null) {
            return false;
        }
        return GenericClass.class == generecType.getClass();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected GenericClass<E> getArrayItemGenericType(GenericClass<A> genericType) {
        return new GenericClass<E>(getConvertor().getSourceType());
    }
}
