package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.Convertor;
import cn.featherfly.conversion.TypePolicys;

/**
 * <p>
 * 转换器
 * </p>
 *
 * @param <S> 类型
 * @author 钟冀
 */
public interface ToStringConvertor<S> extends Convertor<S, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    default Class<String> getTargetType() {
        return String.class;
    }

    TypePolicys getPolicy();

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     *
     * @param value       对象
     * @param genericType 指定对象的上下文属性
     * @param <GT>        GenericType子类泛型
     * @return 字符串
     */
    @Override
    <GT extends GenericType<S>> String sourceToTarget(S value, GT genericType);

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     *
     * @param value       字符串
     * @param genericType 指定对象的上下文属性
     * @param <GT>        GenericType子类泛型
     * @return 对象
     */
    @Override
    <GT extends GenericType<S>> S targetToSource(String value, GT genericType);
}
