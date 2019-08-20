
package cn.featherfly.conversion.core.basic;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;

/**
 * <p>
 * LocalTime类转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalTimeConvertor extends AbstractBasicConvertor<LocalTime, GenericType<LocalTime>> {

	private static final String DATE_TIME_FORMAT = "HH:mm:ss";

	private static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

	/**
	 */
	public LocalTimeConvertor() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String doToString(LocalTime value, GenericType<LocalTime> genericType) {
		if (value != null) {
			return value.format(DATE_TIME_PATTERN);
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LocalTime doToObject(String value, GenericType<LocalTime> genericType) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
			try {
				return LocalTime.parse(value, DATE_TIME_PATTERN);
			} catch (Exception e) {
				throw new ConversionException("#convert_failed_with_type",
						new Object[] { value, DATE_TIME_FORMAT, getType().getName() });
			}
		}
		return null;
	}
}
