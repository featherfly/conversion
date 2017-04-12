
package cn.featherfly.conversion.core.basic;

import java.util.Date;

/**
 * <p>
 * Date类转换器
 * </p>
 *
 * @author 钟冀
 */
public class DateConvertor extends AbstractDateConvertor<Date> {

    /**
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
		return new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Date convert(Date date) {
		return date;
	}
}
