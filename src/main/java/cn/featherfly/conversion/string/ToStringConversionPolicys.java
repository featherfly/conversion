
package cn.featherfly.conversion.string;

import cn.featherfly.conversion.string.basic.BigDecimalArrayConvertor;
import cn.featherfly.conversion.string.basic.BigDecimalConvertor;
import cn.featherfly.conversion.string.basic.BigIntegerArrayConvertor;
import cn.featherfly.conversion.string.basic.BigIntegerConvertor;
import cn.featherfly.conversion.string.basic.BooleanArrayConvertor;
import cn.featherfly.conversion.string.basic.BooleanConvertor;
import cn.featherfly.conversion.string.basic.BooleanWrapperConvertor;
import cn.featherfly.conversion.string.basic.ByteArrayConvertor;
import cn.featherfly.conversion.string.basic.ByteConvertor;
import cn.featherfly.conversion.string.basic.ByteWrapperConvertor;
import cn.featherfly.conversion.string.basic.ClassArrayConvertor;
import cn.featherfly.conversion.string.basic.ClassConvertor;
import cn.featherfly.conversion.string.basic.DateArrayConvertor;
import cn.featherfly.conversion.string.basic.DateConvertor;
import cn.featherfly.conversion.string.basic.DoubleArrayConvertor;
import cn.featherfly.conversion.string.basic.DoubleConvertor;
import cn.featherfly.conversion.string.basic.DoubleWrapperConvertor;
import cn.featherfly.conversion.string.basic.EnumArrayConvertor;
import cn.featherfly.conversion.string.basic.EnumConvertor;
import cn.featherfly.conversion.string.basic.FloatArrayConvertor;
import cn.featherfly.conversion.string.basic.FloatConvertor;
import cn.featherfly.conversion.string.basic.FloatWrapperConvertor;
import cn.featherfly.conversion.string.basic.IntArrayConvertor;
import cn.featherfly.conversion.string.basic.IntConvertor;
import cn.featherfly.conversion.string.basic.IntegerConvertor;
import cn.featherfly.conversion.string.basic.LocalDateArrayConvertor;
import cn.featherfly.conversion.string.basic.LocalDateConvertor;
import cn.featherfly.conversion.string.basic.LocalDateTimeArrayConvertor;
import cn.featherfly.conversion.string.basic.LocalDateTimeConvertor;
import cn.featherfly.conversion.string.basic.LocalTimeArrayConvertor;
import cn.featherfly.conversion.string.basic.LocalTimeConvertor;
import cn.featherfly.conversion.string.basic.LongArrayConvertor;
import cn.featherfly.conversion.string.basic.LongConvertor;
import cn.featherfly.conversion.string.basic.LongWrapperConvertor;
import cn.featherfly.conversion.string.basic.ShortArrayConvertor;
import cn.featherfly.conversion.string.basic.ShortConvertor;
import cn.featherfly.conversion.string.basic.ShortWrapperConvertor;
import cn.featherfly.conversion.string.basic.SqlDateArrayConvertor;
import cn.featherfly.conversion.string.basic.SqlDateConvertor;
import cn.featherfly.conversion.string.basic.SqlTimeArrayConvertor;
import cn.featherfly.conversion.string.basic.SqlTimeConvertor;
import cn.featherfly.conversion.string.basic.SqlTimestampArrayConvertor;
import cn.featherfly.conversion.string.basic.SqlTimestampConvertor;
import cn.featherfly.conversion.string.basic.StringArrayConvertor;
import cn.featherfly.conversion.string.basic.StringBufferArrayConvertor;
import cn.featherfly.conversion.string.basic.StringBufferConvertor;
import cn.featherfly.conversion.string.basic.StringBuilderArrayConvertor;
import cn.featherfly.conversion.string.basic.StringBuilderConvertor;
import cn.featherfly.conversion.string.basic.StringConvertor;
import cn.featherfly.conversion.string.bp.BigDecimalBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.BigDecimalBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.BigIntegerBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.BigIntegerBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.DateBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.DateBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.DoubleBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.DoubleBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.DoubleWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.FloatBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.FloatBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.FloatWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.IntBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.IntBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.IntegerBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.LocalDateBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.LocalDateBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.LocalDateTimeBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.LocalDateTimeBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.LocalTimeBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.LocalTimeBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.LongBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.LongBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.LongWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.OptionalToStringConvertor;
import cn.featherfly.conversion.string.bp.ShortBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.ShortBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.ShortWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.SqlDateBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.SqlDateBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.SqlTimeBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.SqlTimeBeanPropertyFormatConvertor;
import cn.featherfly.conversion.string.bp.SqlTimestampBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.string.bp.SqlTimestampBeanPropertyFormatConvertor;

/**
 * <p>
 * 一些已定义的转换策略
 * </p>
 *
 * @author 钟冀
 */
public final class ToStringConversionPolicys {

    //
    private ToStringConversionPolicys() {
    }

