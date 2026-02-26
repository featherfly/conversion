
package cn.featherfly.conversion.string.bp;

import java.time.LocalDateTime;

import cn.featherfly.conversion.string.format.LocalDateTimeFormatConvertor;

/**
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 *
 * @author 钟冀
 */
public class LocalDateTimeBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<LocalDateTime> {

    /**
     * Instantiates a new local date time bean property format convertor.
     */
    public LocalDateTimeBeanPropertyFormatConvertor() {
        super(new LocalDateTimeFormatConvertor());
    }
}
