
package cn.featherfly.conversion.format;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.basic.NumberConvertor;


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
        if (genericType != null) {
            String format = genericType.getFormat();
            if (StringUtils.isNotBlank(format)) {
                DecimalFormat df = new DecimalFormat(format);
                return df.format(value);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T formatToObject(String value, FormatType<T> genericType) {
        if (genericType != null) {
            List<String> formats = genericType.getFormats();
            if (LangUtils.isNotEmpty(formats)) {
                for (String format : formats) {
                    DecimalFormat df = new DecimalFormat(format);
                    try {
                        return (T) NumberUtils.value(df.parse(value), getType());
                    } catch (ParseException e) {
                        LogUtils.debug(e, logger);
                    }
                }
                throw new ConversionException(value
                        + " 使用以下格式转换失败！ -> " + ArrayUtils.toString(formats));
            }
        }
        return null;
    }
}
