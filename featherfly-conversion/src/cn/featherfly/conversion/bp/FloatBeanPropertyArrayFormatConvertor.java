package cn.featherfly.conversion.bp;

import cn.featherfly.conversion.format.FloatWrapperFormatConvertor;


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
