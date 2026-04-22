package cn.featherfly.conversion.codegen.property;

import java.sql.Time;
import java.time.LocalDate;

import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.TimeToLocalTimeConvertorCodegen;

/**
 * Time to LocalTime PropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class TimeToLocalTimePropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new time to local time property codegen.
     */
    public TimeToLocalTimePropertyCodegen() {
        this(Time.class);
    }

    /**
     * Instantiates a new time to local time property codegen.
     *
     * @param <D> the generic type
     * @param inverse the inverse
     */
    public <D extends Time> TimeToLocalTimePropertyCodegen(boolean inverse) {
        this(Time.class.getName(), inverse);
    }

    /**
     * Instantiates a new time to local time property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Time> TimeToLocalTimePropertyCodegen(Class<D> sourceType) {
        this(sourceType.getName(), false);
    }

    /**
     * Instantiates a new time to local time property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Time> TimeToLocalTimePropertyCodegen(Class<D> sourceType, boolean inverse) {
        this(sourceType.getName(), inverse);
    }

    /**
     * Instantiates a new time to local time property codegen.
     *
     * @param sourceType the source type
     */
    public TimeToLocalTimePropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new time to local time property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public TimeToLocalTimePropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, LocalDate.class.getName(), new TimeToLocalTimeConvertorCodegen(sourceType, inverse));
    }
}
