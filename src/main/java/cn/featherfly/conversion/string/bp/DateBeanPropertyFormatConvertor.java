
package cn.featherfly.conversion.string.bp;

import java.util.Date;

import cn.featherfly.conversion.string.format.DateFormatConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class DateBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Date> {

    /**
     */
    public DateBeanPropertyFormatConvertor() {
        super(new DateFormatConvertor());
    }
}
