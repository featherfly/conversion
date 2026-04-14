package cn.featherfly.conversion.codegen.property;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToLongConvertorCodegen;

/**
 * The Class EnumToLongPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToLongPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param sourceType the source type
     */
    public EnumToLongPropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToLongPropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, int.class.getName(), new EnumToLongConvertorCodegen(sourceType), inverse);
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     */
    public <E extends Enum<?>> EnumToLongPropertyCodegen(Class<E> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <E extends Enum<?>> EnumToLongPropertyCodegen(Class<E> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }
}
