
package cn.featherfly.conversion.string.basic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.ConversionException;

/**
 * <p>
 * LocalDateTime类转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateTimeConvertor extends AbstractBasicConvertor<LocalDateTime, GenericType<LocalDateTime>> {

	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

	/**
	 */
	public LocalDateTimeConvertor() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String doToString(LocalDateTime value, GenericType<LocalDateTime> genericType) {
		if (value != null) {
			return value.format(DATE_TIME_PATTERN);
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LocalDateTime doToObject(String value, GenericType<LocalDateTime> genericType) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
			try {
				return LocalDateTime.parse(value, DATE_TIME_PATTERN);
			} catch (Exception e) {
				throw new ConversionException("#convert_failed_with_type",
						new Object[] { value, DATE_TIME_FORMAT, getSourceType().getName() });
			}
		}
		return null;
	}
}
