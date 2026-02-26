
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.LongFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class LongBeanPropertyFormatConvertor extends BeanPropertyBasicTypeFormatConvertor<Long> {

    /**
     * Instantiates a new long bean property format convertor.
     */
    public LongBeanPropertyFormatConvertor() {
        super(new LongFormatConvertor());
    }
}
