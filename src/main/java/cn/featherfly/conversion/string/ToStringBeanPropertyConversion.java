
package cn.featherfly.conversion.string;

import java.util.HashMap;
import java.util.Map;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.BeanPropertyConversion;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.annotation.Assign;

/**
 * 使用BeanProperty作为参数的转换器.
 *
 * @author 钟冀
 */
public class ToStringBeanPropertyConversion extends AbstractToStringConversion
    implements BeanPropertyConversion<String> {

    private static final Map<Class<? extends ToStringConvertor<?>>,
        ToStringConvertor<?>> ASSIGN_CONVERSIONS = new HashMap<>();

    /**
     * 使用ToStringConversionPolicys.FORMAT_CONVERSION_POLICY.
     */
    public ToStringBeanPropertyConversion() {
        super(ToStringConversionPolicys.FORMAT_CONVERSION_POLICY);
    }

    /**
     * 构造函数.
     *
     * @param conversionPolicy conversionPolicy
     */
    public ToStringBeanPropertyConversion(ToStringConversionPolicy conversionPolicy) {
        super(conversionPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, G extends Type<String>> String sourceToTarget(S source, BeanProperty<?, S> beanProperty, G targetType) {
        return sourceToString(source, beanProperty);
    }

    /**
     * 对象转换为字符串.
     *
     * @param <S> 泛型
     * @param source 对象
     * @param beanProperty 指定对象的指定属性，否则为null
     * @return 字符串
     */
    public <S> String sourceToTarget(S source, BeanProperty<?, S> beanProperty) {
        return sourceToString(source, beanProperty);
    }

    /**
     * 对象转换为字符串.
     *
     * @param <S> 泛型
     * @param source 对象
     * @param beanProperty 指定对象的指定属性，否则为null
     * @return 字符串
     */
    @SuppressWarnings("unchecked")
    public <S> String sourceToString(S source, BeanProperty<?, S> beanProperty) {
        if (source == null) {
            return null;
        }
        Assign assign = beanProperty.getAnnotation(Assign.class);
        if (assign != null && assignable) {
            logger.debug("类 {} 的属性 {} 指定了转换器{} 使用该转换器进行转换", beanProperty.getOwnerType().getName(),
                beanProperty.getName(), assign.conversion().getClass().getName());
            Class<ToStringConvertor<S>> ct = (Class<ToStringConvertor<S>>) assign.conversion();
            return getAssignConvertor(ct, beanProperty).sourceToTarget(source, beanProperty);
        } else {
            check();
            return getConvertor(beanProperty).sourceToTarget(source, beanProperty);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <E> E targetToSource(String value, BeanProperty<?, E> beanProperty) {
        Assign assign = beanProperty.getAnnotation(Assign.class);
        if (assign != null && assignable) {
            logger.debug("类 {} 的属性 {} 指定了转换器{} 使用该转换器进行转换", beanProperty.getOwnerType().getName(),
                beanProperty.getName(), assign.conversion().getClass().getName());
            Class<ToStringConvertor<E>> ct = (Class<ToStringConvertor<E>>) assign.conversion();
            return getAssignConvertor(ct, beanProperty).targetToSource(value, beanProperty);
        } else {
            check();
            return getConvertor(beanProperty).targetToSource(value, beanProperty);
        }
    }

    @SuppressWarnings("unchecked")
    private <E> ToStringConvertor<E> getAssignConvertor(Class<ToStringConvertor<E>> conversionType,
        BeanProperty<?, ?> beanProperty) {
        ToStringConvertor<?> conversion = ASSIGN_CONVERSIONS.get(conversionType);
        if (conversion == null) {
            conversion = BeanUtils.instantiateClass(conversionType);
            if (conversion.getSourceType() != beanProperty.getType()) {
                throw new ConversionException("#type_with_error_convertor",
                    new Object[] { beanProperty.getOwnerType().getName(), beanProperty.getName(),
                        beanProperty.getType().getName(), conversionType.getName(),
                        conversion.getSourceType().getName() });
            }
        }
        return (ToStringConvertor<E>) conversion;
    }

    // ********************************************************************
    //
    // ********************************************************************

    private boolean assignable = true;

    /**
     * 返回是否开启指派类型转换器.
     *
     * @return assignable
     */
    public boolean isAssignable() {
        return assignable;
    }

    /**
     * 设置是否开启指派类型转换器.
     *
     * @param assignable assignable
     */
    public void setAssignable(boolean assignable) {
        this.assignable = assignable;
    }
}
