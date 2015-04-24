
package cn.featherfly.conversion.bp;

import cn.featherfly.conversion.format.DoubleWrapperFormatConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class DoubleWrapperBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Double> {

    /**
     */
    public DoubleWrapperBeanPropertyFormatConvertor() {
        super(new DoubleWrapperFormatConvertor());
    }
}
