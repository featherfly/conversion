package cn.featherfly.conversion.string.bp;
import java.time.LocalDateTime;

import cn.featherfly.conversion.string.format.LocalDateTimeFormatConvertor;


/**
 * <p>
 * LocalDateTime[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateTimeBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<LocalDateTime[], LocalDateTime> {

    /**
     */
    public LocalDateTimeBeanPropertyArrayFormatConvertor() {
        super(new LocalDateTimeFormatConvertor());
    }    
}
