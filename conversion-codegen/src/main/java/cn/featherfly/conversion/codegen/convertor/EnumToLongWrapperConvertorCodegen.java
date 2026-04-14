package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to long wrapper convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToLongWrapperConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    /**
     * Instantiates a new Enum to Long convertor codegen.
     *
     * @param sourceType the source type
     */
    public EnumToLongWrapperConvertorCodegen(String sourceType) {
        super(sourceType, Long.class.getName());
    }

    @Override
    public String generateToTarget(String source) {
        return Str.format("Long.valueOf({0}.ordinal())", source);
    }

    @Override
    public String generateToSource(String target) {
        return Str.format("cn.featherfly.common.lang.Lang.toEnum({0}.class, {1})", sourceType, target);
    }
}
