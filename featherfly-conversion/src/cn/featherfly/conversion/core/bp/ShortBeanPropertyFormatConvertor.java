
package cn.featherfly.conversion.core.bp;

import cn.featherfly.conversion.core.format.ShortFormatConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class ShortBeanPropertyFormatConvertor extends BeanPropertyBasicTypeFormatConvertor<Short> {

    /**
     */
    public ShortBeanPropertyFormatConvertor() {
        super(new ShortFormatConvertor());
    }
}
