package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to int convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToIntConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new Enum to int convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToIntConvertorCodegen(String sourceType) {
        super(sourceType, int.class.getName());
    }

    /**
     * Instantiates a new enum to int convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToIntConvertorCodegen(String sourceType, boolean inverse) {
        super(sourceType, int.class.getName(), inverse);
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
        return Str.format("{0}.ordinal()", src);
    }
}
