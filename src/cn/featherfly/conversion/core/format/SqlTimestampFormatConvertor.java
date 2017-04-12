
package cn.featherfly.conversion.core.format;

import java.sql.Timestamp;
import java.util.Date;

import cn.featherfly.conversion.core.basic.SqlTimestampConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimestampFormatConvertor extends AbstractSqlDateFormatConvertor<Timestamp> {

    /**
     */
    public SqlTimestampFormatConvertor() {
        super(new SqlTimestampConvertor());
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Timestamp convert(Date date) {
		return new Timestamp(date.getTime());
	}
}
