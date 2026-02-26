
package cn.featherfly.conversion.string.bp;

import java.time.LocalTime;

import cn.featherfly.conversion.string.format.LocalTimeFormatConvertor;

/**
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 *
 * @author 钟冀
 */
public class LocalTimeBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<LocalTime> {

    /**
     * Instantiates a new local time bean property format convertor.
     */
    public LocalTimeBeanPropertyFormatConvertor() {
        super(new LocalTimeFormatConvertor());
    }
}
