
package cn.featherfly.conversion.core;

import cn.featherfly.conversion.core.basic.BigDecimalArrayConvertor;
import cn.featherfly.conversion.core.basic.BigDecimalConvertor;
import cn.featherfly.conversion.core.basic.BigIntegerArrayConvertor;
import cn.featherfly.conversion.core.basic.BigIntegerConvertor;
import cn.featherfly.conversion.core.basic.BooleanArrayConvertor;
import cn.featherfly.conversion.core.basic.BooleanConvertor;
import cn.featherfly.conversion.core.basic.BooleanWrapperConvertor;
import cn.featherfly.conversion.core.basic.ByteArrayConvertor;
import cn.featherfly.conversion.core.basic.ByteConvertor;
import cn.featherfly.conversion.core.basic.ByteWrapperConvertor;
import cn.featherfly.conversion.core.basic.ClassArrayConvertor;
import cn.featherfly.conversion.core.basic.ClassConvertor;
import cn.featherfly.conversion.core.basic.DateArrayConvertor;
import cn.featherfly.conversion.core.basic.DateConvertor;
import cn.featherfly.conversion.core.basic.DoubleArrayConvertor;
import cn.featherfly.conversion.core.basic.DoubleConvertor;
import cn.featherfly.conversion.core.basic.DoubleWrapperConvertor;
import cn.featherfly.conversion.core.basic.EnumArrayConvertor;
import cn.featherfly.conversion.core.basic.EnumConvertor;
import cn.featherfly.conversion.core.basic.FloatArrayConvertor;
import cn.featherfly.conversion.core.basic.FloatConvertor;
import cn.featherfly.conversion.core.basic.FloatWrapperConvertor;
import cn.featherfly.conversion.core.basic.IntArrayConvertor;
import cn.featherfly.conversion.core.basic.IntConvertor;
import cn.featherfly.conversion.core.basic.IntegerConvertor;
import cn.featherfly.conversion.core.basic.LongArrayConvertor;
import cn.featherfly.conversion.core.basic.LongConvertor;
import cn.featherfly.conversion.core.basic.LongWrapperConvertor;
import cn.featherfly.conversion.core.basic.ShortArrayConvertor;
import cn.featherfly.conversion.core.basic.ShortConvertor;
import cn.featherfly.conversion.core.basic.ShortWrapperConvertor;
import cn.featherfly.conversion.core.basic.SqlDateArrayConvertor;
import cn.featherfly.conversion.core.basic.SqlDateConvertor;
import cn.featherfly.conversion.core.basic.SqlTimeArrayConvertor;
import cn.featherfly.conversion.core.basic.SqlTimeConvertor;
import cn.featherfly.conversion.core.basic.SqlTimestampArrayConvertor;
import cn.featherfly.conversion.core.basic.SqlTimestampConvertor;
import cn.featherfly.conversion.core.basic.StringArrayConvertor;
import cn.featherfly.conversion.core.basic.StringBufferArrayConvertor;
import cn.featherfly.conversion.core.basic.StringBufferConvertor;
import cn.featherfly.conversion.core.basic.StringBuilderArrayConvertor;
import cn.featherfly.conversion.core.basic.StringBuilderConvertor;
import cn.featherfly.conversion.core.basic.StringConvertor;
import cn.featherfly.conversion.core.bp.BigDecimalBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.BigDecimalBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.BigIntegerBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.BigIntegerBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.DateBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.DateBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.DoubleBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.DoubleBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.DoubleWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.FloatBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.FloatBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.FloatWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.IntBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.IntBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.IntegerBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.LongBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.LongBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.LongWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.ShortBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.ShortBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.ShortWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.SqlDateBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.SqlDateBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.SqlTimeBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.SqlTimeBeanPropertyFormatConvertor;
import cn.featherfly.conversion.core.bp.SqlTimestampBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.core.bp.SqlTimestampBeanPropertyFormatConvertor;

/**
 * <p>
 * 一些已定义的转换策略
 * </p>
 *
 * @author 钟冀
 */
public final class ConversionPolicys {

    //
    private ConversionPolicys() {
    }

