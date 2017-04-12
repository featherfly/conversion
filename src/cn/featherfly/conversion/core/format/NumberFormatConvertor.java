
package cn.featherfly.conversion.core.format;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;
import cn.featherfly.conversion.core.basic.NumberConvertor;


/**
 * <p>
 * 数字格式化转换器
 * </p>
 * @param <T> 转换对象
 * @author 钟冀
 */
public class NumberFormatConvertor<T extends Number> extends FormatConvertor<T>{

    /**
     * @param convertor convertor
     */
    public NumberFormatConvertor(NumberConvertor<T> convertor) {
        super(convertor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String formatToString(T value, FormatType<T> genericType) {
        if (genericType != null && value != null && StringUtils.isNotBlank(genericType.getFormat())) {
            DecimalFormat df = new DecimalFormat(genericType.getFormat());
            return df.format(value);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T formatToObject(String value, FormatType<T> genericType) {
        if (genericType != null && value != null && LangUtils.isNotEmpty(genericType.getFormats())) {
            List<String> formats = genericType.getFormats();            
            for (String format : formats) {
                DecimalFormat df = new DecimalFormat(format);
                try {
                    return (T) NumberUtils.value(df.parse(value), getType());
                } catch (ParseException e) {
                    LogUtils.debug(e, logger);
                }
            }
            throw new ConversionException("#convert_failed_with_type", new Object[]{
            		value, ArrayUtils.toString(formats), getType().getName()});
            
        }
        return null;
    }
}
