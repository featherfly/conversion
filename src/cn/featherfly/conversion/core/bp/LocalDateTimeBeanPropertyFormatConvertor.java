
package cn.featherfly.conversion.core.bp;

import java.time.LocalDateTime;

import cn.featherfly.conversion.core.format.LocalDateTimeFormatConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateTimeBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<LocalDateTime> {

    /**
     */
    public LocalDateTimeBeanPropertyFormatConvertor() {
        super(new LocalDateTimeFormatConvertor());
    }
}
