package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The Class LocalTimeToStringConvertorCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalTimeToStringConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

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
     * @param <D> the generic type
     * @param format the format
     */
    public <D extends Date> LocalTimeToStringConvertorCodegen(String format) {
        super(LocalDate.class.getName(), long.class.getName());
        this.format = format;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (format == null) {
            return Str.format("cn.featherfly.common.lang.Dates.formatTime({0})", source);
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
            return Str.format("cn.featherfly.common.lang.Dates.parseLocalTime({0})", target);
        } else {
            return Str.format("java.time.LocalTime.parse({0}, \"{1}\")", target, format);
        }
    }
}
