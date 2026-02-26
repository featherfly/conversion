package cn.featherfly.conversion.string.bp;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.conversion.annotation.Format;
import cn.featherfly.conversion.string.basic.ArrayConvertor;
import cn.featherfly.conversion.string.format.FormatConvertor;
import cn.featherfly.conversion.string.format.FormatType;

/**
 * 数组转换器.
 *
 * @author 钟冀
 * @param <A> the generic type
 * @param <E> the element type
 */
public abstract class BeanPropertyArrayFormatConvertor<A, E>
    extends ArrayConvertor<A, BeanProperty<?, A>, E, FormatType<E>> {

    /**
     * Instantiates a new bean property array format convertor.
     *
     * @param convertor conversion
     */
    protected BeanPropertyArrayFormatConvertor(FormatConvertor<E> convertor) {
        super(convertor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FormatType<E> getArrayItemType(BeanProperty<?, A> beanProperty) {
        Format format = beanProperty.getAnnotation(Format.class);
        FormatType<E> ft = new FormatType<>(getConvertor().getSourceType());
        ft.setFormat(format.format());
        ft.setFormats(ArrayUtils.toList(format.formats()));
        return ft;
    }
}
