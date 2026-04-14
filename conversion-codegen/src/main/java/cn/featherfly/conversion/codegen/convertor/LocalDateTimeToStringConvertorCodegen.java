package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The Class LocalDateTimeToStringConvertorCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalDateTimeToStringConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

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
     * @param <D> the generic type
     * @param format the format
     */
    public <D extends Date> LocalDateTimeToStringConvertorCodegen(String format) {
        super(LocalDate.class.getName(), long.class.getName());
        this.format = format;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.formatDateTime({0})", source);
        } else {
            return Str.format("cn.featherfly.common.lang.Dates.format({0}, \"{1}\")", source, format);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.parseLocalDateTime({0})", target);
        } else {
            return Str.format("java.time.LocalDateTime.parse({0}, \"{1}\")", target, format);
        }
    }
}
