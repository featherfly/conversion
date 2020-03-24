package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.DoubleWrapperFormatConvertor;


/**
 * <p>
 * Double[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class DoubleBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Double[], Double> {

    /**
     */
    public DoubleBeanPropertyArrayFormatConvertor() {
        super(new DoubleWrapperFormatConvertor());
    }
}
