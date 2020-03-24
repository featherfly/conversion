
package cn.featherfly.conversion.string.bp;

import java.sql.Time;

import cn.featherfly.conversion.string.format.SqlTimeFormatConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimeBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Time> {

    /**
     */
    public SqlTimeBeanPropertyFormatConvertor() {
        super(new SqlTimeFormatConvertor());
    }
}
