package cn.featherfly.conversion.codegen.property;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.conversion.codegen.PropertyCodegen;

/**
 * boolean &lt;&gt; Boolean direct assign property codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class BooleanDirectAssignPropertyCodegen implements PropertyCodegen {

    private Class<Boolean> source;

    private Class<Boolean> target;

    public BooleanDirectAssignPropertyCodegen(Class<Boolean> source, Class<Boolean> target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String getter = target == Boolean.class ? "get" + upperCasePropertyName : "is" + upperCasePropertyName;
        String ifNotNull = Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0}.{1}())) ", targetObjectName,
            getter);
        if (Lang.isEmpty(sourceObjectName)) {
            return Str.format("{0}set{1}({2}.{3}());",
                ifNotNull,
                upperCasePropertyName, targetObjectName, getter);
        } else {
            return Str.format("{0}{1}.set{2}({3}.{4}());",
                ifNotNull,
                sourceObjectName,
                upperCasePropertyName, targetObjectName, getter);
        }
    }

    @Override
    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String getter = source == Boolean.class ? "get" + upperCasePropertyName : "is" + upperCasePropertyName;
        String ifNull = Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({1}())) ",
            sourceObjectName, getter);
        if (Lang.isEmpty(sourceObjectName)) {
            return Str.format("{0}{1}.set{2}({3}());", ifNull, targetObjectName, upperCasePropertyName, getter);
        } else {
            return Str.format("{0}{1}.set{2}({3}.{4}());", ifNull, targetObjectName, upperCasePropertyName,
                sourceObjectName, getter);
        }
    }
}
