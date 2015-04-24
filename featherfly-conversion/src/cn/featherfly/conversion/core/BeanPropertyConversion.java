
package cn.featherfly.conversion.core;

import java.util.HashMap;
import java.util.Map;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.annotation.Assign;


/**
 * <p>
 * 使用BeanProperty作为参数的转换器.
 * </p>
 *
 * @author 钟冀
 */
public class BeanPropertyConversion extends AbstractConversion<BeanProperty<?>>{

    private static final Map<Class<? extends Convertor<?>>, Convertor<?>> ASSIGN_CONVERSIONS
        = new HashMap<Class<? extends Convertor<?>>, Convertor<?>>();

    /**
     * 使用BASIC_CONVERSION_POLICY
     */
    public BeanPropertyConversion() {
        super();
    }
    /**
     * 构造函数
     * @param conversionPolicy conversionPolicy
     */
    public BeanPropertyConversion(ConversionPolicy conversionPolicy) {
        super(conversionPolicy);
    }

    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * @param <E> 泛型
     * @param value 对象
     * @param beanProperty 指定对象的指定属性，否则为null
     * @return 字符串
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> String toString(E value, BeanProperty<?> beanProperty) {
        Assign assign = beanProperty.getAnnotation(Assign.class);
        if (assign != null && assignable) {
            logger.debug("类 {} 的属性 {} 指定了转换器{} 使用该转换器进行转换",
                    new Object[]{beanProperty.getOwnerType().getName()
                        , beanProperty.getName(), assign.conversion().getClass().getName()});
            Class<Convertor<E>> ct = (Class<Convertor<E>>) assign.conversion();
            return getAssignConvertor(ct, beanProperty).toString(value, (BeanProperty<E>) beanProperty);
        } else {
            check();
            return getConvertor(ClassUtils.castGenericType(
                    beanProperty.getType(), value))
                    .toString(value, (BeanProperty<E>)  beanProperty);
        }
    }

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * @param <E> 泛型
     * @param value 字符串
     * @param beanProperty 指定对象的指定属性，否则为null
     * @return 对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public <E> E toObject(String value, BeanProperty<?> beanProperty) {
        Assign assign = beanProperty.getAnnotation(Assign.class);
        if (assign != null && assignable) {
            logger.debug("类 {} 的属性 {} 指定了转换器{} 使用该转换器进行转换",
                new Object[]{beanProperty.getOwnerType().getName()
                    , beanProperty.getName(), assign.conversion().getClass().getName()});
            Class<Convertor<E>> ct = (Class<Convertor<E>>) assign.conversion();
            return getAssignConvertor(ct, beanProperty).toObject(value, (BeanProperty<E>)  beanProperty);
        } else {
            check();
            return getConvertor((Class<E>) beanProperty.getType())
                    .toObject(value, (BeanProperty<E>)  beanProperty);
        }
    }

    @SuppressWarnings("unchecked")
    private <E> Convertor<E> getAssignConvertor(Class<Convertor<E>> conversionType
            , BeanProperty<?> beanProperty) {
        Convertor<?> conversion = ASSIGN_CONVERSIONS.get(conversionType);
        if (conversion == null) {
            conversion = BeanUtils.instantiateClass(conversionType);
            if (conversion.getType() != beanProperty.getType()) {
                String msg = StringUtils.format("类 [#1] 的属性 [#2]->[#3] 不能使用指定的转换器 [#4]，该转换器只能转换 [#5] 类型"
                        , beanProperty.getOwnerType().getName(), beanProperty.getName()
                        , beanProperty.getType().getName(), conversionType.getName()
                        , conversion.getType().getName());
                throw new ConversionException(msg);
            }
        }
        return (Convertor<E>) conversion;
    }

    // ********************************************************************
    //
    // ********************************************************************

    private boolean assignable = true;

    /**
     * 返回是否开启指派类型转换器
     * @return assignable
     */
    public boolean isAssignable() {
        return assignable;
    }
    /**
     * 设置是否开启指派类型转换器
     * @param assignable assignable
     */
    public void setAssignable(boolean assignable) {
        this.assignable = assignable;
    }
}
