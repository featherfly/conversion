package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.DoubleWrapperFormatConvertor;

/**
 * Double[]转换器.
 *
 * @author 钟冀
 */
public class DoubleBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Double[], Double> {

    /**
     * Instantiates a new double bean property array format convertor.
     */
    public DoubleBeanPropertyArrayFormatConvertor() {
        super(new DoubleWrapperFormatConvertor());
    }
}
