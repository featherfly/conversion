package cn.featherfly.conversion.core.bp;
import java.sql.Timestamp;

import cn.featherfly.conversion.core.format.SqlTimestampFormatConvertor;


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
