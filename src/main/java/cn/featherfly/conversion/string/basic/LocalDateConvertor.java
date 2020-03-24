
package cn.featherfly.conversion.string.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.ConversionException;

/**
 * <p>
 * LocalDate类转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateConvertor extends AbstractBasicConvertor<LocalDate, GenericType<LocalDate>> {

	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd";

	private static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

	/**
	 */
	public LocalDateConvertor() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String doToString(LocalDate value, GenericType<LocalDate> genericType) {
		if (value != null) {
			return value.format(DATE_TIME_PATTERN);
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LocalDate doToObject(String value, GenericType<LocalDate> genericType) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
			try {
				return LocalDate.parse(value, DATE_TIME_PATTERN);
			} catch (Exception e) {
				throw new ConversionException("#convert_failed_with_type",
						new Object[] { value, DATE_TIME_FORMAT, getSourceType().getName() });
			}
		}
		return null;
	}

}
