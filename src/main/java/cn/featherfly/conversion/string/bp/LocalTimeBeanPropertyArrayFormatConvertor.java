package cn.featherfly.conversion.string.bp;

import java.time.LocalTime;

import cn.featherfly.conversion.string.format.LocalTimeFormatConvertor;

/**
 * LocalTime[]转换器.
 *
 * @author 钟冀
 */
public class LocalTimeBeanPropertyArrayFormatConvertor
    extends BeanPropertyArrayFormatConvertor<LocalTime[], LocalTime> {

    /**
     * Instantiates a new local time bean property array format convertor.
     */
    public LocalTimeBeanPropertyArrayFormatConvertor() {
        super(new LocalTimeFormatConvertor());
    }
}
