
package cn.featherfly.conversion.string.bp;

import java.time.LocalDate;

import cn.featherfly.conversion.string.format.LocalDateFormatConvertor;

/**
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 *
 * @author 钟冀
 */
public class LocalDateBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<LocalDate> {

    /**
     * Instantiates a new local date bean property format convertor.
     */
    public LocalDateBeanPropertyFormatConvertor() {
        super(new LocalDateFormatConvertor());
    }
}
