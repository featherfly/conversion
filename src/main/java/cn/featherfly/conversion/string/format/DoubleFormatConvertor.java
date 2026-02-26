
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.DoubleConvertor;

/**
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 *
 * @author 钟冀
 */
public class DoubleFormatConvertor extends NumberBasicTypeFormatConvertor<Double> {

    /**
     * Instantiates a new double format convertor.
     */
    public DoubleFormatConvertor() {
        super(new DoubleConvertor());
    }
}
