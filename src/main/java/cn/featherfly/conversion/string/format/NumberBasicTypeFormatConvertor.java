
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.NumberConvertor;


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
    public Class<T> getSourceType() {
        return getConvertor().getSourceType();
    }
}
