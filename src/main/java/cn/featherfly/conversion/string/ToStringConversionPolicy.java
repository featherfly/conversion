
package cn.featherfly.conversion.string;

import java.util.Collection;

import cn.featherfly.common.lang.reflect.Type;

/**
 * to string conversion readonly policy.
 *
 * @author 钟冀
 */
public interface ToStringConversionPolicy {

    /**
     * 判断是否拥有指定类型的转换器.
     *
     * @param type 转换器指定的转换类型
     * @return 是否拥有指定类型的转换器
     */
    boolean hasConvertor(Class<?> type);

    /**
     * 返回指定类型的转换器.
     *
     * @param <E> the element type
     * @param type 转换器指定的转换类型
     * @return 指定类型的转换器
     */
    <E> ToStringConvertor<E> getConvertor(Type<E> type);

    /**
     * 返回全部转换器.
     *
     * @return 全部转换器
     */
    Collection<ToStringConvertor<?>> getConvertors();
}
