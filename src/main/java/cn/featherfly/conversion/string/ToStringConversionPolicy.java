
package cn.featherfly.conversion.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.TypePolicys;

/**
 * <p>
 * 转换策略
 * </p>
 *
 * @author 钟冀
 */
public class ToStringConversionPolicy implements Cloneable {

    private Map<Class<?>, ToStringConvertor<?>> conversions = new HashMap<>();
    private Map<Class<?>, ToStringConvertor<?>> conversions2 = new HashMap<>();

    /**
     */
    public ToStringConversionPolicy() {
    }

    /**
     * @param convertor conversions
     */
    public ToStringConversionPolicy(ToStringConvertor<?>... convertor) {
        addConvertors(convertor);
    }

    /**
     * <p>
     * 添加转换器,如果出现重复绑定相当类型的转换器择抛出异常
     * </p>
     *
     * @param convertor 转换器
     */
    public <E> void add(ToStringConvertor<E> convertor) {
        if (conversions != null) {
            Class<E> type = convertor.getSourceType();
            ToStringConvertor<E> c = getConvertor(type);
            if (c != null) {
                throw new ConversionException("#type_with_muliti_convertor",
                        new Object[] { type.getName(), convertor.getClass().getName(), c.getClass().getName() });
            }
            if (convertor.getPolicy() == TypePolicys.CLASS) {
                conversions.put(type, convertor);
            } else {
                conversions2.put(type, convertor);
            }
        }
    }

    /**
     * <p>
     * 放入转换器，如果传入参数的绑定类型已经有转换器绑定，则替换已绑定的转换器
     * </p>
     *
     * @param convertor 转换器
     */
    public void put(ToStringConvertor<?> convertor) {
        if (conversions != null) {
            Class<?> type = convertor.getSourceType();
            conversions.put(type, convertor);
        }
    }

    /**
     * <p>
     * 添加转换策略,如果新添加的转换策略中出现重复绑定相当类型的转换器择抛出异常
     * </p>
     *
     * @param conversionPolicy 转换策略
     */
    public void add(ToStringConversionPolicy conversionPolicy) {
        if (conversionPolicy != null) {
            for (ToStringConvertor<?> convertor : conversionPolicy.getConvertors()) {
                add(convertor);
            }
        }
    }

    /**
     * <p>
     * 放入转换策略，如果传入参数的转换策略中的转换器绑定类型已经有转换器绑定，则替换已绑定的转换器
     * </p>
     *
     * @param conversionPolicy 转换策略
     */
    public void put(ToStringConversionPolicy conversionPolicy) {
        if (conversionPolicy != null) {
            for (ToStringConvertor<?> convertor : conversionPolicy.getConvertors()) {
                put(convertor);
            }
        }
    }

    /**
     * <p>
     * 放入转换器，如果传入参数的绑定类型已经有转换器绑定，则替换已绑定的转换器
     * </p>
     *
     * @param convertors 转换器
     */
    public void put(ToStringConvertor<?>... convertors) {
        if (convertors != null) {
            for (ToStringConvertor<?> convertor : convertors) {
                put(convertor);
            }
        }
    }

    /**
     * <p>
     * 添加转换器
     * </p>
     *
     * @param convertors 转换器
     */
    public void addConvertors(ToStringConvertor<?>... convertors) {
        if (convertors != null) {
            for (ToStringConvertor<?> convertor : convertors) {
                add(convertor);
            }
        }
    }

    /**
     * <p>
     * 添加转换器（复数）
     * </p>
     *
     * @param convertors 转换器集合
     */
    public void addConvertors(Collection<ToStringConvertor<?>> convertors) {
        if (convertors != null) {
            for (ToStringConvertor<?> convertor : convertors) {
                add(convertor);
            }
        }
    }

    //    /**
    //     * <p>
    //     * 判断是否拥有指定转换器
    //     * </p>
    //     * @param conversion 转换器
    //     * @return 是否拥有指定转换器
    //     */
    //    public boolean hasConvertor(Convertor<?> conversion) {
    //        return  conversion != null && conversions.containsValue(conversion);
    //    }

    /**
     * <p>
     * 判断是否拥有指定类型的转换器
     * </p>
     *
     * @param type 转换器指定的转换类型
     * @return 是否拥有指定类型的转换器
     */
    public boolean hasConvertor(Class<?> type) {
        return conversions.containsKey(type);
    }

    /**
     * <p>
     * 返回指定类型的转换器
     * </p>
     *
     * @param type 转换器指定的转换类型
     * @return 指定类型的转换器
     */
    public <E> ToStringConvertor<E> getConvertor(GenericType<E> type) {
        return getConvertor(type.getType());
    }

    @SuppressWarnings("unchecked")
    private <E> ToStringConvertor<E> getConvertor(Class<E> type) {
        ToStringConvertor<E> convertor = (ToStringConvertor<E>) conversions.get(type);
        if (convertor == null) {
            if (type.isEnum()) {
                convertor = (ToStringConvertor<E>) conversions.get(Enum.class);
            }
            // TODO 之后使用特殊的数组转换，找到其中的每一个类型，然后再使用其转换器转换
            //            else if (type.isArray()) {
            //                conversion = conversions.get(Array.class);
            //            }
        }
        if (convertor != null) {
            return convertor;
        }

        for (Entry<Class<?>, ToStringConvertor<?>> entry : conversions2.entrySet()) {
            if (ClassUtils.isParent(entry.getKey(), type)) {
                return (ToStringConvertor<E>) entry.getValue();
            }
        }

        return null;
    }

    /**
     * <p>
     * 返回全部转换器
     * </p>
     *
     * @return 全部转换器
     */
    public Collection<ToStringConvertor<?>> getConvertors() {
        return new ArrayList<>(conversions.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ToStringConversionPolicy clone() {
        ToStringConversionPolicy cp = new ToStringConversionPolicy();
        cp.addConvertors(new ArrayList<>(conversions.values()));
        cp.addConvertors(new ArrayList<>(conversions2.values()));
        return cp;
    }
}
