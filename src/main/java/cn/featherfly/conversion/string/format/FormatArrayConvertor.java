
package cn.featherfly.conversion.string.format;

import cn.featherfly.conversion.string.basic.ArrayConvertor;


/**
 * <p>
 * 数组转换器
 * </p>
 * @param <A> 数组自身类型
 * @param <E> 数组项类型
 * @author 钟冀
 */
public abstract class FormatArrayConvertor<A, E> extends ArrayConvertor<A, FormatType<A>, E, FormatType<E>>{

    /**
     * @param convertor conversion
     */
    public FormatArrayConvertor(FormatConvertor<E> convertor) {
        super(convertor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FormatType<E> getArrayItemGenericType(FormatType<A> formatType) {
        FormatType<E> ft = new FormatType<>(getConvertor().getSourceType());
        ft.setFormat(formatType.getFormat());
        ft.setFormats(formatType.getFormats());
        return ft;
    }
}
