package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.LongWrapperFormatConvertor;


/**
 * <p>
 * Long[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LongBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Long[], Long> {

    /**
     */
    public LongBeanPropertyArrayFormatConvertor() {
        super(new LongWrapperFormatConvertor());
    }    
}
