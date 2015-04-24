
package cn.featherfly.conversion.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.basic.DateConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class DateFormatConvertor extends FormatConvertor<Date> {

    /**
     */
    public DateFormatConvertor() {
        super(new DateConvertor());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String formatToString(Date value, FormatType<Date> genericType) {
        if (genericType != null && StringUtils.isNotBlank(genericType.getFormat())) {
            SimpleDateFormat sdf = new SimpleDateFormat(genericType.getFormat());
            return sdf.format(value);
        }
        return null;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    protected Date formatToObject(String value, FormatType<Date> genericType) {
        if (genericType != null && LangUtils.isNotEmpty(genericType.getFormats())) {
            List<String> formats = genericType.getFormats();
            for (String format : formats) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                try {
                    return sdf.parse(value);
                } catch (ParseException e) {
                    LogUtils.debug(e, logger);
                }
            }
            throw new ConversionException(value
                    + " 使用以下格式转换失败！ -> " + ArrayUtils.toString(formats));
        }
        return null;
    }
}
