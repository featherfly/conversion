
package cn.featherfly.conversion.string.bp;

import java.time.LocalTime;

import cn.featherfly.conversion.string.format.LocalTimeFormatConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class LocalTimeBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<LocalTime> {

    /**
     */
    public LocalTimeBeanPropertyFormatConvertor() {
        super(new LocalTimeFormatConvertor());
    }
}
