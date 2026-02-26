
package cn.featherfly.conversion.string.bp;

import java.sql.Timestamp;

import cn.featherfly.conversion.string.format.SqlTimestampFormatConvertor;

/**
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 *
 * @author 钟冀
 */
public class SqlTimestampBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Timestamp> {

    /**
     * Instantiates a new sql timestamp bean property format convertor.
     */
    public SqlTimestampBeanPropertyFormatConvertor() {
        super(new SqlTimestampFormatConvertor());
    }
}
