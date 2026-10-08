package cn.featherfly.conversion.codegen.convertor;

import java.math.BigDecimal;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type BigDecimal to long convertor codegen.
 *
 * @author zhongj
 * @since 0.4.0
 */
public class BigDecimalToLongConvertorCodegen extends AbstractSimpleConvertorCodegen {

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
    protected String toTarget(String content, ConvertibleProperty property) {
        if (inverse) {
            return toBigDecimal(content);
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
        return toBigDecimal(content);
    }

    private String toBigDecimal(String src) {
        return Str.format("{0}.valueOf({1})", sourceType, src);
    }

    private String toLong(String src) {
        return Str.format("{0}.longValue()", src);
    }

}
