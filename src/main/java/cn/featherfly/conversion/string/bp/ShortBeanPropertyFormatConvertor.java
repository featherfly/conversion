
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.ShortFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class ShortBeanPropertyFormatConvertor extends BeanPropertyBasicTypeFormatConvertor<Short> {

    /**
     * Instantiates a new short bean property format convertor.
     */
    public ShortBeanPropertyFormatConvertor() {
        super(new ShortFormatConvertor());
    }
}
