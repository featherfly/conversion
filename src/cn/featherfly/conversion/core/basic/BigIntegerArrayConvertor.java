
package cn.featherfly.conversion.core.basic;
import java.math.BigInteger;


/**
 * <p>
 * BigInteger[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class BigIntegerArrayConvertor extends GenericTypeArrayConvertor<BigInteger[], BigInteger> {

    /**
     */
    public BigIntegerArrayConvertor() {
        super(new BigIntegerConvertor());
    }

}
