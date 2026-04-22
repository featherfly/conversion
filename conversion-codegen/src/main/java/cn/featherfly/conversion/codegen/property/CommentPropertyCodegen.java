
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-23 02:48:23
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import java.util.Locale;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;

/**
 * CommentPropertyCodegen.
 *
 * @author zhongj
 */
public class CommentPropertyCodegen extends AbstractConvertible implements PropertyConverterCodegen {

    /**
     * Instantiates a new comment property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public CommentPropertyCodegen(String sourceType, String targetType) {
        super(sourceType, targetType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        if (Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage())) {
            if (Lang.isEmpty(sourceObjectName)) {
                return Str.format("// 没有对应的转换器 {0}[{2}] <-> {3}.{0}[{4}]", propertyName, sourceObjectName, sourceType,
                    targetObjectName, targetType);
            }
            return Str.format("// 没有对应的转换器 {1}.{0}[{2}] <-> {3}.{0}[{4}]", propertyName, sourceObjectName, sourceType,
                targetObjectName, targetType);
        } else {
            if (Lang.isEmpty(sourceObjectName)) {
                return Str.format("// no convertor for {1}.{0}[{2}] <-> {3}.{0}[{4}]", propertyName, sourceObjectName,
                    sourceType, targetObjectName, targetType);
            }
            return Str.format("// no convertor for {1}.{0}[{2}] <-> {3}.{0}[{4}]", propertyName, sourceObjectName,
                sourceType, targetObjectName, targetType);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName) {
        return generateToTarget(propertyName, sourceObjectName, targetObjectName);
    }

}
