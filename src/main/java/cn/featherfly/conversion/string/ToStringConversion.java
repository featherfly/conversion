
package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.reflect.Type;

/**
 * 转换器.
 *
 * @author 钟冀
 */
public interface ToStringConversion {

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * .
     *
     * @param <S>         泛型
     * @param <G>         the generic type
     * @param value       对象
     * @param genericType 指定对象的上下文属性
     * @return 字符串
     */
    <S, G extends Type<S>> String sourceToTarget(S value, G genericType);

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * .
     *
     * @param <S>         泛型
     * @param <G>         the generic type
     * @param value       字符串
     * @param genericType 指定对象的上下文属性
     * @return 对象
     */
    <S, G extends Type<S>> S targetToSource(String value, G genericType);
}
