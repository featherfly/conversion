
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.NumberConvertor;

/**
 * 数字的基础类型格式化转换器.
 *
 * @author 钟冀
 * @param <T> 转换对象
 */
public class NumberBasicTypeFormatConvertor<T extends Number> extends NumberFormatConvertor<T> {

    /**
     * Instantiates a new number basic type format convertor.
     *
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
