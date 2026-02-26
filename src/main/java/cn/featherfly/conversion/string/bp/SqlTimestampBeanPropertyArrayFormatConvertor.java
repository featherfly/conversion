package cn.featherfly.conversion.string.bp;

import java.sql.Timestamp;

import cn.featherfly.conversion.string.format.SqlTimestampFormatConvertor;

/**
 * Date[]转换器.
 *
 * @author 钟冀
 */
public class SqlTimestampBeanPropertyArrayFormatConvertor
    extends BeanPropertyArrayFormatConvertor<Timestamp[], Timestamp> {

    /**
     * Instantiates a new sql timestamp bean property array format convertor.
     */
    public SqlTimestampBeanPropertyArrayFormatConvertor() {
        super(new SqlTimestampFormatConvertor());
    }
}
