
package cn.featherfly.conversion.string.basic;

import java.sql.Timestamp;
import java.util.Date;

/**
 * <p>
 * Timestamp类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimestampConvertor extends AbstractDateConvertor<Timestamp> {

    /**
     */
    public SqlTimestampConvertor() {
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
