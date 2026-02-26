
package cn.featherfly.conversion.string.bp;

import java.math.BigDecimal;

import cn.featherfly.conversion.string.format.BigDecimalFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class BigDecimalBeanPropertyArrayFormatConvertor
    extends BeanPropertyArrayFormatConvertor<BigDecimal[], BigDecimal> {

    /**
     * Instantiates a new big decimal bean property array format convertor.
     */
    public BigDecimalBeanPropertyArrayFormatConvertor() {
        super(new BigDecimalFormatConvertor());
    }
}
