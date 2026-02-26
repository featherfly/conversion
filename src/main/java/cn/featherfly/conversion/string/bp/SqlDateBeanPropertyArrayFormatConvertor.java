package cn.featherfly.conversion.string.bp;

import java.sql.Date;

import cn.featherfly.conversion.string.format.SqlDateFormatConvertor;

/**
 * java.sql.Date[]转换器
 *
 * @author 钟冀
 */
public class SqlDateBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Date[], Date> {

    /**
     * Instantiates a new sql date bean property array format convertor.
     */
    public SqlDateBeanPropertyArrayFormatConvertor() {
        super(new SqlDateFormatConvertor());
    }
}
