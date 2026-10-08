
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-23 00:40:23
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * AbstractSimpleConvertorCodegen.
 *
 * @author zhongj
 */
public abstract class AbstractSimpleConvertorCodegen extends AbstractConvertorCodegen {

    private static final String ARRAY_END = "[i]";
    private static final String LIST_END = ".get(i)";

    /**
     * Instantiates a new abstract convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public AbstractSimpleConvertorCodegen(String sourceType, String targetType) {
        this(sourceType, targetType, false);
    }

    /**
     * Instantiates a new abstract convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param inverse the inverse
     */
    public AbstractSimpleConvertorCodegen(String sourceType, String targetType, boolean inverse) {
        super(sourceType, targetType, inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(ConvertibleProperty property, String source, String target) {
        return generateToTarget(source, target, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(ConvertibleProperty property, String target, String source) {
        return generateToSource(target, source, property);
    }

    private String generateToTarget(String source, String target, ConvertibleProperty property) {
        if (property.targetType().isArray()) {
            return target + " = " + toTarget(source, property) + ";";
        } else if (property.targetType().isCollection()) {
            if (target.endsWith(ARRAY_END)) {
                return target.substring(0, target.length() - ARRAY_END.length()) + ".add(" + toTarget(source, property)
                    + ");";
            } else if (source.endsWith(LIST_END)) {
                return target.substring(0, target.length() - LIST_END.length()) + ".add(" + toTarget(source, property)
                    + ");";
            } else {
                return target + ".add(" + toTarget(source, property) + ");";
            }
        } else if (target.endsWith("()")) {
            String tar = target.replaceAll("\\.get", ".set");
            tar = tar.substring(0, tar.length() - 1);
            return tar + toTarget(source, property) + ");";
        } else {
            return target + " = " + toTarget(source, property) + ";";
        }
    }

    private String generateToSource(String target, String source, ConvertibleProperty property) {
        if (property.sourceType().isArray()) {
            return source + " = " + toSource(target, property) + ";";
        } else if (property.sourceType().isCollection()) {
            if (source.endsWith(ARRAY_END)) {
                return source.substring(0, source.length() - ARRAY_END.length()) + ".add(" + toSource(target, property)
                    + ");";
            } else if (source.endsWith(LIST_END)) {
                return source.substring(0, source.length() - LIST_END.length()) + ".add(" + toSource(target, property)
                    + ");";
            } else {
                return source + ".add(" + toSource(target, property) + ");";
            }
        } else if (source.endsWith("()")) {
            if (source.indexOf('.') == -1) {
                String src = "s" + source.substring(1, source.length() - 1);
                return src + toSource(target, property) + ");";
            } else {
                String src = source.replaceAll("\\.get", ".set");
                src = src.substring(0, src.length() - 1);
                return src + toSource(target, property) + ");";
            }

        } else {
            return source + " = " + toSource(target, property) + ";";
        }
    }

    /**
     * To target.
     *
     * @param content the content
     * @param property the property
     * @return the string
     */
    protected abstract String toTarget(String content, ConvertibleProperty property);

    /**
     * To source.
     *
     * @param content the content
     * @param property the property
     * @return the string
     */
    protected abstract String toSource(String content, ConvertibleProperty property);
}
