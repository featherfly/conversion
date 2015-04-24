package cn.featherfly.conversion.core.bp;

import cn.featherfly.conversion.core.format.IntegerFormatConvertor;


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
