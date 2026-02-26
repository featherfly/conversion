
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.LongWrapperFormatConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class LongWrapperBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Long> {

    /**
     * Instantiates a new long wrapper bean property format convertor.
     */
    public LongWrapperBeanPropertyFormatConvertor() {
        super(new LongWrapperFormatConvertor());
    }
}
