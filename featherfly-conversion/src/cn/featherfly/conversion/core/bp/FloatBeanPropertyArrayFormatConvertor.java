package cn.featherfly.conversion.core.bp;

import cn.featherfly.conversion.core.format.FloatWrapperFormatConvertor;


/**
 * <p>
 * Float[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class FloatBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Float[], Float> {

    /**
     */
    public FloatBeanPropertyArrayFormatConvertor() {
        super(new FloatWrapperFormatConvertor());
    }
}
