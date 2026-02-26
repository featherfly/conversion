
package cn.featherfly.conversion.string.basic;

import java.util.Date;

/**
 * Date[]转换器.
 *
 * @author 钟冀
 */
public class DateArrayConvertor extends GenericTypeArrayConvertor<Date[], Date> {

    /**
     * Instantiates a new date array convertor.
     */
    public DateArrayConvertor() {
        super(new DateConvertor());
    }
}
