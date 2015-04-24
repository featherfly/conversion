
package cn.featherfly.conversion.core;

import cn.featherfly.common.lang.GenericType;

/**
 * <p>
 * 转换器
 * </p>
 * @param <G> 类型描述
 * @author 钟冀
 */
public interface Conversion<G extends GenericType<?>> {
    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * @param value 对象
     * @param genericType 指定对象的上下文属性
     * @param <T> 泛型
     * @return 字符串
     */
    <T> String toString(T value, G genericType);
    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * @param value 字符串
     * @param genericType 指定对象的上下文属性
     * @param <T> 泛型
     * @return 对象
     */
    <T> T toObject(String value, G genericType);
}
