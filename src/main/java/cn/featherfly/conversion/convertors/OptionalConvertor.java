
package cn.featherfly.conversion.convertors;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.Convertor;
import cn.featherfly.conversion.TypePolicys;

/**
 * <p>
 * OptionalToStringConvertor
 * </p>
 * .
 *
 * @author     zhongj
 * @param  <T> the generic type
 */
@SuppressWarnings("rawtypes")
public abstract class OptionalConvertor<T> extends AbstractConvertor<Optional, T, Type<Optional>> {

    private Map<Class<?>, Convertor<?, T>> convertors = new HashMap<>();

    /**
     * Instantiates a new optional convertor.
     */
    public OptionalConvertor() {
        this(null);
    }

    /**
     * Instantiates a new optional convertor.
     *
     * @param convertors the convertors
     */
    public OptionalConvertor(Collection<Convertor<?, T>> convertors) {
        setPolicy(TypePolicys.INSTANCE);
        setTargetType(ClassUtils.getSuperClassGenericType(this.getClass()));
        setSourceType(Optional.class);
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
    @SuppressWarnings("unchecked")
    public void addConvertor(Convertor convertors) {
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
    protected boolean supportFor(Type<Optional> generecType) {
        return generecType != null && generecType.getClass() == BeanProperty.class;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected T doSourceToTarget(Optional source, Type<Optional> genericType) {
        if (source != null && source.isPresent()) {
            Class<?> type = source.get().getClass();
            Convertor c = getConvertor(type);
            return (T) c.sourceToTarget(source.get(), new ClassType<>(type));
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected Optional doTargetToSource(T target, Type<Optional> genericType) {
        if (genericType instanceof BeanProperty) {
            BeanProperty<?, Optional> bp = (BeanProperty<?, Optional>) genericType;
            Class<Optional> type = bp.getType();
            Convertor c = getConvertor(type);
            return Optional.of(c.targetToSource(target, new Proxy<>(bp, type)));
        }
        return null;
    }

    /**
     * Gets the convertor.
     *
     * @param  type the type
     * @return      the convertor
     */
    protected Convertor getConvertor(Class<?> type) {
        Convertor convertor = convertors.get(type);
        if (convertor == null) {
            throw new ConversionException("#no_convertor_with_type", new Object[] { type.getName() });
        }
        return convertor;
    }
}
