
package cn.featherfly.conversion.string.basic;

import java.math.BigDecimal;

/**
 * BigDecimal[]转换器.
 *
 * @author 钟冀
 */
public class BigDecimalArrayConvertor extends GenericTypeArrayConvertor<BigDecimal[], BigDecimal> {

    /**
     * Instantiates a new big decimal array convertor.
     */
    public BigDecimalArrayConvertor() {
        super(new BigDecimalConvertor());
    }
}
