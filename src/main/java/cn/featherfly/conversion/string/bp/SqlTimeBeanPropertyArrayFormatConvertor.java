package cn.featherfly.conversion.string.bp;

import java.sql.Time;

import cn.featherfly.conversion.string.format.SqlTimeFormatConvertor;

/**
 * java.sql.Time[]转换器
 *
 * @author 钟冀
 */
public class SqlTimeBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Time[], Time> {

    /**
     * Instantiates a new sql time bean property array format convertor.
     */
    public SqlTimeBeanPropertyArrayFormatConvertor() {
        super(new SqlTimeFormatConvertor());
    }
}
