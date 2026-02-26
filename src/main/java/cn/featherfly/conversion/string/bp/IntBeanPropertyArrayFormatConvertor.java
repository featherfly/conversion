package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.IntegerFormatConvertor;

/**
 * Integer[]转换器.
 *
 * @author 钟冀
 */
public class IntBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Integer[], Integer> {

    /**
     * Instantiates a new int bean property array format convertor.
     */
    public IntBeanPropertyArrayFormatConvertor() {
        super(new IntegerFormatConvertor());
    }
}
