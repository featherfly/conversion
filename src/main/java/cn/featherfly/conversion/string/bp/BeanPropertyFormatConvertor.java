
package cn.featherfly.conversion.string.bp;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.conversion.annotation.Format;
import cn.featherfly.conversion.string.format.FormatConvertor;
import cn.featherfly.conversion.string.format.FormatType;

/**
 * <p>
 * 格式化转换器
 * </p>
 *
 * @param  <T> 转换对象类型
 * @author     钟冀
 */
public class BeanPropertyFormatConvertor<T> extends BeanPropertyConvertor<T> {

    private FormatConvertor<T> convertor;

    /**
     * @param convertor convertor
     */
    public BeanPropertyFormatConvertor(FormatConvertor<T> convertor) {
        this.convertor = convertor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(T value, BeanProperty<?, T> beanProperty) {
        FormatType<T> formatType = new FormatType<>(getSourceType());
        Format format = beanProperty.getAnnotation(Format.class);
        if (beanProperty != null && format != null) {
            formatType.setFormat(format.format());
            formatType.setFormats(ArrayUtils.toList(format.formats()));
        }
        return convertor.sourceToTarget(value, formatType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, BeanProperty<?, T> beanProperty) {
        FormatType<T> formatType = new FormatType<>(getSourceType());
        Format format = beanProperty.getAnnotation(Format.class);
        if (beanProperty != null && format != null) {
            formatType.setFormat(format.format());
            formatType.setFormats(ArrayUtils.toList(format.formats()));
        }
        return convertor.targetToSource(value, formatType);
    }

    /**
     * 返回convertor
     *
     * @return convertor
     */
    public FormatConvertor<T> getConvertor() {
        return convertor;
    }
}
