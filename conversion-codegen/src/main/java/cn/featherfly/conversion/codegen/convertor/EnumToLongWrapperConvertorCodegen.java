package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to long wrapper convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToLongWrapperConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

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
    public String generateToTarget(String source) {
        if (inverse) {
            return toEnum(sourceType, source);
        }
        return toLong(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toLong(target);
        }
        return toEnum(sourceType, target);
    }

    private String toLong(String src) {
        return Str.format("Long.valueOf({0}.ordinal())", src);
    }
}
