package cn.featherfly.conversion.core.bp;
import java.sql.Time;

import cn.featherfly.conversion.core.format.SqlTimeFormatConvertor;


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
