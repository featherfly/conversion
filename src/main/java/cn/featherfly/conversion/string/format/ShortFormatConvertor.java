
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.ShortConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class ShortFormatConvertor extends NumberBasicTypeFormatConvertor<Short> {

    /**
     */
    public ShortFormatConvertor() {
        super(new ShortConvertor());
    }
}
