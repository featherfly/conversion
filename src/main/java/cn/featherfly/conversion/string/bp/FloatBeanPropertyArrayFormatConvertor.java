package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.FloatWrapperFormatConvertor;

/**
 * Float[]转换器.
 *
 * @author 钟冀
 */
public class FloatBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Float[], Float> {

    /**
     * Instantiates a new float bean property array format convertor.
     */
    public FloatBeanPropertyArrayFormatConvertor() {
        super(new FloatWrapperFormatConvertor());
    }
}
