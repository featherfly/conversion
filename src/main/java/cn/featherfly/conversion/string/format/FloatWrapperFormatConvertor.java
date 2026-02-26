
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.FloatWrapperConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class FloatWrapperFormatConvertor extends NumberFormatConvertor<Float> {

    /**
     * Instantiates a new float wrapper format convertor.
     */
    public FloatWrapperFormatConvertor() {
        super(new FloatWrapperConvertor());
    }
}
