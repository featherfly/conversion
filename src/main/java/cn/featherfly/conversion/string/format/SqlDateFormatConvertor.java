
package cn.featherfly.conversion.string.format;

import java.sql.Date;

import cn.featherfly.conversion.string.basic.SqlDateConvertor;

/**
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 *
 * @author 钟冀
 */
public class SqlDateFormatConvertor extends AbstractSqlDateFormatConvertor<Date> {

    /**
     * Instantiates a new sql date format convertor.
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
