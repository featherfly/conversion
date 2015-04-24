
package cn.featherfly.conversion.format;

import cn.featherfly.conversion.basic.FloatConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class FloatFormatConvertor extends NumberBasicTypeFormatConvertor<Float> {

    /**
     */
    public FloatFormatConvertor() {
        super(new FloatConvertor());
    }        
}
