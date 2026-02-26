
package cn.featherfly.conversion.string.format;

import java.math.BigInteger;

import cn.featherfly.conversion.string.basic.BigIntegerConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class BigIntegerFormatConvertor extends NumberFormatConvertor<BigInteger> {

    /**
     * Instantiates a new big integer format convertor.
     */
    public BigIntegerFormatConvertor() {
        super(new BigIntegerConvertor());
    }
}
