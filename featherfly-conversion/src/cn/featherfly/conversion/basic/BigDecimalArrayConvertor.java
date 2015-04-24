
package cn.featherfly.conversion.basic;
import java.math.BigDecimal;


/**
 * <p>
 * BigDecimal[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class BigDecimalArrayConvertor extends GenericClassArrayConvertor<BigDecimal[], BigDecimal> {

    /**
     */
    public BigDecimalArrayConvertor() {
        super(new BigDecimalConvertor());
    }
}
