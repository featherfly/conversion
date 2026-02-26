
package cn.featherfly.conversion.string.basic;

import java.time.LocalDate;

/**
 * LocalDate[]转换器.
 *
 * @author 钟冀
 */
public class LocalDateArrayConvertor extends GenericTypeArrayConvertor<LocalDate[], LocalDate> {

    /**
     * Instantiates a new local date array convertor.
     */
    public LocalDateArrayConvertor() {
        super(new LocalDateConvertor());
    }
}
