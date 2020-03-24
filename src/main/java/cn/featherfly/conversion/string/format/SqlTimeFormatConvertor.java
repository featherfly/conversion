
package cn.featherfly.conversion.string.format;

import java.sql.Time;
import java.util.Date;

import cn.featherfly.conversion.string.basic.SqlTimeConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimeFormatConvertor extends AbstractSqlDateFormatConvertor<Time> {

    /**
     */
    public SqlTimeFormatConvertor() {
        super(new SqlTimeConvertor());
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Time convert(Date date) {
		return new Time(date.getTime());
	}

    
}
