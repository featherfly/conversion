
package cn.featherfly.conversion.core.bp;

import cn.featherfly.conversion.core.format.FloatWrapperFormatConvertor;

/**
 * <p>
 * 带格式支持的数字转换器，在属性字段上使用@NumberFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class FloatWrapperBeanPropertyFormatConvertor extends BeanPropertyFormatConvertor<Float> {

    /**
     */
    public FloatWrapperBeanPropertyFormatConvertor() {
        super(new FloatWrapperFormatConvertor());
    }
}
