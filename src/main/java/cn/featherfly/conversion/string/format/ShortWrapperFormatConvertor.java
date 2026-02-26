
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.ShortWrapperConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class ShortWrapperFormatConvertor extends NumberFormatConvertor<Short> {

    /**
     * Instantiates a new short wrapper format convertor.
     */
    public ShortWrapperFormatConvertor() {
        super(new ShortWrapperConvertor());
    }
}
