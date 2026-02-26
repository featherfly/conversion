package cn.featherfly.conversion.string.bp;

import java.time.LocalDate;

import cn.featherfly.conversion.string.format.LocalDateFormatConvertor;

/**
 * LocalDate[]转换器.
 *
 * @author 钟冀
 */
public class LocalDateBeanPropertyArrayFormatConvertor
    extends BeanPropertyArrayFormatConvertor<LocalDate[], LocalDate> {

    /**
     * Instantiates a new local date bean property array format convertor.
     */
    public LocalDateBeanPropertyArrayFormatConvertor() {
        super(new LocalDateFormatConvertor());
    }
}
