package cn.featherfly.conversion.codegen.convertor;

import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Date to long convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToStringConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    private final String format;

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param format the format
     */
    public DateToStringConvertorCodegen(String format) {
        this(Date.class, format);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param format the format
     */
    public <D extends Date> DateToStringConvertorCodegen(String sourceType, String format) {
        super(sourceType, long.class.getName());
        this.format = format;
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param format the format
     */
    public <D extends Date> DateToStringConvertorCodegen(Class<D> sourceType, String format) {
        this(CodegenUtils.getClassName(sourceType), format);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        return Str.format("cn.featherfly.common.lang.Dates.format({0}, \"{1}\")", source, format);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        return Str.format("cn.featherfly.common.lang.Dates.parse({0}, \"{1}\")", target, format);
    }
}
