package cn.featherfly.conversion.codegen.convertor;

import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Date to long convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLongConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    /**
     * Instantiates a new Date to long convertor codegen.
     */
    public DateToLongConvertorCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param inverse the inverse
     */
    public DateToLongConvertorCodegen(boolean inverse) {
        this(Date.class, inverse);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLongConvertorCodegen(Class<D> sourceType) {
        this(CodegenUtils.getClassName(sourceType));
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLongConvertorCodegen(Class<D> sourceType, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), inverse);
    }

    /**
     * Instantiates a new date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLongConvertorCodegen(String sourceType) {
        super(CodegenUtils.getClassName(sourceType), long.class.getName());
    }

    /**
     * Instantiates a new date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param inverse the inverse
     */
    public <D extends Date> DateToLongConvertorCodegen(String sourceType, boolean inverse) {
        super(CodegenUtils.getClassName(sourceType), long.class.getName(), inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        if (inverse) {
            return toDate(source);
        }
        return toLong(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        if (inverse) {
            return toLong(target);
        }
        return toDate(target);
    }

    private String toDate(String src) {
        return Str.format("new {0}({1})", sourceType, src);
    }

    private String toLong(String src) {
        return Str.format("{0}.getTime()", src);
    }
}
