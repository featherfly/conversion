
package cn.featherfly.conversion.core.basic;

import java.time.LocalDate;


/**
 * <p>
 * LocalDate[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateArrayConvertor extends GenericTypeArrayConvertor<LocalDate[], LocalDate> {

    /**
     */
    public LocalDateArrayConvertor() {
        super(new LocalDateConvertor());
    }
}
