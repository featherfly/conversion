
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.IntegerConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class IntegerFormatConvertor extends NumberFormatConvertor<Integer> {

    /**
     * Instantiates a new integer format convertor.
     */
    public IntegerFormatConvertor() {
        super(new IntegerConvertor());
    }

}
