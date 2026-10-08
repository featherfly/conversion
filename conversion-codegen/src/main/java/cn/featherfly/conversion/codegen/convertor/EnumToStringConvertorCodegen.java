package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type Enum to enum convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToStringConvertorCodegen extends AbstractSimpleConvertorCodegen {

    /**
     * Instantiates a new enum to string convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToStringConvertorCodegen(String sourceType) {
        super(sourceType, CodegenUtils.getClassName(String.class));
    }

    /**
     * Instantiates a new enum to string convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToStringConvertorCodegen(String sourceType, boolean inverse) {
        super(sourceType, CodegenUtils.getClassName(String.class), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toTarget(String src, ConvertibleProperty property) {
        if (inverse) {
            return toEnum(targetType(), src);
        }
        return toString(src);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String src, ConvertibleProperty property) {
        if (inverse) {
            return toString(src);
        }
        return toEnum(sourceType(), src);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toEnum(String toType, String src) {
        return Str.format("{0}.valueOf({1})", toType, src);
    }

    private String toString(String src) {
        return Str.format("{0}.name()", src);
    }
}
