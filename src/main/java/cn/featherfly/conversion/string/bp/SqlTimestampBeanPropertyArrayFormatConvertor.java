package cn.featherfly.conversion.string.bp;
import java.sql.Timestamp;

import cn.featherfly.conversion.string.format.SqlTimestampFormatConvertor;


/**
 * <p>
 * Date[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimestampBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Timestamp[], Timestamp> {

    /**
     */
    public SqlTimestampBeanPropertyArrayFormatConvertor() {
        super(new SqlTimestampFormatConvertor());
    }    
}
