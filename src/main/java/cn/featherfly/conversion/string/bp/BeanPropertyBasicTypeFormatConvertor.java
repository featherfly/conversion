
package cn.featherfly.conversion.string.bp;

import cn.featherfly.conversion.string.format.FormatConvertor;

/**
 * 格式化转换器.
 *
 * @author 钟冀
 * @param <T> 转换对象泛型
 */
public class BeanPropertyBasicTypeFormatConvertor<T> extends BeanPropertyFormatConvertor<T> {

    /**
     * Instantiates a new bean property basic type format convertor.
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
