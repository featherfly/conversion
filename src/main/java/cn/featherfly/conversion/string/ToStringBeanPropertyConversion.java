
package cn.featherfly.conversion.string;

import java.util.HashMap;
import java.util.Map;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.annotation.Assign;

/**
 * <p>
 * 使用BeanProperty作为参数的转换器.
 * </p>
 *
 * @author 钟冀
 */
public class ToStringBeanPropertyConversion extends AbstractToStringConversion {

    private static final Map<Class<? extends ToStringConvertor<?>>, ToStringConvertor<?>> ASSIGN_CONVERSIONS = new HashMap<>();

    /**
     * 使用BASIC_CONVERSION_POLICY
     */
    public ToStringBeanPropertyConversion() {
        super();
    }

    /**
     * 构造函数
     *
     * @param conversionPolicy conversionPolicy
     */
    public ToStringBeanPropertyConversion(ToStringConversionPolicy conversionPolicy) {
        super(conversionPolicy);
    }

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     *
     * @param <E>         泛型
     * @param value       对象
     * @param genericType 指定对象的指定属性，否则为null
     * @return 字符串
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E, G extends GenericType<E>> String sourceToTarget(E value, G genericType) {
        if (genericType instanceof BeanProperty) {
            return sourceToTarget(value, (BeanProperty<E>) genericType);
        }
        throw new ConversionException("#type_with_muliti_convertor",
                new Object[] { this.getClass().getName(), genericType.getClass().getName() });
    }

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     *
     * @param <E>          泛型
     * @param value        对象
     * @param beanProperty 指定对象的指定属性，否则为null
     * @return 字符串
     */
    @SuppressWarnings("unchecked")
    public <E> String sourceToTarget(E value, BeanProperty<E> beanProperty) {
        Assign assign = beanProperty.getAnnotation(Assign.class);
        if (assign != null && assignable) {
            logger.debug("类 {} 的属性 {} 指定了转换器{} 使用该转换器进行转换", new Object[] { beanProperty.getOwnerType().getName(),
                    beanProperty.getName(), assign.conversion().getClass().getName() });
            Class<ToStringConvertor<E>> ct = (Class<ToStringConvertor<E>>) assign.conversion();
            return getAssignConvertor(ct, beanProperty).sourceToTarget(value, beanProperty);
        } else {
            check();
            //            if (beanProperty.getType() == Optional.class) {
            //                BeanPropertyContainerType<E> ct = new BeanPropertyContainerType<>(beanProperty);
            //                return getConvertor(ct).sourceToTarget(((Optional<E>) value).get(), ct);
            //            }
            return getConvertor(beanProperty).sourceToTarget(value, beanProperty);
        }
    }

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     *
     * @param <E>         泛型
     * @param value       字符串
     * @param genericType 指定对象的指定属性，否则为null
     * @return 对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public <E, G extends GenericType<E>> E targetToSource(String value, G genericType) {
        if (genericType instanceof BeanProperty) {
            return targetToSource(value, (BeanProperty<E>) genericType);
        }
        throw new ConversionException("#type_with_muliti_convertor",
                new Object[] { this.getClass().getName(), genericType.getClass().getName() });
    }

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     *
     * @param <E>          泛型
     * @param value        字符串
     * @param beanProperty 指定对象的指定属性，否则为null
     * @return 对象
     */
    @SuppressWarnings("unchecked")
    public <E> E targetToSource(String value, BeanProperty<E> beanProperty) {
        Assign assign = beanProperty.getAnnotation(Assign.class);
        if (assign != null && assignable) {
            logger.debug("类 {} 的属性 {} 指定了转换器{} 使用该转换器进行转换", new Object[] { beanProperty.getOwnerType().getName(),
                    beanProperty.getName(), assign.conversion().getClass().getName() });
            Class<ToStringConvertor<E>> ct = (Class<ToStringConvertor<E>>) assign.conversion();
            return getAssignConvertor(ct, beanProperty).targetToSource(value, beanProperty);
        } else {
            check();
            return getConvertor(beanProperty).targetToSource(value, beanProperty);
        }
    }

    @SuppressWarnings("unchecked")
    private <E> ToStringConvertor<E> getAssignConvertor(Class<ToStringConvertor<E>> conversionType,
            BeanProperty<?> beanProperty) {
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
     * 返回是否开启指派类型转换器
     *
     * @return assignable
     */
    public boolean isAssignable() {
        return assignable;
    }

    /**
     * 设置是否开启指派类型转换器
     *
     * @param assignable assignable
     */
    public void setAssignable(boolean assignable) {
        this.assignable = assignable;
    }
}
