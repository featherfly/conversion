package cn.featherfly.conversion.codegen.property;

import java.math.BigInteger;

import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.BigIntegerToLongConvertorCodegen;

/**
 * The Class BigIntegerToLongPropertyCodegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigIntegerToLongPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new BigInteger to long property codegen.
     *
     * @param target the target
     */
    public BigIntegerToLongPropertyCodegen(Class<Long> target) {
        this(target, false);
    }

    /**
     * Instantiates a new BigInteger to long property codegen.
     *
     * @param target the target
     * @param inverse the inverse
     */
    public BigIntegerToLongPropertyCodegen(Class<Long> target, boolean inverse) {
        super(BigInteger.class.getName(), target.getName(), new BigIntegerToLongConvertorCodegen(target, inverse));
    }
}
