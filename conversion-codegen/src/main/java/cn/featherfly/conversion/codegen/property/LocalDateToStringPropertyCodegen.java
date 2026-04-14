package cn.featherfly.conversion.codegen.property;

import java.time.LocalDate;

import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.LocalDateToStringConvertorCodegen;

/**
 * The Class LocalDateToStringPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class LocalDateToStringPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new date to string property codegen.
     */
    public LocalDateToStringPropertyCodegen() {
        this(null, false);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param format the format
     */
    public LocalDateToStringPropertyCodegen(String format) {
        this(format, false);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param inverse the inverse
     */
    public LocalDateToStringPropertyCodegen(boolean inverse) {
        this(null, inverse);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param format the format
     * @param inverse the inverse
     */
    public LocalDateToStringPropertyCodegen(String format, boolean inverse) {
        super(LocalDate.class.getName(), String.class.getName(), new LocalDateToStringConvertorCodegen(format),
            inverse);
    }
}
