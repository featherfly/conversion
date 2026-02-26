
package cn.featherfly.conversion.string.basic;

import java.time.LocalTime;

/**
 * LocalTime[]转换器.
 *
 * @author 钟冀
 */
public class LocalTimeArrayConvertor extends GenericTypeArrayConvertor<LocalTime[], LocalTime> {

    /**
     * Instantiates a new local time array convertor.
     */
    public LocalTimeArrayConvertor() {
        super(new LocalTimeConvertor());
    }
}
