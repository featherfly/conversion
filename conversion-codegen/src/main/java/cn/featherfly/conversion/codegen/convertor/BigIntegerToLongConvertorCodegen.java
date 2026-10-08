package cn.featherfly.conversion.codegen.convertor;

import java.math.BigInteger;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type BigInteger to long convertor codegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigIntegerToLongConvertorCodegen extends AbstractSimpleConvertorCodegen {

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
    protected String toTarget(String content, ConvertibleProperty property) {
        if (inverse) {
            return toBigInteger(content);
        }
        return toLong(content);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String content, ConvertibleProperty property) {
        if (inverse) {
            return toLong(content);
        }
        return toBigInteger(content);
    }

    private String toBigInteger(String src) {
        return Str.format("{0}.valueOf({1})", sourceType, src);
    }

    private String toLong(String src) {
        return Str.format("{0}.longValue()", src);
    }
}
