
package cn.featherfly.conversion.core;

import cn.featherfly.common.lang.GenericType;

/**
 * <p>
 * 转换器
 * </p>
 * @param <T> 类型
 * @author 钟冀
 */
public interface Convertor<T> {
    /**
     * <p>
     * 返回转换器对应的类型
     * </p>
     * @return 转换器对应的类型
     */
    Class<T> getType();
    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * @param value 对象
     * @param genericType 指定对象的上下文属性
     * @param <GT> GenericType子类泛型
     * @return 字符串
     */
    <GT extends GenericType<T>> String toString(T value, GT genericType);
    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * @param value 字符串
     * @param genericType 指定对象的上下文属性
     * @param <GT> GenericType子类泛型
     * @return 对象
     */
    <GT extends GenericType<T>> T toObject(String value, GT genericType);
}
