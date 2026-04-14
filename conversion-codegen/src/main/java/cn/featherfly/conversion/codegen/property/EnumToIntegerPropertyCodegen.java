package cn.featherfly.conversion.codegen.property;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToIntegerConvertorCodegen;

/**
 * The Class EnumToIntegerPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToIntegerPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new enum to integer property codegen.
     *
     * @param sourceType the source type
     */
    public EnumToIntegerPropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new enum to integer property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToIntegerPropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, int.class.getName(), new EnumToIntegerConvertorCodegen(sourceType), inverse);
    }

    /**
     * Instantiates a new enum to integer property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     */
    public <E extends Enum<?>> EnumToIntegerPropertyCodegen(Class<E> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new enum to integer property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <E extends Enum<?>> EnumToIntegerPropertyCodegen(Class<E> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }
}
