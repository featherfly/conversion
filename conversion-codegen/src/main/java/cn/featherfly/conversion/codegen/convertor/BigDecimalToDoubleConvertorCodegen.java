package cn.featherfly.conversion.codegen.convertor;

import java.math.BigDecimal;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type BigDecimal to double convertor codegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigDecimalToDoubleConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new BigDecimal to double convertor codegen.
     *
     * @param target the target
     */
    public BigDecimalToDoubleConvertorCodegen(Class<Double> target) {
        this(target, false);
    }

    /**
     * Instantiates a new BigDecimal to double convertor codegen.
     *
     * @param target the target
     * @param inverse the inverse
     */
    public BigDecimalToDoubleConvertorCodegen(Class<Double> target, boolean inverse) {
        super(BigDecimal.class.getName(), target.getName(), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (inverse) {
            return toBigDecimal(source);
        }
        return toDouble(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toDouble(target);
        }
        return toBigDecimal(target);
    }

    private String toBigDecimal(String src) {
        return Str.format("{0}.valueOf({1})", sourceType, src);
    }

    private String toDouble(String src) {
        return Str.format("{0}.doubleValue()", src);
    }
}
