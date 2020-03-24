
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.LongConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class LongFormatConvertor extends NumberBasicTypeFormatConvertor<Long> {

    /**
     */    
    public LongFormatConvertor() {
        super(new LongConvertor());
    }
}
