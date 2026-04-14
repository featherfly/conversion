package cn.featherfly.conversion.codegen.property;

import java.time.LocalDate;
import java.util.Date;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToLocalDateConvertorCodegen;

/**
 * Date to LocalDate PropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLocalDatePropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new date to local date property codegen.
     */
    public DateToLocalDatePropertyCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param <D> the generic type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLocalDatePropertyCodegen(boolean inverse) {
        this(Date.class.getName(), inverse);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLocalDatePropertyCodegen(Class<D> sourceType) {
        this(CodegenUtils.getClassName(sourceType), false);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLocalDatePropertyCodegen(Class<D> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param sourceType the source type
     */
    public DateToLocalDatePropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new date to local date property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public DateToLocalDatePropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, LocalDate.class.getName(), new DateToLocalDateConvertorCodegen(sourceType), inverse);
    }
}
