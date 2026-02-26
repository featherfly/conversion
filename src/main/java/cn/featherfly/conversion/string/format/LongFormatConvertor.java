
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.LongConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class LongFormatConvertor extends NumberBasicTypeFormatConvertor<Long> {

    /**
     * Instantiates a new long format convertor.
     */
    public LongFormatConvertor() {
        super(new LongConvertor());
    }
}
