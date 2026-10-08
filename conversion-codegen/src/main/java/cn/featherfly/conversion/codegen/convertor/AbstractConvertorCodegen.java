
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-23 00:40:23
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * AbstractSimpleConvertorCodegen.
 *
 * @author zhongj
 */
public abstract class AbstractConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {
    /** The inverse. */
    protected final boolean inverse;

    /**
     * Instantiates a new abstract convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public AbstractConvertorCodegen(String sourceType, String targetType) {
        this(sourceType, targetType, false);
    }

    /**
     * Instantiates a new abstract convertor codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param inverse the inverse
     */
    public AbstractConvertorCodegen(String sourceType, String targetType, boolean inverse) {
        super(sourceType, targetType);
        this.inverse = inverse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String sourceType() {
        if (inverse) {
            return CodegenUtils.getClassNameForSrc(targetType);
        }
        return CodegenUtils.getClassNameForSrc(sourceType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String targetType() {
        if (inverse) {
            return CodegenUtils.getClassNameForSrc(sourceType);
        }
        return CodegenUtils.getClassNameForSrc(targetType);
    }

    /**
     * Checks if is inverse.
     *
     * @return true, if is inverse
     */
    @Override
    public boolean isInverse() {
        return inverse;
    }

    /**
     * To enum.
     *
     * @param toType the to type
     * @param src the src
     * @return the string
     */
    protected String toEnum(String toType, String src) {
        return Str.format("cn.featherfly.common.lang.Lang.toEnum({0}.class, {1})", toType, src);
    }

    /**
     * Format.
     *
     * @param src the src
     * @param format the format
     * @return the string
     */
    protected String format(String src, String format) {
        return Str.format("cn.featherfly.common.lang.Dates.format({0}, \"{1}\")", src, format);
    }
}
