package cn.featherfly.conversion.codegen.property;

import java.time.LocalDateTime;

import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.LocalDateTimeToStringConvertorCodegen;

/**
 * The Class LocalDateTimeToStringPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalDateTimeToStringPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new local date time to string property codegen.
     */
    public LocalDateTimeToStringPropertyCodegen() {
        this(null);
    }

    /**
     * Instantiates a new local date time to string property codegen.
     *
     * @param format the format
     */
    public LocalDateTimeToStringPropertyCodegen(String format) {
        this(format, false);
    }

    /**
     * Instantiates a new local date time to string property codegen.
     *
     * @param inverse the inverse
     */
    public LocalDateTimeToStringPropertyCodegen(boolean inverse) {
        this(null, inverse);
    }

    /**
     * Instantiates a new local date time to string property codegen.
     *
     * @param format the format
     * @param inverse the inverse
     */
    public LocalDateTimeToStringPropertyCodegen(String format, boolean inverse) {
        super(LocalDateTime.class.getName(), String.class.getName(), new LocalDateTimeToStringConvertorCodegen(format),
            inverse);
    }

}
