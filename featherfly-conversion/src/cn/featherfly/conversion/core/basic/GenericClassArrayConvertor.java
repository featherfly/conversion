package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.conversion.core.Convertor;


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
    public GenericClassArrayConvertor(Convertor<E> convertor) {
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
        return new GenericClass<E>(getConvertor().getType());
    }
}
