
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-22 17:48:22
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * bean to bean convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class BeanToBeanConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    private String toSourceName;

    private String toTargetName;

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public BeanToBeanConvertorCodegen(Class<?> sourceType, Class<?> targetType) {
        this(sourceType, targetType, null, null);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param inverse the inverse
     */
    public BeanToBeanConvertorCodegen(Class<?> sourceType, Class<?> targetType, boolean inverse) {
        this(sourceType, targetType, null, null, inverse);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public BeanToBeanConvertorCodegen(String sourceType, String targetType) {
        this(sourceType, targetType, null, null);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param inverse the inverse
     */
    public BeanToBeanConvertorCodegen(String sourceType, String targetType, boolean inverse) {
        this(sourceType, targetType, null, null, inverse);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     */
    public BeanToBeanConvertorCodegen(Class<?> sourceType, Class<?> targetType, String toSourceName,
        String toTargetName) {
        this(CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType), toSourceName, toTargetName);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     * @param inverse the inverse
     */
    public BeanToBeanConvertorCodegen(Class<?> sourceType, Class<?> targetType, String toSourceName,
        String toTargetName, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType), toSourceName, toTargetName,
            inverse);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     */
    public BeanToBeanConvertorCodegen(String sourceType, String targetType, String toSourceName,
        String toTargetName) {
        this(sourceType, targetType, toSourceName, toTargetName, false);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     * @param inverse the inverse
     */
    public BeanToBeanConvertorCodegen(String sourceType, String targetType, String toSourceName,
        String toTargetName, boolean inverse) {
        super(sourceType, targetType);
        if (Lang.isEmpty(toSourceName)) {
            this.toSourceName = CodegenUtils.getNewConstructor(sourceType);
        } else {
            this.toSourceName = toSourceName;
        }
        if (Lang.isEmpty(toTargetName)) {
            this.toTargetName = CodegenUtils.getToTypeMethod(targetType);
        } else {
            this.toTargetName = toTargetName;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (inverse) {
            return Str.format("{0}({1})", toSourceName, source);
        }
        return Str.format("{0}.{1}()", source, toTargetName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return Str.format("{0}.{1}()", target, toTargetName);
        }
        return Str.format("{0}({1})", toSourceName, target);
    }
}
