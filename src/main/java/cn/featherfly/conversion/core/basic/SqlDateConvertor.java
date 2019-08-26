
package cn.featherfly.conversion.core.basic;

import java.sql.Date;

/**
 * <p>
 * SqlDate类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlDateConvertor extends AbstractDateConvertor<Date> {

    /**
     */
    public SqlDateConvertor() {
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
		return new String[]{"yyyy-MM-dd"};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Date convert(java.util.Date date) {
		return new Date(date.getTime());
	}
}
