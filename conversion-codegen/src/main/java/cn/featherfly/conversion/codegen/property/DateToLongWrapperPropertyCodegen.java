package cn.featherfly.conversion.codegen.property;

import java.util.Date;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToLongWrapperConvertorCodegen;

/**
 * The Class DateToLongWrapperPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLongWrapperPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new date to long wrapper property codegen.
     */
    public DateToLongWrapperPropertyCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new date to long wrapper property codegen.
     *
     * @param <D> the generic type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLongWrapperPropertyCodegen(boolean inverse) {
        this(Date.class.getName(), inverse);
    }

    /**
     * Instantiates a new date to long wrapper property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLongWrapperPropertyCodegen(Class<D> sourceType) {
        this(CodegenUtils.getClassName(sourceType), false);
    }

    /**
     * Instantiates a new date to long wrapper property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLongWrapperPropertyCodegen(Class<D> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }

    /**
     * Instantiates a new date to long wrapper property codegen.
     *
     * @param sourceType the source type
     */
    public DateToLongWrapperPropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new date to long wrapper property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public DateToLongWrapperPropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, String.class.getName(), new DateToLongWrapperConvertorCodegen(sourceType), inverse);
    }
}
