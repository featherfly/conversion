
package cn.featherfly.conversion.string.basic;

import java.time.LocalTime;


/**
 * <p>
 * LocalTime[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalTimeArrayConvertor extends GenericTypeArrayConvertor<LocalTime[], LocalTime> {

    /**
     */
    public LocalTimeArrayConvertor() {
        super(new LocalTimeConvertor());
    }
}
