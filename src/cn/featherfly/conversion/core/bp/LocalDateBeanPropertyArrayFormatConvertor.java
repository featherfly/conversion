package cn.featherfly.conversion.core.bp;
import java.time.LocalDate;

import cn.featherfly.conversion.core.format.LocalDateFormatConvertor;


/**
 * <p>
 * LocalDate[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<LocalDate[], LocalDate> {

    /**
     */
    public LocalDateBeanPropertyArrayFormatConvertor() {
        super(new LocalDateFormatConvertor());
    }    
}
