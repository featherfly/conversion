
package cn.featherfly.conversion.string.basic;

import java.util.Date;

/**
 * Date类转换器.
 *
 * @author 钟冀
 */
public class DateConvertor extends AbstractDateConvertor<Date> {

    /**
     * Instantiates a new date convertor.
     */
    public DateConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getFormat() {
        return "yyyy-MM-dd HH:mm:ss";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getFormats() {
        return new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd" };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Date convert(Date date) {
        return date;
    }
}
