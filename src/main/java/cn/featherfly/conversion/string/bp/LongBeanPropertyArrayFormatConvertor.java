package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.LongWrapperFormatConvertor;

/**
 * Long[]转换器.
 *
 * @author 钟冀
 */
public class LongBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Long[], Long> {

    /**
     * Instantiates a new long bean property array format convertor.
     */
    public LongBeanPropertyArrayFormatConvertor() {
        super(new LongWrapperFormatConvertor());
    }
}
