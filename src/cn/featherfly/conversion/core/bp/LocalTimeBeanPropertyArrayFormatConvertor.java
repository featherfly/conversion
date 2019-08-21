package cn.featherfly.conversion.core.bp;
import java.time.LocalTime;

import cn.featherfly.conversion.core.format.LocalTimeFormatConvertor;


/**
 * <p>
 * LocalTime[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalTimeBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<LocalTime[], LocalTime> {

    /**
     */
    public LocalTimeBeanPropertyArrayFormatConvertor() {
        super(new LocalTimeFormatConvertor());
    }    
}
