package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.ShortFormatConvertor;

/**
 * Short[]转换器.
 *
 * @author 钟冀
 */
public class ShortBeanPropertyArrayFormatConvertor extends BeanPropertyArrayFormatConvertor<Short[], Short> {

    /**
     * Instantiates a new short bean property array format convertor.
     */
    public ShortBeanPropertyArrayFormatConvertor() {
        super(new ShortFormatConvertor());
    }
}
