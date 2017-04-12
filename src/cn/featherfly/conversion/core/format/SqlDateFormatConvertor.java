
package cn.featherfly.conversion.core.format;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;
import cn.featherfly.conversion.core.basic.SqlDateConvertor;

/**
 * <p>
 * 带格式支持的日期转换器，在属性字段上使用@DateFormat来指定格式.
 * </p>
 *
 * @author 钟冀
 */
public class SqlDateFormatConvertor extends FormatConvertor<Date> {

    /**
     */
    public SqlDateFormatConvertor() {
        super(new SqlDateConvertor());
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
                    java.util.Date d = sdf.parse(value);
                    return new Date(d.getTime());
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
