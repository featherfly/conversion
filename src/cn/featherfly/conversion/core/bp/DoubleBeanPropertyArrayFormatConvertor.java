package cn.featherfly.conversion.core.bp;

import cn.featherfly.conversion.core.format.DoubleWrapperFormatConvertor;


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
