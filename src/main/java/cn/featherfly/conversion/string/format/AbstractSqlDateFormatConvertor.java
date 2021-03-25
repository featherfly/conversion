
package cn.featherfly.conversion.string.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.lang.Lang;
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
public abstract class AbstractSqlDateFormatConvertor<T extends Date> extends FormatConvertor<T> {

    /**
     * @param convertor convertor
     */
    public AbstractSqlDateFormatConvertor(ToStringConvertor<T> convertor) {
        super(convertor);
    }
    
    protected abstract T convert(Date date);
    
    /**
	 * {@inheritDoc}
	 */
	@Override
	protected String formatToString(T value, FormatType<T> genericType) {
		if (genericType != null && StringUtils.isNotBlank(genericType.getFormat())) {
            SimpleDateFormat sdf = new SimpleDateFormat(genericType.getFormat());
            logger.debug("format {} to string with {}", getSourceType().getName(), genericType.getFormat());
            return sdf.format(value);
        }
        return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected T formatToObject(String value, FormatType<T> genericType) {
		if (genericType != null && Lang.isNotEmpty(genericType.getFormats())) {
            List<String> formats = genericType.getFormats();
            for (String format : formats) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                try {
                    Date d = sdf.parse(value);
                    logger.debug("parse {} with format[{}] success", value, format);
                    return convert(d);
                } catch (ParseException e) {
                	logger.debug("parse {} with format[{}] error", value, format);
                }
            }
            throw new ConversionException("#convert_failed_with_type", new Object[]{
            		value, formats, getSourceType().getName()});
        }
        return null;
	}
}
