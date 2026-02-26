
package cn.featherfly.conversion.string;

import java.util.Collection;

import cn.featherfly.common.lang.Lang;

/**
 * 转换策略.
 *
 * @author 钟冀
 */
public class ToStringConversionPolicyImpl extends AbstractToStringConversionPolicy<ToStringConversionPolicyImpl> {

    /**
     * Instantiates a new to string conversion policy.
     */
    public ToStringConversionPolicyImpl() {
    }

    /**
     * Instantiates a new to string conversion policy.
     *
     * @param convertor conversions
     */
    public ToStringConversionPolicyImpl(ToStringConvertor<?>... convertor) {
        super(convertor);
    }

    /**
     * Instantiates a new to string conversion policy from the given policy.
     *
     * @param policy the policy
     */
    public ToStringConversionPolicyImpl(AbstractToStringConversionPolicy<?> policy) {
        super(policy);
    }

    /**
     * 添加转换器.
     *
     * @param convertors 转换器
     * @return the to string conversion policy
     */
    public ToStringConversionPolicyImpl addConvertors(ToStringConvertor<?>... convertors) {
        if (Lang.isEmpty(convertors)) {
            return this;
        }
        for (ToStringConvertor<?> convertor : convertors) {
            add(convertor);
        }
        return this;
    }

    /**
     * 添加转换器（复数）.
     *
     * @param convertors 转换器集合
     * @return the to string conversion policy
     */
    public ToStringConversionPolicyImpl addConvertors(Collection<ToStringConvertor<?>> convertors) {
        if (Lang.isEmpty(convertors)) {
            return this;
        }
        for (ToStringConvertor<?> convertor : convertors) {
            add(convertor);
        }
        return this;
    }
}
