
package cn.featherfly.conversion.format;

import cn.featherfly.conversion.basic.FloatWrapperConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class FloatWrapperFormatConvertor extends NumberFormatConvertor<Float> {

    /**
     */
    public FloatWrapperFormatConvertor() {
        super(new FloatWrapperConvertor());
    }
}
