
package cn.featherfly.conversion.string.basic;

import java.sql.Date;

/**
 * SqlDateArray类转换器.
 *
 * @author 钟冀
 */
public class SqlDateArrayConvertor extends GenericTypeArrayConvertor<Date[], Date> {

    /**
     * Instantiates a new sql date array convertor.
     */
    public SqlDateArrayConvertor() {
        super(new SqlDateConvertor());
    }
}
