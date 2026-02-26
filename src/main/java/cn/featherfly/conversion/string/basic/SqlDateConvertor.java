
package cn.featherfly.conversion.string.basic;

import java.sql.Date;

/**
 * SqlDate类转换器.
 *
 * @author 钟冀
 */
public class SqlDateConvertor extends AbstractDateConvertor<Date> {

    /**
     * Instantiates a new sql date convertor.
     */
    public SqlDateConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getFormat() {
        return "yyyy-MM-dd";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getFormats() {
        return new String[] { "yyyy-MM-dd" };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Date convert(java.util.Date date) {
        return new Date(date.getTime());
    }
}
