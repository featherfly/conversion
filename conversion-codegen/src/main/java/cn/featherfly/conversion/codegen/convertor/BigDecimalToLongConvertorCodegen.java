package cn.featherfly.conversion.codegen.convertor;

import java.math.BigDecimal;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type BigDecimal to long convertor codegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigDecimalToLongConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new BigDecimal to long convertor codegen.
     *
     * @param target the target
     */
    public BigDecimalToLongConvertorCodegen(Class<Long> target) {
        this(target, false);
    }

    /**
     * Instantiates a new BigDecimal to long convertor codegen.
     *
     * @param target the target
     * @param inverse the inverse
     */
    public BigDecimalToLongConvertorCodegen(Class<Long> target, boolean inverse) {
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
        return toLong(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toLong(target);
        }
        return toBigDecimal(target);
    }

    private String toBigDecimal(String src) {
        return Str.format("{0}.valueOf({1})", sourceType, src);
    }

    private String toLong(String src) {
        return Str.format("{0}.longValue()", src);
    }
}
