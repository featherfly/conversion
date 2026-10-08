package cn.featherfly.conversion.codegen.convertor;

import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;

/**
 * The type Date to long convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToStringConvertorCodegen extends AbstractSimpleConvertorCodegen {

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
     * @param format the format
     * @param inverse the inverse
     */
    public DateToStringConvertorCodegen(String format, boolean inverse) {
        this(Date.class, format, inverse);
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param format the format
     */
    public <D extends Date> DateToStringConvertorCodegen(String sourceType, String format) {
        super(CodegenUtils.getClassName(sourceType), long.class.getName());
        this.format = format;
    }

    /**
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param format the format
     * @param inverse the inverse
     */
    public <D extends Date> DateToStringConvertorCodegen(String sourceType, String format, boolean inverse) {
        super(CodegenUtils.getClassName(sourceType), long.class.getName(), inverse);
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
     * Instantiates a new Date to long convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     * @param format the format
     * @param inverse the inverse
     */
    public <D extends Date> DateToStringConvertorCodegen(Class<D> sourceType, String format, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), format, inverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toTarget(String content, ConvertibleProperty property) {
        if (inverse) {
            return parse(content);
        }
        return format(content, format);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String toSource(String content, ConvertibleProperty property) {
        if (inverse) {
            return format(content, format);
        }
        return parse(content);
    }

    private String parse(String src) {
        return Str.format("cn.featherfly.common.lang.Dates.parse({0}, \"{1}\")", src, format);
    }
}
