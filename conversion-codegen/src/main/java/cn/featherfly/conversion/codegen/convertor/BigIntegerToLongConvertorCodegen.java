package cn.featherfly.conversion.codegen.convertor;

import java.math.BigInteger;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type BigInteger to long convertor codegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigIntegerToLongConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new BigInteger to long convertor codegen.
     *
     * @param target the target
     */
    public BigIntegerToLongConvertorCodegen(Class<Long> target) {
        this(target, false);
    }

    /**
     * Instantiates a new BigInteger to long convertor codegen.
     *
     * @param target the target
     * @param inverse the inverse
     */
    public BigIntegerToLongConvertorCodegen(Class<Long> target, boolean inverse) {
        super(BigInteger.class.getName(), target.getName(), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source, String target) {
        if (inverse) {
            return toBigInteger(source);
        }
        return toLong(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target, String source) {
        if (inverse) {
            return toLong(target);
        }
        return toBigInteger(target);
    }

    private String toBigInteger(String src) {
        return Str.format("{0}.valueOf({1})", sourceType, src);
    }

    private String toLong(String src) {
        return Str.format("{0}.longValue()", src);
    }
}
