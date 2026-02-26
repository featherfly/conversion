
package cn.featherfly.conversion.string.bp;

import java.math.BigInteger;

import cn.featherfly.conversion.string.format.BigIntegerFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class BigIntegerBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<BigInteger> {

    /**
     * Instantiates a new big integer bean property format convertor.
     */
    public BigIntegerBeanPropertyFormatConvertor() {
        super(new BigIntegerFormatConvertor());
    }
}
