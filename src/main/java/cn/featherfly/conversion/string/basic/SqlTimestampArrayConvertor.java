
package cn.featherfly.conversion.string.basic;

import java.sql.Timestamp;

/**
 * TimestampArray类转换器.
 *
 * @author 钟冀
 */
public class SqlTimestampArrayConvertor extends GenericTypeArrayConvertor<Timestamp[], Timestamp> {

    /**
     * Instantiates a new sql timestamp array convertor.
     */
    public SqlTimestampArrayConvertor() {
        super(new SqlTimestampConvertor());
    }
}
