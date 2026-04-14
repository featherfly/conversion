package cn.featherfly.conversion.codegen.convertor;

import java.time.LocalDateTime;
import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Date to LocalDateTime convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLocalDateTimeConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    /**
     * Instantiates a new Date to long convertor codegen.
     */
    public DateToLocalDateTimeConvertorCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param sourceType the source type
     */
    public DateToLocalDateTimeConvertorCodegen(String sourceType) {
        super(sourceType, LocalDateTime.class.getName());
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLocalDateTimeConvertorCodegen(Class<D> sourceType) {
        this(sourceType.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        return Str.format("cn.featherfly.common.lang.Dates.toLocalDateTime({0})", source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        return Str.format("cn.featherfly.common.lang.Dates.toDate({0})", target);
    }
}
