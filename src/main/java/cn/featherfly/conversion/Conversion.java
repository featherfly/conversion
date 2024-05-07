
package cn.featherfly.conversion;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;

/**
 * 转换.
 *
 * @author     钟冀
 * @param  <T> target type
 */
public interface Conversion<T> {

    /**
     * 指定类型转换为目标类型 .
     *
     * @param  <S>        source type
     * @param  source     the source
     * @param  targetType the target type
     * @return            字符串
     */
    default <S> T sourceToTarget(S source, Class<T> targetType) {
        return sourceToTarget(source, new ClassType<>(targetType));
    }

    /**
     * 指定类型转换为目标类型 .
     *
     * @param  <S>        source type
     * @param  <G>        target generic type
     * @param  source     the source
     * @param  targetType the target type
     * @return            字符串
     */
    default <S, G extends Type<T>> T sourceToTarget(S source, G targetType) {
        return sourceToTarget(source,
            Lang.ifNotNull(source, v -> new ClassType<>(ClassUtils.castGenericType(source.getClass(), source))),
            targetType);
    }

    /**
     * 指定类型转换为目标类型 .
     *
     * @param  <S>        source type
     * @param  <G>        source generic type
     * @param  source     the source
     * @param  sourceType the source type
     * @param  targetType the target type
     * @return            字符串
     */
    default <S, G extends Type<S>> T sourceToTarget(S source, G sourceType, Class<T> targetType) {
        return sourceToTarget(source, sourceType, new ClassType<>(targetType));
    }

    /**
     * 指定类型转换为目标类型 .
     *
     * @param  <S>        source type
     * @param  <G>        source generic type
     * @param  <G2>       target generic type
     * @param  source     the source
     * @param  sourceType the source type
     * @param  tagetType  the taget type
     * @return            字符串
     */
    <S, G extends Type<S>, G2 extends Type<T>> T sourceToTarget(S source, G sourceType, G2 tagetType);

    /**
     * 目标类型转换为指定类型.
     *
     * @param  <S>        source type
     * @param  target     the target
     * @param  sourceType the source type
     * @return            source value
     */
    default <S> S targetToSource(T target, Class<S> sourceType) {
        return targetToSource(target, new ClassType<>(sourceType));
    }

    /**
     * 目标类型转换为指定类型.
     *
     * @param  <S>        source type
     * @param  <G>        source generic type
     * @param  target     the target
     * @param  sourceType the source type
     * @return            对象
     */
    default <S, G extends Type<S>> S targetToSource(T target, G sourceType) {
        return targetToSource(target,
            Lang.ifNotNull(target, v -> new ClassType<>(ClassUtils.castGenericType(target.getClass(), target))),
            sourceType);
    }

    /**
     * 目标类型转换为指定类型.
     *
     * @param  <S>        source type
     * @param  <G>        source generic type
     * @param  <G2>       target generic type
     * @param  target     the target
     * @param  targetType the target type
     * @param  sourceType the source type
     * @return            对象
     */
    <S, G extends Type<T>, G2 extends Type<S>> S targetToSource(T target, G targetType, G2 sourceType);
}