    /*
     * 基本转换策略
     */
    private static final ToStringConversionPolicy BASIC_CONVERSION_POLICY = new ToStringConversionPolicy(
            new BooleanConvertor(), new BooleanWrapperConvertor(), new BooleanArrayConvertor(), new ByteConvertor(),
            new ByteWrapperConvertor(), new ByteArrayConvertor(), new ShortConvertor(), new ShortWrapperConvertor(),
            new ShortArrayConvertor(), new IntConvertor(), new IntegerConvertor(), new IntArrayConvertor(),
            new LongConvertor(), new LongWrapperConvertor(), new LongArrayConvertor(), new FloatConvertor(),
            new FloatWrapperConvertor(), new FloatArrayConvertor(), new DoubleConvertor(), new DoubleWrapperConvertor(),
            new DoubleArrayConvertor(), new StringConvertor(), new StringArrayConvertor(), new StringBufferConvertor(),
            new StringBufferArrayConvertor(), new StringBuilderConvertor(), new StringBuilderArrayConvertor(),
            new DateConvertor(), new DateArrayConvertor(), new ClassConvertor(), new ClassArrayConvertor(),
            new EnumConvertor<>(), new EnumArrayConvertor<>(), new BigDecimalConvertor(),
            new BigDecimalArrayConvertor(), new BigIntegerConvertor(), new BigIntegerArrayConvertor(),
            new SqlDateConvertor(), new SqlDateArrayConvertor(), new SqlTimeConvertor(), new SqlTimeArrayConvertor(),
            new SqlTimestampConvertor(), new SqlTimestampArrayConvertor()
            // 核心包升级至jdk1.8后把1.8支持的类也加入进来
            , new LocalDateConvertor(), new LocalDateArrayConvertor(), new LocalTimeConvertor(),
            new LocalTimeArrayConvertor(), new LocalDateTimeConvertor(), new LocalDateTimeArrayConvertor());

    /*
     * 带格式支持的转换策略
     */
    private static final ToStringConversionPolicy FORMAT_CONVERSION_POLICY;
    static {

        OptionalToStringConvertor optionalToStringConvertor = new OptionalToStringConvertor();
        BASIC_CONVERSION_POLICY.getConvertors().forEach(c -> {
            optionalToStringConvertor.addConvertors(c);
        });

        ToStringConversionPolicy policy = BASIC_CONVERSION_POLICY.clone();

        BASIC_CONVERSION_POLICY.add(optionalToStringConvertor);

        policy.put(new ShortBeanPropertyFormatConvertor(), new ShortWrapperBeanPropertyFormatConvertor(),
                new ShortBeanPropertyArrayFormatConvertor(), new IntBeanPropertyFormatConvertor(),
                new IntegerBeanPropertyFormatConvertor(), new IntBeanPropertyArrayFormatConvertor(),
                new LongBeanPropertyFormatConvertor(), new LongWrapperBeanPropertyFormatConvertor(),
                new LongBeanPropertyArrayFormatConvertor(), new FloatBeanPropertyFormatConvertor(),
                new FloatWrapperBeanPropertyFormatConvertor(), new FloatBeanPropertyArrayFormatConvertor(),
                new DoubleBeanPropertyFormatConvertor(), new DoubleWrapperBeanPropertyFormatConvertor(),
                new DoubleBeanPropertyArrayFormatConvertor(), new BigDecimalBeanPropertyFormatConvertor(),
                new BigDecimalBeanPropertyArrayFormatConvertor(), new BigIntegerBeanPropertyFormatConvertor(),
                new BigIntegerBeanPropertyArrayFormatConvertor(), new DateBeanPropertyFormatConvertor(),
                new DateBeanPropertyArrayFormatConvertor(), new SqlDateBeanPropertyFormatConvertor(),
                new SqlDateBeanPropertyArrayFormatConvertor(), new SqlTimeBeanPropertyFormatConvertor(),
                new SqlTimeBeanPropertyArrayFormatConvertor(), new SqlTimestampBeanPropertyFormatConvertor(),
                new SqlTimestampBeanPropertyArrayFormatConvertor(),
                // 核心包升级至jdk1.8后把1.8支持的类也加入进来
                new LocalDateBeanPropertyFormatConvertor(), new LocalDateBeanPropertyArrayFormatConvertor(),
                new LocalTimeBeanPropertyFormatConvertor(), new LocalTimeBeanPropertyArrayFormatConvertor(),
                new LocalDateTimeBeanPropertyFormatConvertor(), new LocalDateTimeBeanPropertyArrayFormatConvertor());

        OptionalToStringConvertor optionalToStringConvertor2 = new OptionalToStringConvertor();
        policy.getConvertors().forEach(c -> {
            optionalToStringConvertor2.addConvertors(c);
        });
        policy.add(optionalToStringConvertor2);

        FORMAT_CONVERSION_POLICY = policy;
    }

    /**
     * <p>
     * 获取基本类型支持的转换策略
     * </p>
     *
     * @return 基本转换策略
     */
    public static ToStringConversionPolicy getBasicConversionPolicy() {
        return BASIC_CONVERSION_POLICY.clone();
    }

    /**
     * <p>
     * 获取带格式支持的转换策略. 支持属性定义上加上注解进行指定格式格式化（支持@DateFormat和@NumberFormat）
     * </p>
     *
     * @return 带格式支持的转换策略
     */
    public static ToStringConversionPolicy getFormatConversionPolicy() {
        return FORMAT_CONVERSION_POLICY.clone();
    }

}
