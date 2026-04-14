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
// * @since 0.1.0
// */
//public class TypeCastPropertyCodegen implements PropertyConverterCodegen {
//
//    private static final StringFormatter FORMATTER = new StringFormatter('{', '}', true,
//        StringFormatter.NotMatchStrategy.TRIM_PLACEHOLDER);
//
//    private final boolean sourceCastToTarget;
//
//    private final String sourceType;
//
//    private final String targetType;
//
//    /**
//     * Instantiates a new type cast property codegen.
//     *
//     * @param sourceType the source type
//     * @param targetType the target type
//     */
//    public TypeCastPropertyCodegen(String sourceType, String targetType) {
//        this(sourceType, targetType, true);
//    }
//
//    /**
//     * Instantiates a new type cast property codegen.
//     *
//     * @param sourceType the source type
//     * @param targetType the target type
//     * @param sourceCastToTarget the source cast to target
//     */
//    public TypeCastPropertyCodegen(String sourceType, String targetType, boolean sourceCastToTarget) {
//        this.sourceType = sourceType;
//        this.targetType = targetType;
//        this.sourceCastToTarget = sourceCastToTarget;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String sourceType() {
//        return sourceType;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String targetType() {
//        return targetType;
//    }
//
//    /**
//     * Checks if is source cast to target.
//     *
//     * @return true, if is source cast to target
//     */
//    public boolean isSourceCastToTarget() {
//        return sourceCastToTarget;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
//        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
//        if (Lang.isEmpty(sourceObjectName)) {
//            return FORMATTER.format("{0}.set{1}({2}get{1}())", isSourceCastToTarget()
//                ? new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName), "(" + sourceType + ") " }
//                : new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName) });
//        } else {
//            return FORMATTER.format("{0}.set{1}({3}{2}.get{1}())", isSourceCastToTarget()
//                ? new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName), sourceObjectName,
//                    "(" + sourceType + ") " }
//                : new Object[] { targetObjectName, WordUtils.upperCaseFirst(propertyName), sourceObjectName });
//        }
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
//        AssertIllegalArgument.isNotEmpty(targetObjectName, "targetObjectName");
//        if (Lang.isEmpty(sourceObjectName)) {
//            return FORMATTER.format("set{0}({2}{1}.get{0}())", isSourceCastToTarget()
//                ? new Object[] { WordUtils.upperCaseFirst(propertyName), targetObjectName }
//                : new Object[] { WordUtils.upperCaseFirst(propertyName), targetObjectName, "(" + targetType + ") " });
//        } else {
//            return FORMATTER.format("{0}.set{1}({3} {2}.get{1}())", isSourceCastToTarget()
//                ? new Object[] { sourceObjectName, WordUtils.upperCaseFirst(propertyName), targetObjectName }
//                : new Object[] { sourceObjectName, WordUtils.upperCaseFirst(propertyName), targetObjectName,
//                    "(" + targetType + ") " });
//        }
//    }
//
//    /**
//     * The main method.
//     *
//     * @param args the arguments
//     */
//    public static void main(String[] args) {
//        TypeCastPropertyCodegen intToLongCodegen = new TypeCastPropertyCodegen("int", "long");
//        System.out.println(intToLongCodegen.generateFromTarget("id", "userDto", "user"));
//        System.out.println(intToLongCodegen.generateToTarget("id", "userDto", "user"));
//        System.out.println("");
//
//    }
//}
