package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * enum to enum convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToEnumConvertorCodegen extends AbstractSimpleConvertorCodegen {

    /**
     * Instantiates a new enum to enum property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public EnumToEnumConvertorCodegen(String sourceType, String targetType) {
        super(sourceType, targetType);
    }

    /**
     * Instantiates a new enum to enum property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param inverse the inverse
     */
    public EnumToEnumConvertorCodegen(String sourceType, String targetType, boolean inverse) {
        super(sourceType, targetType, inverse);
    }

    /**
     * Instantiates a new enum to enum property codegen.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param sourceType the source type
     * @param targetType the target type
     */
    public <E1 extends Enum<?>, E2 extends Enum<?>> EnumToEnumConvertorCodegen(Class<E1> sourceType,
        Class<E2> targetType) {
        this(CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toTarget(String src, ConvertibleProperty property) {
        return toEnum(targetType(), src);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String src, ConvertibleProperty property) {
        return toEnum(sourceType(), src);
    }
}
