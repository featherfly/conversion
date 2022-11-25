
package cn.featherfly.conversion;

import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * 转换器
 * </p>
 *
 * @param <T> 类型
 * @author 钟冀
 */
public interface Convertor<S, T> {
    /**
     * <p>
     * 返回转换器支持的转换源的类型
     * </p>
     *
     * @return 转换器对应的类型
     */
    Class<S> getSourceType();

    /**
     * <p>
     * 返回转换器支持的转换目标的类型
     * </p>
     *
     * @return 转换器对应的类型
     */
    Class<T> getTargetType();

    /**
     * <p>
     * 转换源对象到目标类型对象
     * </p>
     *
     * @param source      需要转换的对象
     * @param genericType 需要转换的对象的上下文属性
     * @param <GS>        Type子类泛型
     * @return 字符串
     */
    <GS extends Type<S>> T sourceToTarget(S source, GS genericType);

    /**
     * <p>
     * 转换目标对象到源类型对象
     * </p>
     *
     * @param target      需要转换的对象
     * @param genericType 指定对象的上下文属性
     * @param <GT>        Type子类泛型
     * @return 源类型对象
     */
    <GT extends Type<S>> S targetToSource(T target, GT genericType);
}
