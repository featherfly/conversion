package cn.featherfly.conversion.codegen.property;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;

/**
 * The Class ConvertorPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class ConvertorPropertyCodegen extends AbstractConvertible implements PropertyConverterCodegen {

    private final ConvertorCodegen convertorCodegen;

    /**
     * Instantiates a new convertor property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param convertorCodegen the convertor codegen
     */
    public ConvertorPropertyCodegen(String sourceType, String targetType, ConvertorCodegen convertorCodegen) {
        super(sourceType, targetType);
        this.convertorCodegen = convertorCodegen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        assertTargetObjectName(targetObjectName);
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String targetAccess = Str.format("{0}.get{1}", targetObjectName, upperCasePropertyName);
        if (Lang.isEmpty(sourceObjectName)) {
            String sourceAccess = Str.format("get{0}()", upperCasePropertyName);
            return Str.format("{ifNotNull}{targetObjectName}.set{propertyName}({convertor});",
                new ChainMapImpl<String, Object>().set("targetObjectName", targetObjectName)
                    .set("propertyName", upperCasePropertyName)
                    .set("ifNotNull", Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0})) ", sourceAccess))
                    .set("convertor", convertorCodegen.generateToTarget(sourceAccess, targetAccess)));

        } else {
            String sourceAccess = Str.format("{0}.get{1}()", sourceObjectName, upperCasePropertyName);
            return Str.format("{ifNotNull}{targetObjectName}.set{propertyName}({convertor});",
                new ChainMapImpl<String, Object>().set("targetObjectName", targetObjectName)
                    .set("propertyName", upperCasePropertyName)
                    .set("ifNotNull", Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0})) ", sourceAccess))
                    .set("convertor", convertorCodegen.generateToTarget(
                        Str.format("{0}.get{1}()", sourceObjectName, upperCasePropertyName), targetAccess)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        assertTargetObjectName(targetObjectName);
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String ifNotNull = Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0}.get{1}())) ", targetObjectName,
            upperCasePropertyName);
        String targetAccess = Str.format("{0}.get{1}()", targetObjectName, upperCasePropertyName);
        if (Lang.isEmpty(sourceObjectName)) {
            String sourceAccess = Str.format("get{0}", upperCasePropertyName);
            return Str.format("{ifNotNull}set{propertyName}({convertor});",
                new ChainMapImpl<String, Object>().set("targetObjectName", targetObjectName)
                    .set("propertyName", upperCasePropertyName) //
                    .set("ifNotNull", ifNotNull) //
                    .set("convertor", convertorCodegen.generateToSource(targetAccess, sourceAccess)));
        } else {
            String sourceAccess = Str.format("{0}.get{1}", sourceObjectName, upperCasePropertyName);
            return Str.format("{ifNotNull}{sourceObjectName}.set{propertyName}({convertor});",
                new ChainMapImpl<String, Object>().set("sourceObjectName", sourceObjectName)
                    .set("propertyName", upperCasePropertyName)  //
                    .set("ifNotNull", ifNotNull) //
                    .set("convertor", convertorCodegen.generateToSource(targetAccess, sourceAccess)));
        }
    }

    private void assertTargetObjectName(String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
    }
}
