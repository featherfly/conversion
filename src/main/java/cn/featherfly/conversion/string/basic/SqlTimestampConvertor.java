
package cn.featherfly.conversion.string.basic;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Timestamp类转换器.
 *
 * @author 钟冀
 */
public class SqlTimestampConvertor extends AbstractDateConvertor<Timestamp> {

    /**
     * Instantiates a new sql timestamp convertor.
     */
    public SqlTimestampConvertor() {
        super();
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
    protected Timestamp convert(Date date) {
        return new Timestamp(date.getTime());
    }
}
