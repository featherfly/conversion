
package cn.featherfly.conversion.string.format;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import cn.featherfly.conversion.string.basic.LocalTimeConvertor;

/**
 * <p>
 * LocalTime类转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalTimeFormatConvertor extends AbstractLocalDateTimeFormatConvertor<LocalTime> {

	/**
	 */
	public LocalTimeFormatConvertor() {
		super(new LocalTimeConvertor());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LocalTime convert(String value, DateTimeFormatter formatter) {		
		return LocalTime.parse(value, formatter);
	}
}
