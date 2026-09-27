package cn.featherfly.conversion.codegen.property;

import java.math.BigDecimal;

import cn.featherfly.conversion.codegen.convertor.BigDecimalToLongConvertorCodegen;

/**
 * The Class BigDecimalToLongPropertyCodegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigDecimalToLongPropertyCodegen extends ConvertorPropertyCodegen {

    /**
     * Instantiates a new BigDecimal to long property codegen.
     *
     * @param target the target
     */
    public BigDecimalToLongPropertyCodegen(Class<Long> target) {
        this(target, false);
    }

    /**
     * Instantiates a new BigDecimal to long property codegen.
     *
     * @param target the target
     * @param inverse the inverse
     */
    public BigDecimalToLongPropertyCodegen(Class<Long> target, boolean inverse) {
        super(BigDecimal.class.getName(), target.getName(), new BigDecimalToLongConvertorCodegen(target, inverse));
    }
}
