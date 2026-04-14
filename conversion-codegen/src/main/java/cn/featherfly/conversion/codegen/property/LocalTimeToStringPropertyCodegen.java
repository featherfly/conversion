package cn.featherfly.conversion.codegen.property;

import java.time.LocalTime;

import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.LocalTimeToStringConvertorCodegen;

/**
 * The Class LocalTimeToStringPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalTimeToStringPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new local time to string property codegen.
     */
    public LocalTimeToStringPropertyCodegen() {
        this(null, false);
    }

    /**
     * Instantiates a new local time to string property codegen.
     *
     * @param format the format
     */
    public LocalTimeToStringPropertyCodegen(String format) {
        this(format, false);
    }

    /**
     * Instantiates a new local time to string property codegen.
     *
     * @param inverse the inverse
     */
    public LocalTimeToStringPropertyCodegen(boolean inverse) {
        this(null, inverse);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param format the format
     * @param inverse the inverse
     */
    public LocalTimeToStringPropertyCodegen(String format, boolean inverse) {
        super(LocalTime.class.getName(), String.class.getName(), new LocalTimeToStringConvertorCodegen(format),
            inverse);
    }
}
