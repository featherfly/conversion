
package cn.featherfly.conversion.core.basic;

import java.sql.Time;
import java.util.Date;

/**
 * <p>
 * SqlTime类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimeConvertor extends AbstractDateConvertor<Time> {

    /**
     */
    public SqlTimeConvertor() {
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
		return new String[]{"HH:mm:ss"};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Time convert(Date date) {
		return new Time(date.getTime());
	}
}
