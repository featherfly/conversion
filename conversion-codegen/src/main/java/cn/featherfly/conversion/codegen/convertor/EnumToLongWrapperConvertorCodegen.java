package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type Enum to long wrapper convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToLongWrapperConvertorCodegen extends AbstractSimpleConvertorCodegen {

    /**
     * Instantiates a new Enum to Long convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToLongWrapperConvertorCodegen(String sourceType) {
        super(sourceType, CodegenUtils.getClassName(Long.class));
    }

    /**
     * Instantiates a new Enum to Long convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToLongWrapperConvertorCodegen(String sourceType, boolean inverse) {
        super(sourceType, CodegenUtils.getClassName(Long.class), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toTarget(String content, ConvertibleProperty property) {
        if (inverse) {
            return toEnum(targetType(), content);
        }
        return toLong(content);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String content, ConvertibleProperty property) {
        if (inverse) {
            return toLong(content);
        }
        return toEnum(sourceType(), content);
    }

    private String toLong(String src) {
        return Str.format("Long.valueOf({0}.ordinal())", src);
    }
}
