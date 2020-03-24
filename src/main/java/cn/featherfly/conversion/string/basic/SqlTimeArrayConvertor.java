
package cn.featherfly.conversion.string.basic;

import java.sql.Time;

/**
 * <p>
 * SqlTimeArray类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimeArrayConvertor extends GenericTypeArrayConvertor<Time[], Time> {

	/**
     */
    public SqlTimeArrayConvertor() {
        super(new SqlTimeConvertor());
    }
}
