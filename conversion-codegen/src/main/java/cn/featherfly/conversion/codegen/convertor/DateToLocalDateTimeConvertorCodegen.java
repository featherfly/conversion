package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDateTime;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Date to LocalDateTime convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLocalDateTimeConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new Date to long convertor codegen.
     */
    public DateToLocalDateTimeConvertorCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param inverse the inverse
     */
    public DateToLocalDateTimeConvertorCodegen(boolean inverse) {
        this(Date.class, inverse);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param sourceType the source type
     */
    public DateToLocalDateTimeConvertorCodegen(String sourceType) {
        super(CodegenUtils.getClassName(sourceType), LocalDateTime.class.getName());
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public DateToLocalDateTimeConvertorCodegen(String sourceType, boolean inverse) {
        super(CodegenUtils.getClassName(sourceType), LocalDateTime.class.getName(), inverse);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLocalDateTimeConvertorCodegen(Class<D> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLocalDateTimeConvertorCodegen(Class<D> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (inverse) {
            return toDate(source);
        }
        return toLocalDateTime(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toLocalDateTime(target);
        }
        return toDate(target);
    }

    private String toDate(String src) {
        return Str.format("cn.featherfly.common.lang.Dates.toDate({0})", src);
    }

    private String toLocalDateTime(String src) {
        return Str.format("cn.featherfly.common.lang.Dates.toLocalDateTime({0})", src);
    }
}
