package cn.featherfly.conversion.codegen.convertor;

import java.util.Date;

import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.AbstractConvertible;
import cn.featherfly.conversion.codegen.ConvertorCodegen;

/**
 * The type Date to long wrapper convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class DateToLongWrapperConvertorCodegen extends AbstractConvertible implements ConvertorCodegen {

    /**
     * Instantiates a new Date to long wrapper convertor codegen.
     */
    public DateToLongWrapperConvertorCodegen() {
        this(Date.class);
    }

    /**
     * Instantiates a new Date to long wrapper convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLongWrapperConvertorCodegen(Class<D> sourceType) {
        super(sourceType.getName(), Long.class.getName());
    }

    /**
     * Instantiates a new date to long wrapper convertor codegen.
     *
     * @param <D> the generic type
     * @param sourceType the source type
     */
    public <D extends Date> DateToLongWrapperConvertorCodegen(String sourceType) {
        super(sourceType, Long.class.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source) {
        return Str.format("{0}.getTime()", source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target) {
        return Str.format("new {0}({1})", sourceType, target);
    }
}
