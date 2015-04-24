
package cn.featherfly.conversion.basic;
import java.math.BigInteger;


/**
 * <p>
 * BigInteger[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class BigIntegerArrayConvertor extends GenericClassArrayConvertor<BigInteger[], BigInteger> {

    /**
     */
    public BigIntegerArrayConvertor() {
        super(new BigIntegerConvertor());
    }

}
