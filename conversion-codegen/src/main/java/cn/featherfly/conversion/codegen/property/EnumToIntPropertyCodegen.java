package cn.featherfly.conversion.codegen.property;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToIntConvertorCodegen;

/**
 * The Class EnumToIntPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToIntPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new enum to int property codegen.
     *
     * @param sourceType the source type
     */
    public EnumToIntPropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new enum to int property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToIntPropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, int.class.getName(), new EnumToIntConvertorCodegen(sourceType, inverse));
    }

    /**
     * Instantiates a new enum to int property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     */
    public <E extends Enum<?>> EnumToIntPropertyCodegen(Class<E> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new enum to int property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <E extends Enum<?>> EnumToIntPropertyCodegen(Class<E> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }
}
