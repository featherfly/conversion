
package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.reflect.GenericClass;

/**
 * <p>
 * 使用class类型作为参数的转换器. 此转换器的conversion设置的BeanProperty都为空.
 * </p>
 *
 * @author 钟冀
 */
public class ToStringTypeConversion extends AbstractToStringConversion {

    /**
     * 使用BASIC_CONVERSION_POLICY
     */
    public ToStringTypeConversion() {
        super();
    }

    /**
     * 构造函数
     *
     * @param conversionPolicy conversionPolicy
     */
    public ToStringTypeConversion(ToStringConversionPolicy conversionPolicy) {
        super(conversionPolicy);
    }

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     *
     * @param <E>          泛型
     * @param value        对象
     * @param genericClass 对象类型
     * @return 字符串
     */
    @Override
    public <S, G extends GenericType<S>> String sourceToTarget(S value, G genericClass) {
        check();
        return getConvertor(genericClass).sourceToTarget(value, genericClass);
    }

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     *
     * @param <E>   泛型
     * @param value 对象
     * @param type  对象类型
     * @return 字符串
     */
    public <E> String sourceToTarget(E value, Class<E> type) {
        return sourceToTarget(value, new GenericClass<>(type));
    }

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     *
     * @param <S>          泛型
     * @param value        字符串
     * @param genericClass 对象类型
     * @return 对象
     */
    @Override
    public <S, G extends GenericType<S>> S targetToSource(String value, G genericClass) {
        check();
        return getConvertor(genericClass).targetToSource(value, genericClass);
    }

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     *
     * @param <E>   泛型
     * @param value 字符串
     * @param type  对象类型
     * @return 对象
     */
    public <E> E targetToSource(String value, Class<E> type) {
        return targetToSource(value, new GenericClass<>(type));
    }
}
