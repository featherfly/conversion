
package cn.featherfly.conversion.string.bp;

import java.sql.Date;

import cn.featherfly.conversion.string.format.SqlDateFormatConvertor;

/**
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 *
 * @author 钟冀
 */
public class SqlDateBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Date> {

    /**
     * Instantiates a new sql date bean property format convertor.
     */
    public SqlDateBeanPropertyFormatConvertor() {
        super(new SqlDateFormatConvertor());
    }
}
