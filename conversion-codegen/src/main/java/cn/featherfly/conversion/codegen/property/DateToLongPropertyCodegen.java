package cn.featherfly.conversion.codegen.property;

import java.util.Date;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToLongConvertorCodegen;

/**
 * The Class DateToLongPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLongPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new date to long property codegen.
     */
    public DateToLongPropertyCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new date to long property codegen.
     *
     * @param <D> the generic type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLongPropertyCodegen(boolean inverse) {
        this(Date.class.getName(), inverse);
    }

    /**
     * Instantiates a new date to long property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLongPropertyCodegen(Class<D> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new date to long property codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLongPropertyCodegen(Class<D> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }

    /**
     * Instantiates a new date to long property codegen.
     *
     * @param sourceType the source type
     */
    public DateToLongPropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new date to long property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public DateToLongPropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, String.class.getName(), new DateToLongConvertorCodegen(sourceType, inverse));
    }
}
