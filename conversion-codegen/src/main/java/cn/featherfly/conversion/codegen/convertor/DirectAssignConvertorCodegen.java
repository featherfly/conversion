package cn.featherfly.conversion.codegen.convertor;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * direct assign convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DirectAssignConvertorCodegen extends AbstractSimpleConvertorCodegen {

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
    protected String toTarget(String src, ConvertibleProperty property) {
        return src;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String src, ConvertibleProperty property) {
        return src;
    }
}
