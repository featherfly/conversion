
package cn.featherfly.conversion.core.basic;

import java.sql.Date;

/**
 * <p>
 * SqlDateArray类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlDateArrayConvertor extends GenericTypeArrayConvertor<Date[], Date> {

	/**
     */
    public SqlDateArrayConvertor() {
        super(new SqlDateConvertor());
    }
}
