package cn.featherfly.conversion.core.bp;
import java.sql.Date;

import cn.featherfly.conversion.core.format.SqlDateFormatConvertor;


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
