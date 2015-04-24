package cn.featherfly.conversion.bp;

import cn.featherfly.conversion.format.LongWrapperFormatConvertor;


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
