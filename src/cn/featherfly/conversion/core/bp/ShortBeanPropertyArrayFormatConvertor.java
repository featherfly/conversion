package cn.featherfly.conversion.core.bp;

import cn.featherfly.conversion.core.format.ShortFormatConvertor;


/**
 * <p>
 * Short[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class ShortBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Short[], Short> {

    /**
     */
    public ShortBeanPropertyArrayFormatConvertor() {
        super(new ShortFormatConvertor());
    }    
}
