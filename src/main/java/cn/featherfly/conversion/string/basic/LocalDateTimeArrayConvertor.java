
package cn.featherfly.conversion.string.basic;

import java.time.LocalDateTime;


/**
 * <p>
 * LocalDateTime[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalDateTimeArrayConvertor extends GenericTypeArrayConvertor<LocalDateTime[], LocalDateTime> {

    /**
     */
    public LocalDateTimeArrayConvertor() {
        super(new LocalDateTimeConvertor());
    }
}
