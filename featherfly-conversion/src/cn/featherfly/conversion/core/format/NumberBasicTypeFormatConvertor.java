
package cn.featherfly.conversion.core.format;

import cn.featherfly.conversion.core.basic.NumberConvertor;


/**
 * <p>
 * 数字的基础类型格式化转换器
 * </p>
 * @param <T> 转换对象
 * @author 钟冀
 */
public class NumberBasicTypeFormatConvertor<T extends Number> extends NumberFormatConvertor<T>{

    /**
     * @param convertor convertor
     */
    public NumberBasicTypeFormatConvertor(NumberConvertor<T> convertor) {
        super(convertor);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Class<T> getType() {
        return getConvertor().getType();
    }
}
