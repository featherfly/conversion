
package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * 转换器
 * </p>
 *
 * @author 钟冀
 */
public interface ToStringConversion {
    /**
     * <p>
     * 对象转换为字符串
     * </p>
     *
     * @param value       对象
     * @param genericType 指定对象的上下文属性
     * @param <S>         泛型
     * @return 字符串
     */
    <S, G extends Type<S>> String sourceToTarget(S value, G genericType);

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     *
     * @param value       字符串
     * @param genericType 指定对象的上下文属性
     * @param <S>         泛型
     * @return 对象
     */
    <S, G extends Type<S>> S targetToSource(String value, G genericType);
}
