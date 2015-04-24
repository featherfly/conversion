
package cn.featherfly.conversion.format;

import cn.featherfly.conversion.basic.IntegerConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class IntegerFormatConvertor extends NumberFormatConvertor<Integer> {

    /**
     */
    public IntegerFormatConvertor() {
        super(new IntegerConvertor());
    }


}
