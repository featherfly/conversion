package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type Date to LocalDate convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLocalDateConvertorCodegen extends AbstractSimpleConvertorCodegen {

    /**
     * Instantiates a new Date to long convertor codegen.
     */
    public DateToLocalDateConvertorCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param inverse the inverse
     */
    public DateToLocalDateConvertorCodegen(boolean inverse) {
        this(Date.class, inverse);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param sourceType the source type
     */
    public DateToLocalDateConvertorCodegen(String sourceType) {
        super(CodegenUtils.getClassName(sourceType), LocalDate.class.getName());
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public DateToLocalDateConvertorCodegen(String sourceType, boolean inverse) {
        super(CodegenUtils.getClassName(sourceType), LocalDate.class.getName(), inverse);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLocalDateConvertorCodegen(Class<D> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLocalDateConvertorCodegen(Class<D> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toTarget(String content, ConvertibleProperty property) {
        if (inverse) {
            return toDate(content);
        }
        return toLocalDate(content);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String content, ConvertibleProperty property) {
        if (inverse) {
            return toLocalDate(content);
        }
        return toDate(content);
    }

    private String toDate(String src) {
        return Str.format("cn.featherfly.common.lang.Dates.toDate({0})", src);
    }

    private String toLocalDate(String src) {
        return Str.format("cn.featherfly.common.lang.Dates.toLocalDate({0})", src);
    }
}
