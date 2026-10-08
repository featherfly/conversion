package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type Enum to long convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToLongConvertorCodegen extends AbstractSimpleConvertorCodegen {

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
        return Str.format("{0}.ordinal()", src);
    }
}
