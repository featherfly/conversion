
package cn.featherfly.conversion.string.basic;

import java.time.LocalDateTime;

/**
 * LocalDateTime[]转换器.
 *
 * @author 钟冀
 */
public class LocalDateTimeArrayConvertor extends GenericTypeArrayConvertor<LocalDateTime[], LocalDateTime> {

    /**
     * Instantiates a new local date time array convertor.
     */
    public LocalDateTimeArrayConvertor() {
        super(new LocalDateTimeConvertor());
    }
}
