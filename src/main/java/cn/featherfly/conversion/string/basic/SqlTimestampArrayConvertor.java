
package cn.featherfly.conversion.string.basic;

import java.sql.Timestamp;

/**
 * <p>
 * TimestampArray类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimestampArrayConvertor extends GenericTypeArrayConvertor<Timestamp[], Timestamp> {

    /**
     */
    public SqlTimestampArrayConvertor() {
    	super(new SqlTimestampConvertor());
    }
}
