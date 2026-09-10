
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-23 02:48:23
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.convertor;

import java.util.Locale;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * CommentConvertorCodegen.
 *
 * @author zhongj
 */
public class CommentConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    /**
     * Instantiates a new comment property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public CommentConvertorCodegen(String sourceType, String targetType) {
        super(sourceType, targetType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage())) {
            return Str.format("// 没有对应的转换器 {0} <-> {1}", sourceType, targetType);
        } else {
            return Str.format("// no convertor for {0} <-> {1}", sourceType, targetType);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        return generateToTarget(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInverse() {
        return false;
    }

}
