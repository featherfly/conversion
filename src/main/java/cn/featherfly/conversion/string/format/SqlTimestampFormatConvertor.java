
package cn.featherfly.conversion.string.format;

import java.sql.Timestamp;
import java.util.Date;

import cn.featherfly.conversion.string.basic.SqlTimestampConvertor;

/**
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 *
 * @author 钟冀
 */
public class SqlTimestampFormatConvertor extends AbstractSqlDateFormatConvertor<Timestamp> {

    /**
     * Instantiates a new sql timestamp format convertor.
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
