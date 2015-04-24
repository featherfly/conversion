
package cn.featherfly.conversion;

import cn.featherfly.conversion.basic.BigDecimalArrayConvertor;
import cn.featherfly.conversion.basic.BigDecimalConvertor;
import cn.featherfly.conversion.basic.BigIntegerArrayConvertor;
import cn.featherfly.conversion.basic.BigIntegerConvertor;
import cn.featherfly.conversion.basic.BooleanArrayConvertor;
import cn.featherfly.conversion.basic.BooleanConvertor;
import cn.featherfly.conversion.basic.BooleanWrapperConvertor;
import cn.featherfly.conversion.basic.ByteArrayConvertor;
import cn.featherfly.conversion.basic.ByteConvertor;
import cn.featherfly.conversion.basic.ByteWrapperConvertor;
import cn.featherfly.conversion.basic.ClassArrayConvertor;
import cn.featherfly.conversion.basic.ClassConvertor;
import cn.featherfly.conversion.basic.DateArrayConvertor;
import cn.featherfly.conversion.basic.DateConvertor;
import cn.featherfly.conversion.basic.DoubleArrayConvertor;
import cn.featherfly.conversion.basic.DoubleConvertor;
import cn.featherfly.conversion.basic.DoubleWrapperConvertor;
import cn.featherfly.conversion.basic.EnumArrayConvertor;
import cn.featherfly.conversion.basic.EnumConvertor;
import cn.featherfly.conversion.basic.FloatArrayConvertor;
import cn.featherfly.conversion.basic.FloatConvertor;
import cn.featherfly.conversion.basic.FloatWrapperConvertor;
import cn.featherfly.conversion.basic.IntArrayConvertor;
import cn.featherfly.conversion.basic.IntConvertor;
import cn.featherfly.conversion.basic.IntegerConvertor;
import cn.featherfly.conversion.basic.LongArrayConvertor;
import cn.featherfly.conversion.basic.LongConvertor;
import cn.featherfly.conversion.basic.LongWrapperConvertor;
import cn.featherfly.conversion.basic.ShortArrayConvertor;
import cn.featherfly.conversion.basic.ShortConvertor;
import cn.featherfly.conversion.basic.ShortWrapperConvertor;
import cn.featherfly.conversion.basic.StringArrayConvertor;
import cn.featherfly.conversion.basic.StringBufferArrayConvertor;
import cn.featherfly.conversion.basic.StringBufferConvertor;
import cn.featherfly.conversion.basic.StringBuilderArrayConvertor;
import cn.featherfly.conversion.basic.StringBuilderConvertor;
import cn.featherfly.conversion.basic.StringConvertor;
import cn.featherfly.conversion.bp.BigDecimalBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.BigDecimalBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.BigIntegerBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.BigIntegerBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.DateBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.DateBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.DoubleBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.DoubleBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.DoubleWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.FloatBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.FloatBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.FloatWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.IntBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.IntBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.IntegerBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.LongBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.LongBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.LongWrapperBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.ShortBeanPropertyArrayFormatConvertor;
import cn.featherfly.conversion.bp.ShortBeanPropertyFormatConvertor;
import cn.featherfly.conversion.bp.ShortWrapperBeanPropertyFormatConvertor;

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
                    , new EnumConvertor(), new EnumArrayConvertor()
                    , new BigDecimalConvertor(), new BigDecimalArrayConvertor()
                    , new BigIntegerConvertor(), new BigIntegerArrayConvertor()
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
                , new DateBeanPropertyFormatConvertor(), new DateBeanPropertyArrayFormatConvertor()
                , new BigDecimalBeanPropertyFormatConvertor(), new BigDecimalBeanPropertyArrayFormatConvertor()
                , new BigIntegerBeanPropertyFormatConvertor(), new BigIntegerBeanPropertyArrayFormatConvertor()
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
