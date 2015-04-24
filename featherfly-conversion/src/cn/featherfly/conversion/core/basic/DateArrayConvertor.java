
package cn.featherfly.conversion.core.basic;

import java.util.Date;


/**
 * <p>
 * Date[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class DateArrayConvertor extends GenericTypeArrayConvertor<Date[], Date> {

    /**
     */
    public DateArrayConvertor() {
        super(new DateConvertor());
    }
}
