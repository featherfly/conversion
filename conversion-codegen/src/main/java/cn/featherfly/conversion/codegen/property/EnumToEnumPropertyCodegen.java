package cn.featherfly.conversion.codegen.property;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;

/**
 * The Class EnumToEnumPropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class EnumToEnumPropertyCodegen implements PropertyConverterCodegen {

    private final String sourceType;

    private final String targetType;

    /**
     * Instantiates a new enum to enum property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public EnumToEnumPropertyCodegen(String sourceType, String targetType) {
        this.sourceType = sourceType;
        this.targetType = targetType;
    }

    /**
     * Instantiates a new enum to enum property codegen.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param sourceType the source type
     * @param targetType the target type
     */
    public <E1 extends Enum<?>, E2 extends Enum<?>> EnumToEnumPropertyCodegen(Class<E1> sourceType,
        Class<E2> targetType) {
        this(CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String sourceType() {
        return sourceType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String targetType() {
        return targetType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        if (Lang.isEmpty(sourceObjectName)) {
            return Str.format(
                "{ifNotNull}{targetObjectName}.set{propertyName}(cn.featherfly.common.lang.Lang.toEnum({targetType}.class, get{propertyName}()));",
                new ChainMapImpl<String, Object>().set("targetObjectName", targetObjectName)
                    .set("propertyName", upperCasePropertyName)
                    .set("ifNotNull",
                        Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty(get{1}())) ", sourceObjectName,
                            upperCasePropertyName))
                    .set("targetType", targetType));
        } else {
            return Str.format(
                "{ifNotNull}{targetObjectName}.set{propertyName}(cn.featherfly.common.lang.Lang.toEnum({targetType}.class, {sourceObjectName}.get{propertyName}()));",
                new ChainMapImpl<String, Object>().set("targetObjectName", targetObjectName)
                    .set("propertyName", upperCasePropertyName)
                    .set("ifNotNull",
                        Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0}.get{1}())) ", sourceObjectName,
                            upperCasePropertyName))
                    .set("targetType", targetType)
                    .set("sourceObjectName", sourceObjectName));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String ifNotNull = Str.format("if (cn.featherfly.common.lang.Lang.isNotEmpty({0}.get{1}())) ", targetObjectName,
            upperCasePropertyName);
        if (Lang.isEmpty(sourceObjectName)) {
            return Str.format(
                "{ifNotNull}set{propertyName}(cn.featherfly.common.lang.Lang.toEnum({sourceType}.class, {targetObjectName}.get{propertyName}()));",
                new ChainMapImpl<String, Object>().set("targetObjectName", targetObjectName)
                    .set("propertyName", upperCasePropertyName)
                    .set("ifNotNull", ifNotNull)
                    .set("sourceType", sourceType));
        } else {
            return Str.format(
                "{ifNotNull}{sourceObjectName}.set{propertyName}(cn.featherfly.common.lang.Lang.toEnum({sourceType}.class, {targetObjectName}.get{propertyName}()));",
                new ChainMapImpl<String, Object>().set("targetObjectName", targetObjectName)
                    .set("propertyName", upperCasePropertyName)
                    .set("ifNotNull", ifNotNull)
                    .set("sourceType", sourceType)
                    .set("sourceObjectName", sourceObjectName));
        }
    }
}
