
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.DoubleWrapperFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class DoubleWrapperBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Double> {

    /**
     * Instantiates a new double wrapper bean property format convertor.
     */
    public DoubleWrapperBeanPropertyFormatConvertor() {
        super(new DoubleWrapperFormatConvertor());
    }
}
