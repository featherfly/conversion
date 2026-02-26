
package cn.featherfly.conversion.convertors;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.Convertor;

/**
 * optional convertor.
 *
 * @author zhongj
 * @param <T> the generic type
 */
@SuppressWarnings("rawtypes")
public abstract class OptionalConvertor<T> extends ContainerConvertor<Optional, T> {

    /**
     * Instantiates a new optional convertor.
     */
    protected OptionalConvertor() {
        this(Collections.emptyList());
    }

    /**
     * Instantiates a new optional convertor.
     *
     * @param convertors the convertors
     */
    protected OptionalConvertor(Collection<Convertor<?, T>> convertors) {
        super(convertors, Optional.class, null);
        setTargetType(ClassUtils.getSuperClassGenericType(this.getClass()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<Optional> generecType) {
        return generecType != null && generecType.getType() == Optional.class;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected T doSourceToTarget(Optional source, Type<Optional> genericType) {
        if (Lang.isEmpty(source)) {
            return null;
        }
        Class<?> type = source.get().getClass();
        Convertor c = getConvertor(type);
        return (T) c.sourceToTarget(source.get(), new ClassType<>(type));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected Optional doTargetToSource(T target, Type<Optional> genericType) {
        if (genericType instanceof BeanProperty) {
            BeanProperty<?, Optional> bp = (BeanProperty<?, Optional>) genericType;
            Convertor<Object, T> c = getConvertor(bp.getGenericType());
            return Optional.of(c.targetToSource(target, new ClassType<>((Class<Object>) bp.getGenericType())));
        } else if (genericType instanceof ContainerType) {
            ContainerType<Optional, ?> cp = (ContainerType<Optional, ?>) genericType;
            Convertor<Object, T> c = getConvertor(cp.getInnerType());
            return Optional.of(c.targetToSource(target, new ClassType<>((Class<Object>) cp.getInnerType())));
        }
        throw new ConversionException("#container_not_support_type",
            new Object[] { Optional.class.getName(), genericType.getClass().getName() });
    }
}
