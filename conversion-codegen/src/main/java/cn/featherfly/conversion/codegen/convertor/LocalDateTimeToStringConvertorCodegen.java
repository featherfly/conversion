package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * LocalDateTime to String convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalDateTimeToStringConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    private final String format;

    /**
     * Instantiates a new local date time to string convertor codegen.
     */
    public LocalDateTimeToStringConvertorCodegen() {
        this(null);
    }

    /**
     * Instantiates a new local date time to string convertor codegen.
     *
     * @param inverse the inverse
     */
    public LocalDateTimeToStringConvertorCodegen(boolean inverse) {
        this(null, inverse);
    }

    /**
     * Instantiates a new local date time to string convertor codegen.
     *
     * @param <D> the generic type
     * @param format the format
     */
    public <D extends Date> LocalDateTimeToStringConvertorCodegen(String format) {
        super(LocalDate.class.getName(), CodegenUtils.getClassName(String.class));
        this.format = format;
    }

    /**
     * Instantiates a new local date time to string convertor codegen.
     *
     * @param <D> the generic type
     * @param format the format
     * @param inverse the inverse
     */
    public <D extends Date> LocalDateTimeToStringConvertorCodegen(String format, boolean inverse) {
        super(LocalDate.class.getName(), CodegenUtils.getClassName(String.class), inverse);
        this.format = format;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (inverse) {
            return parse(source);
        }
        return format(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return format(target);
        }
        return parse(target);
    }

    private String format(String src) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.formatDateTime({0})", src);
        } else {
            return Str.format("cn.featherfly.common.lang.Dates.format({0}, \"{1}\")", src, format);
        }
    }

    private String parse(String src) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.parseLocalDateTime({0})", src);
        } else {
            return Str.format("java.time.LocalDateTime.parse({0}, \"{1}\")", src, format);
        }
    }
}
