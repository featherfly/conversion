package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.IntegerFormatConvertor;


/**
 * <p>
 * Integer[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class IntBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Integer[], Integer> {

    /**
     */
    public IntBeanPropertyArrayFormatConvertor() {
        super(new IntegerFormatConvertor());
    }
}
