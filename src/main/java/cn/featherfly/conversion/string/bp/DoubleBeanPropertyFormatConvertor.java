
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.DoubleFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class DoubleBeanPropertyFormatConvertor extends BeanPropertyBasicTypeFormatConvertor<Double> {

    /**
     * Instantiates a new double bean property format convertor.
     */
    public DoubleBeanPropertyFormatConvertor() {
        super(new DoubleFormatConvertor());
    }

}
