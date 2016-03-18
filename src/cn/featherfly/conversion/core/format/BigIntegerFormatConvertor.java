
package cn.featherfly.conversion.core.format;

import java.math.BigInteger;

import cn.featherfly.conversion.core.basic.BigIntegerConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class BigIntegerFormatConvertor extends NumberFormatConvertor<BigInteger> {

    /**
     */
    public BigIntegerFormatConvertor() {
        super(new BigIntegerConvertor());
    }
}
