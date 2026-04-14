package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to long convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToLongConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    /**
     * Instantiates a new Enum to long convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToLongConvertorCodegen(String sourceType) {
        super(sourceType, long.class.getName());
    }

    @Override
    public String generateToTarget(String source) {
        return Str.format("{0}.ordinal()", source);
    }

    @Override
    public String generateToSource(String target) {
        return Str.format("cn.featherfly.common.lang.Lang.toEnum({0}.class, {1})", sourceType, target);
    }
}
