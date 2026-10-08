package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type Enum to int convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToIntConvertorCodegen extends AbstractSimpleConvertorCodegen {

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
        return Str.format("{0}.ordinal()", src);
    }

}
