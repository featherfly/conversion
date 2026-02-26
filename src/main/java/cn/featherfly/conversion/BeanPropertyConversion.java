
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-02-25 14:52:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;

/**
 * BeanPropertyConversion.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public interface BeanPropertyConversion<T> {

    /**
     * 指定类型转换为目标类型 .
     *
     * @param <S> source type
     * @param source the source
     * @param beanProperty the bean property
     * @param targetType the target type
     * @return 字符串
     */
    default <S> T sourceToTarget(S source, BeanProperty<?, S> beanProperty, Class<T> targetType) {
        return sourceToTarget(source, beanProperty, new ClassType<>(targetType));
    }

    /**
     * 指定类型转换为目标类型 .
     *
     * @param <S> source type
     * @param <G> target generic type
     * @param source the source
     * @param beanProperty the bean property
     * @param targetType the target type
     * @return 字符串
     */
    <S, G extends Type<T>> T sourceToTarget(S source, BeanProperty<?, S> beanProperty, G targetType);

    /**
     * 目标类型转换为指定类型.
     *
     * @param <S> source type
     * @param target the target
     * @param sourceType the source type
     * @return source value
     */
    <S> S targetToSource(T target, BeanProperty<?, S> sourceType);
}
