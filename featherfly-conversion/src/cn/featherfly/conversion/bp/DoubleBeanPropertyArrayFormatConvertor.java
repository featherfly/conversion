package cn.featherfly.conversion.bp;

import cn.featherfly.conversion.format.DoubleWrapperFormatConvertor;


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
