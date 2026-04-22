package cn.featherfly.conversion.codegen.property;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToLocalDateTimeConvertorCodegen;

/**
 * Date to LocalDateTime PropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLocalDateTimePropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new date to local date property codegen.
     */
    public DateToLocalDateTimePropertyCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param <D> the generic type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLocalDateTimePropertyCodegen(boolean inverse) {
        this(Date.class.getName(), inverse);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLocalDateTimePropertyCodegen(Class<D> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLocalDateTimePropertyCodegen(Class<D> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param sourceType the source type
     */
    public DateToLocalDateTimePropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public DateToLocalDateTimePropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, LocalDate.class.getName(), new DateToLocalDateTimeConvertorCodegen(sourceType, inverse));
    }
}
