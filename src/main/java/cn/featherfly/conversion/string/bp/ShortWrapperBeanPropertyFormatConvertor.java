
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.ShortWrapperFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class ShortWrapperBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Short> {

    /**
     * Instantiates a new short wrapper bean property format convertor.
     */
    public ShortWrapperBeanPropertyFormatConvertor() {
        super(new ShortWrapperFormatConvertor());
    }
}
