
package cn.featherfly.conversion.string.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cn.featherfly.conversion.string.basic.LocalDateConvertor;

/**
 * <p>
 * LocalDate类转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateFormatConvertor extends AbstractLocalDateTimeFormatConvertor<LocalDate> {

	/**
	 */
	public LocalDateFormatConvertor() {
		super(new LocalDateConvertor());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LocalDate convert(String value, DateTimeFormatter formatter) {		
		return LocalDate.parse(value, formatter);
	}
}
