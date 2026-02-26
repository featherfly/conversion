
package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;

/**
 * 使用class类型作为参数的转换器. 此转换器的conversion设置的BeanProperty都为空.
 *
 * @author 钟冀
 */
public class ToStringTypeConversion extends AbstractToStringConversion implements ToStringConversion {

    /**
     * 使用ToStringConversionPolicys.BASIC_CONVERSION_POLICY.
     */
    public ToStringTypeConversion() {
        super(ToStringConversionPolicys.BASIC_CONVERSION_POLICY);
    }

    /**
     * 构造函数.
     *
     * @param conversionPolicy conversionPolicy
     */
    public ToStringTypeConversion(ToStringConversionPolicy conversionPolicy) {
        super(conversionPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, G extends Type<String>> String sourceToTarget(S source, G targetType) {
        if (source == null) {
            return null;
        }
        Type<S> sourceType = new ClassType<>(ClassUtils.castGenericType(source.getClass(), source));
        check();
        return getConvertor(sourceType).sourceToTarget(source, sourceType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, G extends Type<S>> S targetToSource(String value, G genericType) {
        if (Lang.isEmpty(value)) {
            return null;
        }
        check();
        return getConvertor(genericType).targetToSource(value, genericType);
    }
}
