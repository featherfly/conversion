
package cn.featherfly.conversion.core.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;
import cn.featherfly.conversion.core.Convertor;

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
    public AbstractSqlDateFormatConvertor(Convertor<T> convertor) {
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
            return sdf.format(value);
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
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                try {
                    Date d = sdf.parse(value);
                    return convert(d);
                } catch (ParseException e) {
                    LogUtils.debug(e, logger);
                }
            }
            
            throw new ConversionException("#convert_failed_with_type", new Object[]{
            		value, formats, getType().getName()});
        }
        return null;
	}
}
