
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-21 18:10:21
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Iterables;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.conversion.codegen.ConvertorCodegen;
import cn.featherfly.conversion.codegen.PropertyCodegen;

/**
 * iterable property codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class IterablePropertyCodegen implements PropertyCodegen {

    private final ConvertorCodegen convertorCodegen;

    private final Iterables sourceIterable;
    private final Iterables targetIterable;

    /**
     * Instantiates a new iterable property codegen.
     *
     * @param convertorCodegen the convertor codegen
     * @param iterable the iterable
     */
    public IterablePropertyCodegen(ConvertorCodegen convertorCodegen, Iterables iterable) {
        this(convertorCodegen, iterable, iterable);
    }

    /**
     * Instantiates a new iterable property codegen.
     *
     * @param convertorCodegen the convertor codegen
     * @param sourceIterable the source iterable
     * @param targetIterable the target iterable
     */
    public IterablePropertyCodegen(ConvertorCodegen convertorCodegen, Iterables sourceIterable,
        Iterables targetIterable) {
        this.convertorCodegen = convertorCodegen;
        this.sourceIterable = sourceIterable;
        this.targetIterable = targetIterable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String sourceGetter = null;
        if (Lang.isEmpty(sourceObjectName)) {
            sourceGetter = Str.format("get{0}()", upperCasePropertyName);
        } else {
            sourceGetter = Str.format("{0}.get{1}()", sourceObjectName, upperCasePropertyName);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("if (cn.featherfly.common.lang.Lang.isNotEmpty({sourceGetter})) {\n");
        sb.append("    {targetName}.set{PropertyName}({newIterableObj});\n");
        //        if (targetIterable == Iterables.ARRAY) {
        //            sb.append("    {targetName}.set{PropertyName}({newIterableObj});\n");
        //        } else {
        //            sb.append("    if (cn.featherfly.common.lang.Lang.isNotEmpty({targetName}.get{PropertyName}())) {\n");
        //            sb.append("        {targetName}.get{PropertyName}().clear();\n");
        //            sb.append("    } else {\n");
        //            sb.append("        {targetName}.set{PropertyName}({newIterableObj});\n");
        //            sb.append("    }\n");
        //        }
        if (targetIterable == Iterables.ARRAY) {
            sb.append("    for (int i = 0; i < {sourceGetter}.length; i++) {\n");
            sb.append("        {elementType} {elementName} = {sourceGetter}[i];\n");
            if (ClassUtils.getPrimitiveType(convertorCodegen.sourceType()) == null) {
                sb.append("        if ({elementName} != null) {\n");
                sb.append("            {targetName}.get{PropertyName}[i] = {elementConvertor};\n");
                sb.append("        }\n");
            } else {
                sb.append("        {targetName}.get{PropertyName}[i] = {elementConvertor};\n");
            }
            sb.append("    }\n");
        } else {
            sb.append("    for ({elementType} {elementName} : {sourceGetter}) {\n");
            sb.append("        if ({elementName} != null) {\n");
            sb.append("            {targetName}.get{PropertyName}().add({elementConvertor});\n");
            sb.append("        } else {\n");
            sb.append("            {targetName}.get{PropertyName}().add(null);\n");
            sb.append("        }\n");
            sb.append("    }\n");
        }
        sb.append("}");

        String elementName = propertyName + "Element";
        return Str.format(sb.toString(), new ChainMapImpl<String, Object>()
            .set("PropertyName", upperCasePropertyName) //
            .set("elementName", elementName) //
            .set("sourceGetter", sourceGetter) //
            .set("targetName", targetObjectName) //
            .set("newIterableObj", getNewIterable(targetIterable, convertorCodegen.targetType(), sourceGetter))
            .set("elementType", convertorCodegen.sourceType()) //
            .set("elementConvertor", convertorCodegen.generateToTarget(elementName)) //
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
        String upperCasePropertyName = WordUtils.upperCaseFirst(propertyName);
        String sourceSetter = null;
        if (Lang.isEmpty(sourceObjectName)) {
            sourceSetter = Str.format("set{0}", upperCasePropertyName);
        } else {
            sourceSetter = Str.format("{0}.set{1}", sourceObjectName, upperCasePropertyName);
        }
        String sourceGetter = null;
        String targetGetter = Str.format("{}.get{}()", targetObjectName, upperCasePropertyName);
        if (Lang.isEmpty(sourceObjectName)) {
            sourceGetter = Str.format("get{0}()", upperCasePropertyName);
        } else {
            sourceGetter = Str.format("{0}.get{1}()", sourceObjectName, upperCasePropertyName);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("if (cn.featherfly.common.lang.Lang.isNotEmpty({targetName}.get{PropertyName}())) {\n");
        //        sb.append("    if ({sourceGetter} == null) {\n");
        //        sb.append("        {sourceSetter}({newIterableObj});\n");
        //        sb.append("    } else {\n");
        //        sb.append("        {sourceGetter}.clear();\n");
        //        sb.append("    }\n");
        sb.append("    {sourceSetter}({newIterableObj});\n");
        if (targetIterable == Iterables.ARRAY) {
            sb.append("    for (int i = 0; i < {targetGetter}.length; i++) {\n");
            sb.append("        {elementType} {elementName} = {targetGetter}[i];\n");
            if (ClassUtils.getPrimitiveType(convertorCodegen.sourceType()) == null) {
                sb.append("        if ({elementName} != null) {\n");
                sb.append("            {sourceGetter}[i] = {elementConvertor};\n");
                sb.append("        }\n");
            } else {
                sb.append("        {sourceGetter}[i] = {elementConvertor};\n");
            }
            sb.append("    }\n");
        } else {
            sb.append("    for ({elementType} {elementName} : {targetGetter}) {\n");
            sb.append("        if ({elementName} != null) {\n");
            sb.append("            {sourceGetter}.add({elementConvertor});\n");
            sb.append("        } else {\n");
            sb.append("            {sourceGetter}.add(null);\n");
            sb.append("        }\n");
            sb.append("    }\n");
        }
        sb.append("}");

        String elementName = propertyName + "Element";
        return Str.format(sb.toString(), new ChainMapImpl<String, Object>()
            .set("PropertyName", upperCasePropertyName) //
            .set("elementName", elementName) //
            .set("sourceGetter", sourceGetter) //
            .set("sourceSetter", sourceSetter) //
            .set("targetGetter", targetGetter) //
            .set("targetName", targetObjectName) //
            .set("newIterableObj",
                getNewIterable(sourceIterable, convertorCodegen.sourceType(),
                    targetGetter))
            .set("elementType", convertorCodegen.targetType()) //
            .set("elementConvertor", convertorCodegen.generateToSource(elementName)) //
        );
    }

    private String getNewIterable(Iterables iterable, String elementType, String iterableSource) {
        switch (iterable) {
            case ARRAY:
                return "new " + elementType + "[" + iterableSource + ".length]";
            case COLLECTION:
                // 因为collection的不同实现可能是无序的(例如Set)，所以需要和转换对象使用一样的collection
                return "cn.featherfly.common.lang.CollectionUtils.newCollection(" + iterableSource + ".getClass())";
            case SET:
                // 因为set根据不同实现可能出现不同顺序，所以需要和转换对象使用一样的set
                return "cn.featherfly.common.lang.CollectionUtils.newSet(" + iterableSource + ".getClass())";
            case LIST:
                // 有序，直接使用ArrayList就能保证和转换对象一样的顺序
                return "new java.util.ArrayList<>(" + iterableSource + ".size())";
            case QUEUE:
                // 有序，直接使用ArrayDeque就能保证和转换对象一样的顺序
                return "new java.util.ArrayDeque<>(" + iterableSource + ".size())";
            default:
                throw new IllegalArgumentException("unsupport enum type: " + iterable.name());
        }
    }

}
