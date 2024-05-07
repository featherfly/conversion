
package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * 使用class类型作为参数的转换器. 此转换器的conversion设置的BeanProperty都为空.
 * </p>
 *
 * @author 钟冀
 */
public class ToStringTypeConversion extends AbstractToStringConversion {

    /**
     * 使用BASIC_CONVERSION_POLICY.
     */
    public ToStringTypeConversion() {
        super();
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
    public <S, G extends Type<S>, G2 extends Type<String>> String sourceToTarget(S source, G sourceType, G2 tagetType) {
        check();
        return getConvertor(sourceType).sourceToTarget(source, sourceType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, G extends Type<S>> S targetToSource(String value, G genericType) {
        check();
        return getConvertor(genericType).targetToSource(value, genericType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, G extends Type<String>, G2 extends Type<S>> S targetToSource(String value, G valueType, G2 sourceType) {
        check();
        return getConvertor(sourceType).targetToSource(value, sourceType);
    }

}
