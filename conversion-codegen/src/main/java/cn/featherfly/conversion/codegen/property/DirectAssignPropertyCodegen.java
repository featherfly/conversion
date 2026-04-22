package cn.featherfly.conversion.codegen.property;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.conversion.codegen.PropertyCodegen;

/**
 * direct assign property codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DirectAssignPropertyCodegen implements PropertyCodegen {

    @Override
    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String ifNotNull = Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0}.get{1}())) ", targetObjectName,
            upperCasePropertyName);
        if (Lang.isEmpty(sourceObjectName)) {
            return Str.format("{0}set{1}({2}.get{1}());",
                ifNotNull,
                upperCasePropertyName, targetObjectName);
        } else {
            return Str.format("{0}{1}.set{2}({3}.get{2}());",
                ifNotNull,
                sourceObjectName,
                upperCasePropertyName, targetObjectName);
        }
    }

    @Override
    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        if (Lang.isEmpty(sourceObjectName)) {
            return Str.format("{0}{1}.set{2}(get{2}());",
                Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty(get{1}())) ", sourceObjectName,
                    upperCasePropertyName),
                targetObjectName,
                upperCasePropertyName);
        } else {
            return Str.format("{0}{1}.set{2}({3}.get{2}());",
                Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0}.get{1}())) ", sourceObjectName,
                    upperCasePropertyName),
                targetObjectName,
                upperCasePropertyName, sourceObjectName);
        }
    }
}
