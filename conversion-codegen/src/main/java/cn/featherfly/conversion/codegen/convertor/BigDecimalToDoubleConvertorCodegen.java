package cn.featherfly.conversion.codegen.convertor;

import java.math.BigDecimal;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type BigDecimal to double convertor codegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigDecimalToDoubleConvertorCodegen extends AbstractSimpleConvertorCodegen {

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
    protected String toTarget(String content, ConvertibleProperty property) {
        if (inverse) {
            return toBigDecimal(content);
        }
        return toDouble(content);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String content, ConvertibleProperty property) {
        if (inverse) {
            return toDouble(content);
        }
        return toBigDecimal(content);
    }

    private String toBigDecimal(String src) {
        return Str.format("{0}.valueOf({1})", sourceType, src);
    }

    private String toDouble(String src) {
        return Str.format("{0}.doubleValue()", src);
    }
}
