package cn.featherfly.conversion.bp;

import cn.featherfly.conversion.format.ShortFormatConvertor;


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
