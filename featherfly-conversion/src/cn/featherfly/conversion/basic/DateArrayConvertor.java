
package cn.featherfly.conversion.basic;

import java.util.Date;


/**
 * <p>
 * Date[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class DateArrayConvertor extends GenericClassArrayConvertor<Date[], Date> {

    /**
     */
    public DateArrayConvertor() {
        super(new DateConvertor());
    }
}
