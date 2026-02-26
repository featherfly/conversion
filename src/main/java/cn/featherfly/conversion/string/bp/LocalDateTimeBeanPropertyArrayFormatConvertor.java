package cn.featherfly.conversion.string.bp;

import java.time.LocalDateTime;

import cn.featherfly.conversion.string.format.LocalDateTimeFormatConvertor;

/**
 * LocalDateTime[]转换器.
 *
 * @author 钟冀
 */
public class LocalDateTimeBeanPropertyArrayFormatConvertor
    extends BeanPropertyArrayFormatConvertor<LocalDateTime[], LocalDateTime> {

    /**
     * Instantiates a new local date time bean property array format convertor.
     */
    public LocalDateTimeBeanPropertyArrayFormatConvertor() {
        super(new LocalDateTimeFormatConvertor());
    }
}
