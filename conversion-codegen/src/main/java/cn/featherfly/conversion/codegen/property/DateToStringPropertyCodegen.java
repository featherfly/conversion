package cn.featherfly.conversion.codegen.property;

import java.util.Date;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToStringConvertorCodegen;

/**
 * The Class DateToStringPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToStringPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param format the format
     */
    public DateToStringPropertyCodegen(String format) {
        this(Date.class.getName(), format);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param format the format
     * @param inverse the inverse
     */
    public DateToStringPropertyCodegen(String format, boolean inverse) {
        this(Date.class, String.class.getName(), inverse);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param format the format
     */
    public <D extends Date> DateToStringPropertyCodegen(Class<D> sourceType, String format) {
        this(CodegenUtils.getClassName(sourceType), format);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param format the format
     * @param inverse the inverse
     */
    public <D extends Date> DateToStringPropertyCodegen(Class<D> sourceType, String format, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), format, inverse);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param sourceType the source type
     * @param format the format
     */
    public DateToStringPropertyCodegen(String sourceType, String format) {
        this(sourceType, format, false);
    }

    /**
     * Instantiates a new date to string property codegen.
     *
     * @param sourceType the source type
     * @param format the format
     * @param inverse the inverse
     */
    public DateToStringPropertyCodegen(String sourceType, String format, boolean inverse) {
        super(sourceType, String.class.getName(), new DateToStringConvertorCodegen(format, inverse));
    }
}
