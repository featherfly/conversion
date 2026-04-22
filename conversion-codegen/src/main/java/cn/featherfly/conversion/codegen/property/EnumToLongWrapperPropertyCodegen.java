package cn.featherfly.conversion.codegen.property;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToLongWrapperConvertorCodegen;

/**
 * The Class EnumToLongWrapperPropertyCodegen.
 *
 * @author zhongj
 */
public class EnumToLongWrapperPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new enum to long wrapper property codegen.
     *
     * @param sourceType the source type
     */
    public EnumToLongWrapperPropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new enum to long wrapper property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToLongWrapperPropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, int.class.getName(), new EnumToLongWrapperConvertorCodegen(sourceType, inverse));
    }

    /**
     * Instantiates a new enum to long wrapper property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     */
    public <E extends Enum<?>> EnumToLongWrapperPropertyCodegen(Class<E> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new enum to long wrapper property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <E extends Enum<?>> EnumToLongWrapperPropertyCodegen(Class<E> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }
}
