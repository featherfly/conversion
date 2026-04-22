package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to enum convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToStringConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

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
    public String generateToTarget(String source) {
        if (inverse) {
            return toEnum(sourceType, source);
        }
        return toString(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toString(target);
        }
        return toEnum(sourceType, target);
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
