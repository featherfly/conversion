
package cn.featherfly.conversion.core;

import cn.featherfly.conversion.core.basic.LocalDateArrayConvertor;
import cn.featherfly.conversion.core.basic.LocalDateConvertor;
import cn.featherfly.conversion.core.basic.LocalDateTimeArrayConvertor;
import cn.featherfly.conversion.core.basic.LocalDateTimeConvertor;
import cn.featherfly.conversion.core.basic.LocalTimeArrayConvertor;
import cn.featherfly.conversion.core.basic.LocalTimeConvertor;
import cn.featherfly.conversion.core.bp.LocalDateBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.LocalDateBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.LocalDateTimeBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.LocalDateTimeBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.LocalTimeBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.LocalTimeBeanPropertyFormatConvertor;

/**
 * <p>
 * ConversionPolicysJdk8
 * </p>
 *
 * @author 钟冀
 * @deprecated ConversionPolicys已经升级至jdk8支持，此类只是为了兼容历史遗留
 */
@Deprecated
public final class ConversionPolicysJdk8 {

    //
    private ConversionPolicysJdk8() {
    }

    /*
     * 基本转换策略
     */
    private static final ConversionPolicy BASIC_TIME_CONVERSION_POLICY = new ConversionPolicy(new LocalDateConvertor(),
            new LocalDateArrayConvertor(), new LocalTimeConvertor(), new LocalTimeArrayConvertor(),
            new LocalDateTimeConvertor(), new LocalDateTimeArrayConvertor());

    /*
     * 带格式支持的转换策略
     */
    private static final ConversionPolicy FORMAT_TIME_CONVERSION_POLICY;
    static {
        ConversionPolicy policy = BASIC_TIME_CONVERSION_POLICY.clone();
        policy.put(new LocalDateBeanPropertyFormatConvertor(), new LocalDateBeanPropertyArrayFormatConvertor(),
                new LocalTimeBeanPropertyFormatConvertor(), new LocalTimeBeanPropertyArrayFormatConvertor(),
                new LocalDateTimeBeanPropertyFormatConvertor(), new LocalDateTimeBeanPropertyArrayFormatConvertor());
        FORMAT_TIME_CONVERSION_POLICY = policy;
    }

    /**
     * <p>
     * 获取java.time基本类型支持的转换策略
     * </p>
     *
     * @return 基本转换策略
     */
    public static ConversionPolicy getBasicTimeConversionPolicy() {
        return BASIC_TIME_CONVERSION_POLICY.clone();
    }

    /**
     * <p>
     * 获取java.time带格式支持的转换策略. 支持属性定义上加上注解进行指定格式格式化（支持@DateFormat和@NumberFormat）
     * </p>
     *
     * @return 带格式支持的转换策略
     */
    public static ConversionPolicy getFormatTimeConversionPolicy() {
        return FORMAT_TIME_CONVERSION_POLICY.clone();
    }

    /**
     * <p>
     * 获取支持java.time的基本类型支持的转换策略
     * </p>
     *
     * @return 基本转换策略
     */
    public static ConversionPolicy getBasicConversionPolicy() {
        return ConversionPolicys.getBasicConversionPolicy().clone();
    }

    /**
     * <p>
     * 获取支持java.time的带格式支持的转换策略.
     * 支持属性定义上加上注解进行指定格式格式化（支持@DateFormat和@NumberFormat）
     * </p>
     *
     * @return 带格式支持的转换策略
     */
    public static ConversionPolicy getFormatConversionPolicy() {
        return ConversionPolicys.getFormatConversionPolicy().clone();
    }
}
