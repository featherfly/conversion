package cn.featherfly.conversion.codegen.convertor;

import java.sql.Time;
import java.time.LocalTime;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Time to LocalTime convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class TimeToLocalTimeConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new time to local time convertor codegen.
     */
    public TimeToLocalTimeConvertorCodegen() {
        this(Time.class);
    }

    /**
     * Instantiates a new time to local time convertor codegen.
     *
     * @param inverse the inverse
     */
    public TimeToLocalTimeConvertorCodegen(boolean inverse) {
        this(Time.class, inverse);
    }

    /**
     * Instantiates a new time to local time convertor codegen.
     *
     * @param sourceType the source type
     */
    public TimeToLocalTimeConvertorCodegen(String sourceType) {
        super(sourceType, LocalTime.class.getName());
    }

    /**
     * Instantiates a new time to local time convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public TimeToLocalTimeConvertorCodegen(String sourceType, boolean inverse) {
        super(sourceType, LocalTime.class.getName(), inverse);
    }

    /**
     * Instantiates a new time to local time convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Time> TimeToLocalTimeConvertorCodegen(Class<Time> sourceType) {
        this(sourceType.getName());
    }

    /**
     * Instantiates a new time to local time convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Time> TimeToLocalTimeConvertorCodegen(Class<Time> sourceType, boolean inverse) {
        this(sourceType.getName(), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (inverse) {
            return toTime(source);
        }
        return toLocalTime(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toLocalTime(target);
        }
        return toTime(target);
    }

    private String toTime(String src) {
        return Str.format("java.sql.Time.valueOf({0})", src);
    }

    private String toLocalTime(String src) {
        return Str.format("{0}.toLocalTime()", src);
    }
}
