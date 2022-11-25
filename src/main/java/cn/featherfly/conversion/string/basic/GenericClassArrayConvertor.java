package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.string.ToStringConvertor;

/**
 * 数组转换器.
 *
 * @param <A> 数组自身类型
 * @param <E> 数组项类型
 * @author 钟冀
 */
public class GenericClassArrayConvertor<A, E> extends ArrayConvertor<A, ClassType<A>, E, ClassType<E>> {

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
    protected boolean supportFor(Type<A> generecType) {
        if (generecType == null) {
            return false;
        }
        return ClassType.class == generecType.getClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ClassType<E> getArrayItemType(ClassType<A> genericType) {
        return new ClassType<>(getConvertor().getSourceType());
    }
}
