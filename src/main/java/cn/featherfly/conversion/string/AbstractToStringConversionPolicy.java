
package cn.featherfly.conversion.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.TypePolicys;

/**
 * abstract to string conversion policy.
 *
 * @author 钟冀
 * @param <P> the generic type
 */
public abstract class AbstractToStringConversionPolicy<P extends AbstractToStringConversionPolicy<P>>
    implements ToStringConversionPolicy {

    /** The class conversions. */
    protected final Map<Class<?>, ToStringConvertor<?>> classConversions = new HashMap<>();

    /** The instance conversions. */
    protected final Map<Class<?>, ToStringConvertor<?>> instanceConversions = new HashMap<>();

    /**
     * Instantiates a new to string conversion policy.
     *
     * @param convertor conversions
     */
    protected AbstractToStringConversionPolicy(ToStringConvertor<?>... convertor) {
        add(convertor);
    }

    /**
     * Instantiates a new to string conversion policy from the given policy.
     *
     * @param policy the policy
     */
    protected AbstractToStringConversionPolicy(AbstractToStringConversionPolicy<?> policy) {
        add(policy.classConversions.values().toArray(new ToStringConvertor<?>[policy.classConversions.size()]));
        add(policy.instanceConversions.values().toArray(new ToStringConvertor<?>[policy.instanceConversions.size()]));
    }

    /**
     * 添加转换器,如果出现重复绑定相当类型的转换器择抛出异常.
     *
     * @param <E> the element type
     * @param convertor 转换器
     * @return the to string conversion policy
     */
    @SuppressWarnings("unchecked")
    protected <E> P add(ToStringConvertor<E> convertor) {
        if (convertor == null) {
            return (P) this;
        }
        Class<E> type = convertor.getSourceType();
        ToStringConvertor<E> c = getConvertor(type);
        if (c != null) {
            throw new ConversionException("#type_with_muliti_convertor",
                new Object[] { type.getName(), convertor.getClass().getName(), c.getClass().getName() });
        }
        if (convertor.getPolicy() == TypePolicys.CLASS) {
            classConversions.put(type, convertor);
        } else {
            instanceConversions.put(type, convertor);
        }
        return (P) this;
    }

    /**
     * 添加转换器.
     *
     * @param convertors 转换器
     * @return the to string conversion policy
     */
    @SuppressWarnings("unchecked")
    protected P add(ToStringConvertor<?>... convertors) {
        if (Lang.isEmpty(convertors)) {
            return (P) this;
        }
        for (ToStringConvertor<?> convertor : convertors) {
            add(convertor);
        }
        return (P) this;
    }

    /**
     * 添加转换器.
     *
     * @param convertors 转换器
     * @return the to string conversion policy
     */
    @SuppressWarnings("unchecked")
    protected P add(Collection<ToStringConvertor<?>> convertors) {
        if (Lang.isEmpty(convertors)) {
            return (P) this;
        }
        for (ToStringConvertor<?> convertor : convertors) {
            add(convertor);
        }
        return (P) this;
    }

    /**
     * 放入转换器，如果传入参数的绑定类型已经有转换器绑定，则替换已绑定的转换器.
     *
     * @param convertor 转换器
     * @return the to string conversion policy
     */
    @SuppressWarnings("unchecked")
    protected P put(ToStringConvertor<?> convertor) {
        if (convertor == null) {
            return (P) this;
        }
        Class<?> type = convertor.getSourceType();
        classConversions.put(type, convertor);
        return (P) this;
    }

    /**
     * 放入转换策略，如果传入参数的转换策略中的转换器绑定类型已经有转换器绑定，则替换已绑定的转换器.
     *
     * @param conversionPolicy 转换策略
     * @return the to string conversion policy
     */
    @SuppressWarnings("unchecked")
    protected P put(AbstractToStringConversionPolicy<?> conversionPolicy) {
        if (conversionPolicy == null) {
            return (P) this;
        }
        for (ToStringConvertor<?> convertor : conversionPolicy.getConvertors()) {
            put(convertor);
        }
        return (P) this;
    }

    /**
     * 放入转换器，如果传入参数的绑定类型已经有转换器绑定，则替换已绑定的转换器.
     *
     * @param convertors 转换器
     * @return the to string conversion policy
     */
    @SuppressWarnings("unchecked")
    protected P put(ToStringConvertor<?>... convertors) {
        if (Lang.isEmpty(convertors)) {
            return (P) this;
        }
        for (ToStringConvertor<?> convertor : convertors) {
            put(convertor);
        }
        return (P) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasConvertor(Class<?> type) {
        return classConversions.containsKey(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> ToStringConvertor<E> getConvertor(Type<E> type) {
        return getConvertor(type.getType());
    }

    @SuppressWarnings("unchecked")
    private <E> ToStringConvertor<E> getConvertor(Class<E> type) {
        ToStringConvertor<E> convertor = (ToStringConvertor<E>) classConversions.get(type);
        convertor = convertor == null ? getCommonConvertor(type) : convertor;
        if (convertor != null) {
            return convertor;
        }

        for (Entry<Class<?>, ToStringConvertor<?>> entry : instanceConversions.entrySet()) {
            if (ClassUtils.isParent(entry.getKey(), type)) {
                return (ToStringConvertor<E>) entry.getValue();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private <E> ToStringConvertor<E> getCommonConvertor(Class<E> type) {
        if (type.isEnum()) {
            return (ToStringConvertor<E>) classConversions.get(Enum.class);
        } else if (type.isArray()) {
            // TODO 之后使用特殊的数组转换，找到其中的每一个类型，然后再使用其转换器转换， 如同CollectionConvertor的实现方式
            return (ToStringConvertor<E>) classConversions.get(Array.class);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<ToStringConvertor<?>> getConvertors() {
        return new ArrayList<>(classConversions.values());
    }
}
