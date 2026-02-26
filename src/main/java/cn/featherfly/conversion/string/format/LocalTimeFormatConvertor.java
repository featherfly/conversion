
package cn.featherfly.conversion.string.format;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import cn.featherfly.conversion.string.basic.LocalTimeConvertor;

/**
 * LocalTime类转换器
 *
 * @author 钟冀
 */
public class LocalTimeFormatConvertor extends AbstractLocalDateTimeFormatConvertor<LocalTime> {

    /**
     * Instantiates a new local time format convertor.
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
