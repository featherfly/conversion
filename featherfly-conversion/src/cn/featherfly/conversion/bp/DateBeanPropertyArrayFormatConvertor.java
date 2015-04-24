package cn.featherfly.conversion.bp;
import java.util.Date;

import cn.featherfly.conversion.format.DateFormatConvertor;


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
