
package cn.featherfly.conversion.bp;

import java.math.BigInteger;

import cn.featherfly.conversion.format.BigIntegerFormatConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class BigIntegerBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<BigInteger> {

    /**
     */
    public BigIntegerBeanPropertyFormatConvertor() {
        super(new BigIntegerFormatConvertor());
    }
}
