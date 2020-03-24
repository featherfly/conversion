
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.FormatConvertor;


/**
 * <p>
 * 格式化转换器
 * </p>
 * @param <T> 转换对象泛型
 * @author 钟冀
 */
public class BeanPropertyBasicTypeFormatConvertor<T> extends BeanPropertyFormatConvertor<T>{

    /**
     * 
     * @param convertor convertor
     */
    public BeanPropertyBasicTypeFormatConvertor(FormatConvertor<T> convertor) {        
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
