
package cn.featherfly.conversion.core.basic;
import java.math.BigDecimal;


/**
 * <p>
 * BigDecimal[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class BigDecimalArrayConvertor extends GenericTypeArrayConvertor<BigDecimal[], BigDecimal> {

    /**
     */
    public BigDecimalArrayConvertor() {
        super(new BigDecimalConvertor());
    }
}
