package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type Enum to Integer convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToIntegerConvertorCodegen extends AbstractSimpleConvertorCodegen {

    /**
     * Instantiates a new enum to integer convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToIntegerConvertorCodegen(String sourceType) {
        super(sourceType, CodegenUtils.getClassName(Integer.class));
    }

    /**
     * Instantiates a new Enum to integer convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToIntegerConvertorCodegen(String sourceType, boolean inverse) {
        super(sourceType, CodegenUtils.getClassName(Integer.class), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toTarget(String src, ConvertibleProperty property) {
        if (inverse) {
            return toEnum(targetType(), src);
        }
        return toInt(src);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String src, ConvertibleProperty property) {
        if (inverse) {
            return toInt(src);
        }
        return toEnum(sourceType(), src);
    }

    private String toInt(String src) {
        return Str.format("Integer.valueOf({0}.ordinal())", src);
    }
}