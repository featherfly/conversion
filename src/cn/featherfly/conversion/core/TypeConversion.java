
package cn.featherfly.conversion.core;

import cn.featherfly.common.lang.reflect.GenericClass;




/**
 * <p>
 * 使用class类型作为参数的转换器.
 * 此转换器的conversion设置的BeanProperty都为空.
 * </p>
 *
 * @author 钟冀
 */
public class TypeConversion extends AbstractConversion<GenericClass<?>>{

    /**
     * 使用BASIC_CONVERSION_POLICY
     */
    public TypeConversion() {
        super();
    }
    /**
     * 构造函数
     * @param conversionPolicy conversionPolicy
     */
    public TypeConversion(ConversionPolicy conversionPolicy) {
        super(conversionPolicy);
    }

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * @param <E> 泛型
     * @param value 对象
     * @param genericClass 对象类型
     * @return 字符串
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> String toString(E value, GenericClass<?> genericClass) {
        check();
        return getConvertor((Class<E>) genericClass.getType()).toString(value, (GenericClass<E>) genericClass);
    }
    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * @param <E> 泛型
     * @param value 对象
     * @param type 对象类型
     * @return 字符串
     */
    public <E> String toString(E value, Class<E> type) {
        return toString(value, new GenericClass<E>(type));
    }

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * @param <E> 泛型
     * @param value 字符串
     * @param genericClass 对象类型
     * @return 对象
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E toObject(String value, GenericClass<?> genericClass) {
        check();
        return getConvertor((Class<E>) genericClass.getType()).toObject(value, (GenericClass<E>) genericClass);
    }
    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * @param <E> 泛型
     * @param value 字符串
     * @param type 对象类型
     * @return 对象
     */
    public <E> E toObject(String value, Class<E> type) {
        return toObject(value, new GenericClass<E>(type)); 
    }
}
