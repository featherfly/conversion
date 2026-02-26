
package cn.featherfly.conversion;

import cn.featherfly.common.lang.reflect.Type;

/**
 * 转换器.
 *
 * @author 钟冀
 * @param <S> the generic type
 * @param <T> 类型
 */
public interface Convertor<S, T> {

    /**
     * 返回转换器支持的转换源的类型.
     *
     * @return 转换器对应的类型
     */
    Class<S> getSourceType();

    /**
     * 返回转换器支持的转换目标的类型.
     *
     * @return 转换器对应的类型
     */
    Class<T> getTargetType();

    /**
     * 转换源对象到目标类型对象.
     *
     * @param <G> Type子类泛型
     * @param source 需要转换的对象
     * @param genericType 需要转换的对象的上下文属性
     * @return 字符串
     */
    <G extends Type<S>> T sourceToTarget(S source, G genericType);

    /**
     * 转换目标对象到源类型对象.
     *
     * @param <G> Type子类泛型
     * @param target 需要转换的对象
     * @param genericType 指定对象的上下文属性
     * @return 源类型对象
     */
    <G extends Type<S>> S targetToSource(T target, G genericType);
}
