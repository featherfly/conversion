
package cn.featherfly.conversion.core.format;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;
import cn.featherfly.conversion.core.basic.SqlTimeConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimeFormatConvertor extends FormatConvertor<Time> {

    /**
     */
    public SqlTimeFormatConvertor() {
        super(new SqlTimeConvertor());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String formatToString(Time value, FormatType<Time> genericType) {
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
    protected Time formatToObject(String value, FormatType<Time> genericType) {
        if (genericType != null && LangUtils.isNotEmpty(genericType.getFormats())) {
            List<String> formats = genericType.getFormats();
            for (String format : formats) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                try {
                    Date d = sdf.parse(value);
                    return new Time(d.getTime());
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
