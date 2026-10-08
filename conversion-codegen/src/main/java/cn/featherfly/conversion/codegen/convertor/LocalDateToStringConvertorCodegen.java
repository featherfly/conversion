package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * LocalDate to String convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalDateToStringConvertorCodegen extends AbstractSimpleConvertorCodegen {

    private final String format;

    /**
     * Instantiates a new local date to string convertor codegen.
     */
    public LocalDateToStringConvertorCodegen() {
        this(null);
    }

    /**
     * Instantiates a new local date to string convertor codegen.
     *
     * @param inverse the inverse
     */
    public LocalDateToStringConvertorCodegen(boolean inverse) {
        this(null, inverse);
    }

    /**
     * Instantiates a new local date to string convertor codegen.
     *
     * @param <D> the generic type
     * @param format the format
     */
    public <D extends Date> LocalDateToStringConvertorCodegen(String format) {
        super(LocalDate.class.getName(), CodegenUtils.getClassName(String.class));
        this.format = format;
    }

    /**
     * Instantiates a new local date to string convertor codegen.
     *
     * @param <D> the generic type
     * @param format the format
     * @param inverse the inverse
     */
    public <D extends Date> LocalDateToStringConvertorCodegen(String format, boolean inverse) {
        super(LocalDate.class.getName(), CodegenUtils.getClassName(String.class), inverse);
        this.format = format;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toTarget(String content, ConvertibleProperty property) {
        if (inverse) {
            return parse(content);
        }
        return format(content);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String content, ConvertibleProperty property) {
        if (inverse) {
            return format(content);
        }
        return parse(content);
    }

    private String format(String src) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.formatDate({0})", src);
        } else {
            return Str.format("cn.featherfly.common.lang.Dates.format({0}, \"{1}\")", src, format);
        }
    }

    private String parse(String src) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.parseLocalDate({0})", src);
        } else {
            return Str.format("java.time.LocalDate.parse({0}, \"{1}\")", src, format);
        }
    }
}
