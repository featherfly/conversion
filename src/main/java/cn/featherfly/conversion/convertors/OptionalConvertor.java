
package cn.featherfly.conversion.convertors;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.Convertor;
import cn.featherfly.conversion.TypePolicys;

/**
 * <p>
 * OptionalToStringConvertor
 * </p>
 *
 * @author zhongj
 */
@SuppressWarnings("rawtypes")
public abstract class OptionalConvertor<T> extends AbstractConvertor<Optional, T, GenericType<Optional>> {

    private Map<Class<?>, Convertor<?, T>> convertors = new HashMap<>();

    /**
     */
    public OptionalConvertor() {
        this(null);
    }

    /**
     */
    public OptionalConvertor(Collection<Convertor<?, T>> convertors) {
        setPolicy(TypePolicys.INSTANCE);
        setTargetType(ClassUtils.getSuperClassGenricType(this.getClass()));
        setSourceType(Optional.class);
        addConvertors(convertors);
    }

    /**
     * 设置convertors
     *
     * @param convertors convertors
     */
    public void setConvertors(Collection<Convertor<?, T>> convertors) {
        this.convertors.clear();
        addConvertors(convertors);
    }

    /**
     * 设置convertors
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
     * 设置convertors
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
    protected boolean supportFor(GenericType<Optional> generecType) {
        return generecType != null && generecType.getClass() == BeanProperty.class;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected T doSourceToTarget(Optional source, GenericType<Optional> genericType) {
        if (source != null && source.isPresent()) {
            Class<?> type = source.get().getClass();
            Convertor c = getConvertor(type);
            return (T) c.sourceToTarget(source.get(), new GenericClass<>(type));
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected Optional doTargetToSource(T target, GenericType<Optional> genericType) {
        if (genericType instanceof BeanProperty) {
            BeanProperty<Optional> bp = (BeanProperty<Optional>) genericType;
            Class<?> type = bp.getGenericType();
            Convertor c = getConvertor(type);
            return Optional.of(c.targetToSource(target, new Proxy<>(bp, type)));
        }
        return null;
    }

    protected Convertor getConvertor(Class<?> type) {
        Convertor convertor = convertors.get(type);
        if (convertor == null) {
            throw new ConversionException("#no_convertor_with_type", new Object[] { type.getName() });
        }
        return convertor;
    }
}
