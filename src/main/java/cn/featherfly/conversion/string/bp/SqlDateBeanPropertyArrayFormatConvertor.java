package cn.featherfly.conversion.string.bp;
import java.sql.Date;

import cn.featherfly.conversion.string.format.SqlDateFormatConvertor;


/**
 * <p>
 * java.sql.Date[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlDateBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Date[], Date> {

    /**
     */
    public SqlDateBeanPropertyArrayFormatConvertor() {
        super(new SqlDateFormatConvertor());
    }    
}
