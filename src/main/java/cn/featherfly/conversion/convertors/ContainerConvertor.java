
package cn.featherfly.conversion.convertors;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.Convertor;
import cn.featherfly.conversion.TypePolicys;

/**
 * container convertor.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <T> the generic type
 */
public abstract class ContainerConvertor<S, T> extends AbstractConvertor<S, T, Type<S>> {

    /** The convertors. */
    protected final Map<Class<?>, Convertor<?, T>> convertors = new HashMap<>();

    /**
     * Instantiates a new optional convertor.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    protected ContainerConvertor(Class<S> sourceType, Class<T> targetType) {
        this(Collections.emptyList(), sourceType, targetType);
    }

    /**
     * Instantiates a new optional convertor.
     *
     * @param convertors the convertors
     * @param sourceType the source type
     * @param targetType the target type
     */
    protected ContainerConvertor(Collection<Convertor<?, T>> convertors, Class<S> sourceType, Class<T> targetType) {
        super(sourceType, targetType, TypePolicys.INSTANCE);
        addConvertors(convertors);
    }

    /**
     * 设置convertors.
     *
     * @param convertors convertors
     */
    public void setConvertors(Collection<Convertor<?, T>> convertors) {
        this.convertors.clear();
        addConvertors(convertors);
    }

    /**
     * 设置convertors.
     *
     * @param convertors convertors
     */
    public void addConvertor(Convertor<?, T> convertors) {
        if (convertors != null) {
            this.convertors.put(convertors.getSourceType(), convertors);
        }
    }

    /**
     * 设置convertors.
     *
     * @param convertors convertors
     */
    public void addConvertors(Collection<Convertor<?, T>> convertors) {
        if (convertors != null) {
            for (Convertor<?, T> c : convertors) {
                this.convertors.put(c.getSourceType(), c);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<S> generecType) {
        return generecType != null && generecType.getType() == getSourceType();
    }

    /**
     * Gets the convertor.
     *
     * @param type the type
     * @return the convertor
     */
    protected Convertor<Object, T> getConvertor(Class<?> type) {
        @SuppressWarnings("unchecked")
        Convertor<Object, T> convertor = (Convertor<Object, T>) convertors.get(type);
        if (convertor == null) {
            throw new ConversionException("#no_convertor_with_type", new Object[] { type.getName() });
        }
        return convertor;
    }
}
