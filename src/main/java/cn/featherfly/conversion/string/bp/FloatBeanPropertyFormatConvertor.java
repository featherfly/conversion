
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.FloatFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class FloatBeanPropertyFormatConvertor extends BeanPropertyBasicTypeFormatConvertor<Float> {

    /**
     * Instantiates a new float bean property format convertor.
     */
    public FloatBeanPropertyFormatConvertor() {
        super(new FloatFormatConvertor());
    }
}
