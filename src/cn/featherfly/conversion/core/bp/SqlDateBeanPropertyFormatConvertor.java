
package cn.featherfly.conversion.core.bp;

import java.sql.Date;

import cn.featherfly.conversion.core.format.SqlDateFormatConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlDateBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Date> {

    /**
     */
    public SqlDateBeanPropertyFormatConvertor() {
        super(new SqlDateFormatConvertor());
    }
}
