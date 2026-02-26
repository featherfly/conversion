
package cn.featherfly.conversion.string.basic;

import java.math.BigInteger;

/**
 * BigInteger[]转换器.
 *
 * @author 钟冀
 */
public class BigIntegerArrayConvertor extends GenericTypeArrayConvertor<BigInteger[], BigInteger> {

    /**
     * Instantiates a new big integer array convertor.
     */
    public BigIntegerArrayConvertor() {
        super(new BigIntegerConvertor());
    }

}
