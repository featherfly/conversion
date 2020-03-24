
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.DoubleFormatConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class DoubleBeanPropertyFormatConvertor extends BeanPropertyBasicTypeFormatConvertor<Double> {

    /**
     */
    public DoubleBeanPropertyFormatConvertor() {
        super(new DoubleFormatConvertor());
    }
    
}
