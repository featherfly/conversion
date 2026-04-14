//package cn.featherfly.conversion.codegen.property;
//
//import cn.featherfly.common.lang.AssertIllegalArgument;
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.common.lang.WordUtils;
//import cn.featherfly.common.lang.string.StringFormatter;
//import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
//
///**
// * The type TypeCastPropertyCodegen.
// *
// * @author zhongj
// */
//public class EnumCastPropertyCodegen implements PropertyConverterCodegen {
//
//    private static final StringFormatter FORMATTER = new StringFormatter('{', '}', true,
//        StringFormatter.NotMatchStrategy.TRIM_PLACEHOLDER);
//
//    private final boolean sourceTypeEnum;
//
//    private final String sourceType;
//
//    private final String targetType;
//
//    public EnumCastPropertyCodegen(String sourceType, String targetType) {
//        this(sourceType, targetType, true);
//    }
//
//    public EnumCastPropertyCodegen(String sourceType, String targetType, boolean sourceTypeEnum) {
//        this.sourceType = sourceType;
//        this.targetType = targetType;
//        this.sourceTypeEnum = sourceTypeEnum;
//    }
//
//    @Override
//    public String sourceType() {
//        return sourceType;
//    }
//
//    @Override
//    public String targetType() {
//        return targetType;
//    }
//
//    public boolean isSourceTypeEnum() {
//        return sourceTypeEnum;
//    }
//
//    @Override
//    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
//        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
//        if (Lang.isEmpty(sourceObjectName)) {
//            return FORMATTER.format("{0}.set{1}({2}get{1}())", isSourceTypeEnum()
//                ? new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName), "(" + sourceType + ") " }
//                : new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName) });
//        } else {
//            return FORMATTER.format("{0}.set{1}({3}{2}.get{1}())", isSourceTypeEnum()
//                ? new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName), sourceObjectName,
//                    "(" + sourceType + ") " }
//                : new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName), sourceObjectName });
//        }
//    }
//
//    @Override
//    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
//        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
//        if (Lang.isEmpty(sourceObjectName)) {
//            return FORMATTER.format("set{0}({2}{1}.get{0}())", isSourceTypeEnum()
//                ? new Object[] { WordUtils.upperCaseFirst(propertyName), targetObjectName }
//                : new Object[] { WordUtils.upperCaseFirst(propertyName), targetObjectName, "(" + targetType + ") " });
//        } else {
//            return FORMATTER.format("{0}.set{1}({3} {2}.get{1}())", isSourceTypeEnum()
//                ? new Object[] { sourceObjectName, WordUtils.upperCaseFirst(propertyName), targetObjectName }
//                : new Object[] { sourceObjectName, WordUtils.upperCaseFirst(propertyName), targetObjectName,
//                    "(" + targetType + ") " });
//        }
//    }
//
//    public static void main(String[] args) {
//        EnumCastPropertyCodegen intToLongCodegen = new EnumCastPropertyCodegen("int", "long");
//        System.out.println(intToLongCodegen.generateFromTarget("id", "user", "userDto"));
//        System.out.println(intToLongCodegen.generateToTarget("id", "user", "userDto"));
//        System.out.println("");
//    }
//}
