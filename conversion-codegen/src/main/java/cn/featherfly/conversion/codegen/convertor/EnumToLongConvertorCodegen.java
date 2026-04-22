package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to long convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToLongConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new Enum to long convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToLongConvertorCodegen(String sourceType) {
        super(sourceType, long.class.getName());
    }

    /**
     * Instantiates a new Enum to long convertor codegen.
     *
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public EnumToLongConvertorCodegen(String sourceType, boolean inverse) {
        super(sourceType, long.class.getName(), inverse);
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
        return Str.format("{0}.ordinal()", src);
    }
}