    /*
     * 基本转换策略
     */
    private static final ConversionPolicy BASIC_CONVERSION_POLICY = new ConversionPolicy(
                    new BooleanConvertor(), new BooleanWrapperConvertor(), new BooleanArrayConvertor()
                    , new ByteConvertor(), new ByteWrapperConvertor(), new ByteArrayConvertor()
                    , new ShortConvertor(), new ShortWrapperConvertor(), new ShortArrayConvertor()
                    , new IntConvertor(), new IntegerConvertor(), new IntArrayConvertor()
                    , new LongConvertor(), new LongWrapperConvertor(), new LongArrayConvertor()
                    , new FloatConvertor(), new FloatWrapperConvertor(), new FloatArrayConvertor()
                    , new DoubleConvertor(), new DoubleWrapperConvertor()
                    , new DoubleArrayConvertor()
                    , new StringConvertor(), new StringArrayConvertor()
                    , new StringBufferConvertor(), new StringBufferArrayConvertor()
                    , new StringBuilderConvertor(), new StringBuilderArrayConvertor()
                    , new DateConvertor(), new DateArrayConvertor()
                    , new ClassConvertor(), new ClassArrayConvertor()
                    , new EnumConvertor<>(), new EnumArrayConvertor<>()
                    , new BigDecimalConvertor(), new BigDecimalArrayConvertor()
                    , new BigIntegerConvertor(), new BigIntegerArrayConvertor()
                    , new SqlDateConvertor(), new SqlDateArrayConvertor()
                    , new SqlTimeConvertor(), new SqlTimeArrayConvertor()
                    , new SqlTimestampConvertor(), new SqlTimestampArrayConvertor()
    );

    /*
     * 带格式支持的转换策略
     */
    private static final ConversionPolicy FORMAT_CONVERSION_POLICY;
    static {
        ConversionPolicy policy =  BASIC_CONVERSION_POLICY.clone();
        policy.put(
                new ShortBeanPropertyFormatConvertor(), new ShortWrapperBeanPropertyFormatConvertor()
                    , new ShortBeanPropertyArrayFormatConvertor()
                , new IntBeanPropertyFormatConvertor(), new IntegerBeanPropertyFormatConvertor()
                    , new IntBeanPropertyArrayFormatConvertor()
                , new LongBeanPropertyFormatConvertor(), new LongWrapperBeanPropertyFormatConvertor()
                    , new LongBeanPropertyArrayFormatConvertor()
                , new FloatBeanPropertyFormatConvertor(), new FloatWrapperBeanPropertyFormatConvertor()
                    , new FloatBeanPropertyArrayFormatConvertor()
                , new DoubleBeanPropertyFormatConvertor(), new DoubleWrapperBeanPropertyFormatConvertor()
                    , new DoubleBeanPropertyArrayFormatConvertor()
                , new BigDecimalBeanPropertyFormatConvertor(), new BigDecimalBeanPropertyArrayFormatConvertor()
                , new BigIntegerBeanPropertyFormatConvertor(), new BigIntegerBeanPropertyArrayFormatConvertor()
                , new DateBeanPropertyFormatConvertor(), new DateBeanPropertyArrayFormatConvertor()
                , new SqlDateBeanPropertyFormatConvertor(), new SqlDateBeanPropertyArrayFormatConvertor()
                , new SqlTimeBeanPropertyFormatConvertor(), new SqlTimeBeanPropertyArrayFormatConvertor()
                , new SqlTimestampBeanPropertyFormatConvertor(), new SqlTimestampBeanPropertyArrayFormatConvertor()
        );
        FORMAT_CONVERSION_POLICY = policy;
    }
    

    /**
     * <p>
     * 获取基本类型支持的转换策略
     * </p>
     * @return 基本转换策略
     */
    public static ConversionPolicy getBasicConversionPolicy() {
        return BASIC_CONVERSION_POLICY.clone();
    }
    /**
     * <p>
     * 获取带格式支持的转换策略.
     * 支持属性定义上加上注解进行指定格式格式化（支持@DateFormat和@NumberFormat）
     * </p>
     * @return 带格式支持的转换策略
     */
    public static ConversionPolicy getFormatConversionPolicy() {
        return FORMAT_CONVERSION_POLICY.clone();
    }

}
