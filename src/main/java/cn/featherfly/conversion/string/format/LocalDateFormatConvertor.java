
package cn.featherfly.conversion.string.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cn.featherfly.conversion.string.basic.LocalDateConvertor;

/**
 * LocalDate类转换器
 *
 * @author 钟冀
 */
public class LocalDateFormatConvertor extends AbstractLocalDateTimeFormatConvertor<LocalDate> {

    /**
     * Instantiates a new local date format convertor.
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
