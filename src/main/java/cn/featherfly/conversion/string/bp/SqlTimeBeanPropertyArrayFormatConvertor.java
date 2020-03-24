package cn.featherfly.conversion.string.bp;
import java.sql.Time;

import cn.featherfly.conversion.string.format.SqlTimeFormatConvertor;


/**
 * <p>
 * java.sql.Time[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimeBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Time[], Time> {

    /**
     */
    public SqlTimeBeanPropertyArrayFormatConvertor() {
        super(new SqlTimeFormatConvertor());
    }    
}
