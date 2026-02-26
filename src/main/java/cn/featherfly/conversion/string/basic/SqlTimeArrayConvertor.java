
package cn.featherfly.conversion.string.basic;

import java.sql.Time;

/**
 * SqlTimeArray类转换器.
 *
 * @author 钟冀
 */
public class SqlTimeArrayConvertor extends GenericTypeArrayConvertor<Time[], Time> {

    /**
     * Instantiates a new sql time array convertor.
     */
    public SqlTimeArrayConvertor() {
        super(new SqlTimeConvertor());
    }
}
