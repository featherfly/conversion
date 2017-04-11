
package cn.featherfly.conversion.core.bp;

import java.sql.Timestamp;

import cn.featherfly.conversion.core.format.SqlTimestampFormatConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimestampBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Timestamp> {

    /**
     */
    public SqlTimestampBeanPropertyFormatConvertor() {
        super(new SqlTimestampFormatConvertor());
    }
}
