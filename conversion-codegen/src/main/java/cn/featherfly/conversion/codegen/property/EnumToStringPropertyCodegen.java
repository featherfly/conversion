package cn.featherfly.conversion.codegen.property;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToStringConvertorCodegen;

/**
 * The Class EnumToStringPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToStringPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new enum to string property codegen.
     *
     * @param sourceType the source type
     */
    public EnumToStringPropertyCodegen(String sourceType) {
        this(sourceType, false);
    }

    /**
     * Instantiates a new enum to string property codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToStringPropertyCodegen(String sourceType, boolean inverse) {
        super(sourceType, String.class.getName(), new EnumToStringConvertorCodegen(sourceType), inverse);
    }

    /**
     * Instantiates a new enum to string property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     */
    public <E extends Enum<?>> EnumToStringPropertyCodegen(Class<E> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new enum to string property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <E extends Enum<?>> EnumToStringPropertyCodegen(Class<E> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }
}
