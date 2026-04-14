package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to int convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToIntConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    /**
     * Instantiates a new Enum to int convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToIntConvertorCodegen(String sourceType) {
        super(sourceType, int.class.getName());
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
