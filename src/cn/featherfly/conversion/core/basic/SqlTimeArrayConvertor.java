
package cn.featherfly.conversion.core.basic;

import java.sql.Time;

/**
 * <p>
 * SqlDateArray类转换器
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
