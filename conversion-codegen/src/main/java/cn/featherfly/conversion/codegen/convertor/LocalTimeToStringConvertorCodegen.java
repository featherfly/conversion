package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * LocalTime to String convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalTimeToStringConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    private final String format;

    /**
     * Instantiates a new local time to string convertor codegen.
     */
    public LocalTimeToStringConvertorCodegen() {
        this(null);
    }

    /**
     * Instantiates a new local time to string convertor codegen.
     *
     * @param inverse the inverse
     */
    public LocalTimeToStringConvertorCodegen(boolean inverse) {
        this(null, inverse);
    }

    /**
     * Instantiates a new local time to string convertor codegen.
     *
     * @param <D> the generic type
     * @param format the format
     */
    public <D extends Date> LocalTimeToStringConvertorCodegen(String format) {
        super(LocalDate.class.getName(), CodegenUtils.getClassName(String.class));
        this.format = format;
    }

    /**
     * Instantiates a new local time to string convertor codegen.
     *
     * @param <D> the generic type
     * @param format the format
     * @param inverse the inverse
     */
    public <D extends Date> LocalTimeToStringConvertorCodegen(String format, boolean inverse) {
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
            return Str.format("cn.featherfly.common.lang.Dates.formatTime({0})", src);
        } else {
            return Str.format("cn.featherfly.common.lang.Dates.format({0}, \"{1}\")", src, format);
        }
    }

    private String parse(String src) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.parseLocalTime({0})", src);
        } else {
            return Str.format("java.time.LocalTime.parse({0}, \"{1}\")", src, format);
        }
    }
}
