
package cn.featherfly.conversion.string.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import cn.featherfly.conversion.string.basic.LocalDateTimeConvertor;

/**
 * <p>
 * LocalDate类转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateTimeFormatConvertor extends AbstractLocalDateTimeFormatConvertor<LocalDateTime> {

	/**
	 */
	public LocalDateTimeFormatConvertor() {
		super(new LocalDateTimeConvertor());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LocalDateTime convert(String value, DateTimeFormatter formatter) {		
		return LocalDateTime.parse(value, formatter);
	}
}
