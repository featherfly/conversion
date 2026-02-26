
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.IntFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class IntBeanPropertyFormatConvertor extends BeanPropertyBasicTypeFormatConvertor<Integer> {

    /**
     * Instantiates a new int bean property format convertor.
     */
    public IntBeanPropertyFormatConvertor() {
        super(new IntFormatConvertor());
    }
}
