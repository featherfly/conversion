package cn.featherfly.conversion.codegen.property;

import java.math.BigDecimal;

import cn.featherfly.conversion.codegen.convertor.BigDecimalToDoubleConvertorCodegen;

/**
 * The Class BigDecimalToDoublePropertyCodegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigDecimalToDoublePropertyCodegen extends ConvertorPropertyCodegen {

    /**
     * Instantiates a new BigDecimal to double property codegen.
     *
     * @param target the target
     */
    public BigDecimalToDoublePropertyCodegen(Class<Double> target) {
        this(target, false);
    }

    /**
     * Instantiates a new BigDecimal to double property codegen.
     *
     * @param target the target
     * @param inverse the inverse
     */
    public BigDecimalToDoublePropertyCodegen(Class<Double> target, boolean inverse) {
        super(BigDecimal.class.getName(), target.getName(), new BigDecimalToDoubleConvertorCodegen(target, inverse));
    }
}
