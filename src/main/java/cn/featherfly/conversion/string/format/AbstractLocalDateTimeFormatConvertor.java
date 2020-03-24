
package cn.featherfly.conversion.string.format;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.util.List;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.string.ToStringConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public abstract class AbstractLocalDateTimeFormatConvertor<T extends Temporal> extends FormatConvertor<T> {

    /**
     * @param convertor convertor
     */
    public AbstractLocalDateTimeFormatConvertor(ToStringConvertor<T> convertor) {
        super(convertor);
    }
    
    protected abstract T convert(String value, DateTimeFormatter formatter);
    
    /**
	 * {@inheritDoc}
	 */
	@Override
	protected String formatToString(T value, FormatType<T> genericType) {
		if (genericType != null && StringUtils.isNotBlank(genericType.getFormat())) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(genericType.getFormat());
			logger.debug("format {} to string with {}", getSourceType().getName(), genericType.getFormat());
			return dateTimeFormatter.format(value);
        }
        return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected T formatToObject(String value, FormatType<T> genericType) {
		if (genericType != null && LangUtils.isNotEmpty(genericType.getFormats())) {
            List<String> formats = genericType.getFormats();
            for (String format : formats) {
            	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
                try {
                	T t = convert(value, dateTimeFormatter);
                	logger.debug("parse {} with format[{}] success", value, format);
                    return t;
                } catch (DateTimeParseException e) {
                	logger.debug("parse {} with format[{}] error", value, format);
                }
            }
            throw new ConversionException("#convert_failed_with_type", new Object[]{
            		value, formats, getSourceType().getName()}
            		);
        }
        return null;
	}
}
