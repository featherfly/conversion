
package cn.featherfly.conversion.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 转换策略
 * </p>
 *
 * @author 钟冀
 */
public class ConversionPolicy implements Cloneable{

    private Map<Class<?>, Convertor<?>> conversions = new HashMap<Class<?>, Convertor<?>>();

    /**
     */
    public ConversionPolicy() {
    }
    /**
     *
     * @param convertor conversions
     */
    public ConversionPolicy(Convertor<?>...convertor) {
        addConvertors(convertor);
    }

    /**
     * <p>
     * 添加转换器,如果出现重复绑定相当类型的转换器择抛出异常
     * </p>
     * @param convertor 转换器
     */
    public void add(Convertor<?> convertor) {
        if (conversions != null) {
            Class<?> type = convertor.getType();
            Convertor<?> c = getConvertor(type);
            if (c != null) {
                throw new ConversionException(
                    String.format("为类型%s绑定了多个转换器[%s , %s]"
                            , type.getName(), convertor.getClass().getName()
                            , c.getClass().getName()));
            }
            conversions.put(type, convertor);
        }
    }
    
    /**
     * <p>
     * 放入转换器，如果传入参数的绑定类型已经有转换器绑定，则替换已绑定的转换器
     * </p>
     * @param convertor 转换器
     */
    public void put(Convertor<?> convertor) {
        if (conversions != null) {
            Class<?> type = convertor.getType();            
            conversions.put(type, convertor);
        }
    }
    
    /**
     * <p>
     * 放入转换器，如果传入参数的绑定类型已经有转换器绑定，则替换已绑定的转换器
     * </p>
     * @param convertors 转换器
     */
    public void put(Convertor<?>...convertors) {
        if (convertors != null) {
            for (Convertor<?> convertor : convertors) {
                put(convertor);
            }
        }
    }
    
    

    /**
     * <p>
     * 添加转换器
     * </p>
     * @param convertors 转换器
     */
    public void addConvertors(Convertor<?>...convertors) {
        if (convertors != null) {
            for (Convertor<?> convertor : convertors) {
                add(convertor);
            }
        }
    }
    /**
     * <p>
     * 添加转换器（复数）
     * </p>
     * @param convertors 转换器集合
     */
    public void addConvertors(Collection<Convertor<?>> convertors) {
        if (convertors != null) {
            for (Convertor<?> convertor : convertors) {
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
     * @param type 转换器指定的转换类型
     * @return 指定类型的转换器
     */
    public Convertor<?> getConvertor(Class<?> type) {
        Convertor<?> conversion = conversions.get(type);
        if (conversion == null) {
            if (type.isEnum()) {
                conversion = conversions.get(Enum.class);
            }
            // TODO 之后使用特殊的数组转换，找到其中的每一个类型，然后再使用其转换器转换
//            else if (type.isArray()) {
//                conversion = conversions.get(Array.class);
//            }
        }
        return conversion;
    }

    /**
     * <p>
     * 返回全部转换器
     * </p>
     * @return 全部转换器
     */
    public Collection<Convertor<?>> getConvertors() {
        return new ArrayList<Convertor<?>>(conversions.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConversionPolicy clone() {
        ConversionPolicy cp = new ConversionPolicy();
        cp.addConvertors(new ArrayList<Convertor<?>>(this.conversions.values()));
        return cp;
    }
}
