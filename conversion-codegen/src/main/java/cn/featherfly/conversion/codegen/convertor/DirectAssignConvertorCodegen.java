package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * direct assign convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DirectAssignConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new direct assign convertor codegen.
     *
     * @param type the type
     */
    public DirectAssignConvertorCodegen(Class<?> type) {
        this(CodegenUtils.getClassName(type));
    }

    /**
     * Instantiates a new direct assign convertor codegen.
     *
     * @param type the type
     */
    public DirectAssignConvertorCodegen(String type) {
        super(type, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        return source;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        return target;
    }
}
