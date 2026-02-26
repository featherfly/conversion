
package cn.featherfly.conversion.string.basic;

import java.sql.Time;
import java.util.Date;

/**
 * SqlTime类转换器.
 *
 * @author 钟冀
 */
public class SqlTimeConvertor extends AbstractDateConvertor<Time> {

    /**
     * Instantiates a new sql time convertor.
     */
    public SqlTimeConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getFormat() {
        return "HH:mm:ss";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getFormats() {
        return new String[] { "HH:mm:ss" };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Time convert(Date date) {
        return new Time(date.getTime());
    }
}
