package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Enum to enum convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToStringConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    public EnumToStringConvertorCodegen(String sourceType) {
        super(sourceType, String.class.getName());
    }

    @Override
    public String generateToTarget(String source) {
        return Str.format("{0}.name()", source);
    }

    @Override
    public String generateToSource(String target) {
        return Str.format("{0}.valueOf({1})", sourceType, target);
    }
}
