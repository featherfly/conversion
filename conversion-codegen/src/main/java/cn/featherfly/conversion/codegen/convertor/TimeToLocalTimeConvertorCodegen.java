package cn.featherfly.conversion.codegen.convertor;

import java.sql.Time;
import java.time.LocalTime;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Date to LocalTime convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class TimeToLocalTimeConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    /**
     * Instantiates a new Date to long convertor codegen.
     */
    public TimeToLocalTimeConvertorCodegen() {
        this(Time.class);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param sourceType the source type
     */
    public TimeToLocalTimeConvertorCodegen(String sourceType) {
        super(sourceType, LocalTime.class.getName());
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Time> TimeToLocalTimeConvertorCodegen(Class<Time> sourceType) {
        this(sourceType.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        return Str.format("{0}.toLocalTime()", source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        return Str.format("java.sql.Time.valueOf({0})", target);
    }
}
