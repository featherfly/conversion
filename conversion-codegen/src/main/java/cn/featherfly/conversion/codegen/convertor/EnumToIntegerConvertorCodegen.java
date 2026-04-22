package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to Integer convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToIntegerConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

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
    public String generateToTarget(String source) {
        if (inverse) {
            return toEnum(sourceType, source);
        }
        return toInt(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toInt(target);
        }
        return toEnum(sourceType, target);
    }

    private String toInt(String src) {
        return Str.format("Integer.valueOf({0}.ordinal())", src);
    }
}