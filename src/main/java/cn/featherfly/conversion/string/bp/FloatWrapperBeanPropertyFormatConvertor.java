
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.FloatWrapperFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class FloatWrapperBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Float> {

    /**
     * Instantiates a new float wrapper bean property format convertor.
     */
    public FloatWrapperBeanPropertyFormatConvertor() {
        super(new FloatWrapperFormatConvertor());
    }
}
