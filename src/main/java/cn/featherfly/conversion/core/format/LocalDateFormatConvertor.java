
package cn.featherfly.conversion.core.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cn.featherfly.conversion.core.basic.LocalDateConvertor;

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
