package cn.featherfly.conversion.core.bp;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.conversion.core.annotation.Format;
import cn.featherfly.conversion.core.basic.ArrayConvertor;
import cn.featherfly.conversion.core.format.FormatConvertor;
import cn.featherfly.conversion.core.format.FormatType;

/**
 * <p>
 * 数组转换器
 * </p>
 * 
 * @param <A>
 *            数组自身类型
 * @param <E>
 *            数组项类型
 * @author 钟冀
 */
public abstract class BeanPropertyArrayFormatConvertor<A, E> extends
        ArrayConvertor<A, BeanProperty<A>, E, FormatType<E>> {

    /**
     * @param convertor
     *            conversion
     */
    public BeanPropertyArrayFormatConvertor(FormatConvertor<E> convertor) {
        super(convertor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FormatType<E> getArrayItemGenericType(BeanProperty<A> beanProperty) {
        Format format = beanProperty.getAnnotation(Format.class);
        FormatType<E> ft = new FormatType<>(getConvertor().getType());
        ft.setFormat(format.format());
        ft.setFormats(ArrayUtils.toList(format.formats()));
        return ft;
    }
}
