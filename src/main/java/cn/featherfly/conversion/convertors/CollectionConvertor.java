
package cn.featherfly.conversion.convertors;

import java.util.Collection;
import java.util.Collections;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.Convertor;

/**
 * collection convertor.
 *
 * @author 钟冀
 * @param <S> the generic type
 * @param <T> the generic type
 */
public abstract class CollectionConvertor<S extends Collection<?>, T>
    extends ContainerConvertor<S, T> {

    /**
     * Instantiates a new optional convertor.
     */
    protected CollectionConvertor() {
        this(Collections.emptyList());
    }

    /**
     * Instantiates a new optional convertor.
     *
     * @param convertors the convertors
     */
    protected CollectionConvertor(Collection<Convertor<?, T>> convertors) {
        super(convertors, null, null);
        setSourceType(ClassUtils.getSuperClassGenericType(this.getClass()));
        setTargetType(ClassUtils.getSuperClassGenericType(this.getClass().getSuperclass(), 1));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<S> generecType) {
        return generecType != null && ClassUtils.isParent(Collection.class, generecType.getType());
    }
}
