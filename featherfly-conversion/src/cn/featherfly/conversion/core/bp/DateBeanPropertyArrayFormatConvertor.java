package cn.featherfly.conversion.core.bp;
import java.util.Date;

import cn.featherfly.conversion.core.format.DateFormatConvertor;


/**
 * <p>
 * Date[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class DateBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Date[], Date> {

    /**
     */
    public DateBeanPropertyArrayFormatConvertor() {
        super(new DateFormatConvertor());
    }    
}
