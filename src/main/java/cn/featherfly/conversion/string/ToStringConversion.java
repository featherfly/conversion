
package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.Conversion;

/**
 * 转换器.
 *
 * @author 钟冀
 */
public interface ToStringConversion extends Conversion<String> {

    /**
     * 指定类型转换为目标类型 .
     *
     * @param  <S>    the generic type
     * @param  source the source
     * @return        string
     */
    default <S> String sourceToString(S source) {
        return sourceToTarget(source, ClassType.STRING);
    }

    /**
     * 指定类型转换为目标类型 .
     *
     * @param  <S>        the generic type
     * @param  <G>        the generic type
     * @param  source     the source
     * @param  sourceType the source type
     * @return            string
     */
    default <S, G extends Type<S>> String sourceToString(S source, G sourceType) {
        return sourceToTarget(source, sourceType, ClassType.STRING);
    }

    //    /**
    //     * 对象转换为字符串.
    //     *
    //     * @param <S>         泛型
    //     * @param <G>         the generic type
    //     * @param value       对象
    //     * @param genericType 指定对象的上下文属性
    //     * @return 字符串
    //     */
    //    <S, G extends Type<S>> String sourceToTarget(S value, G genericType);
    //
    //    /**
    //     * 字符串转换为对象.
    //     *
    //     * @param <S>         泛型
    //     * @param <G>         the generic type
    //     * @param value       字符串
    //     * @param genericType 指定对象的上下文属性
    //     * @return 对象
    //     */
    //    <S, G extends Type<S>> S targetToSource(String value, G genericType);
}
