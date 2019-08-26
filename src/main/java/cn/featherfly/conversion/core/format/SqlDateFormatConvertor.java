
package cn.featherfly.conversion.core.format;

import java.sql.Date;

import cn.featherfly.conversion.core.basic.SqlDateConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlDateFormatConvertor extends AbstractSqlDateFormatConvertor<Date> {

    /**
     */
    public SqlDateFormatConvertor() {
        super(new SqlDateConvertor());
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Date convert(java.util.Date date) {
		return new Date(date.getTime());
	}
}
