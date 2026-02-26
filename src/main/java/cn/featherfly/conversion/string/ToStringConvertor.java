package cn.featherfly.conversion.string;

import cn.featherfly.conversion.Convertor;
import cn.featherfly.conversion.TypePolicys;

/**
 * to string convertor.
 *
 * @author 钟冀
 * @param <S> 类型
 */
public interface ToStringConvertor<S> extends Convertor<S, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    default Class<String> getTargetType() {
        return String.class;
    }

    /**
     * Gets the policy.
     *
     * @return the policy
     */
    TypePolicys getPolicy();
}
