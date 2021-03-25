
package cn.featherfly.conversion.string.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.conversion.ConversionException;

/**
 * <p>
 * Date类转换器
 * </p>
 *
 * @author 钟冀
 */
public abstract class AbstractDateConvertor<T extends Date> extends AbstractBasicConvertor<T, GenericType<T>> {

    /**
     */
    public AbstractDateConvertor() {
    }

    /**
     * <p>
     * 返回转换日期到字符串的格式
     * </p>
     *
     * @return 转换日期到字符串的格式
     */
    protected abstract String getFormat();

    /**
     * <p>
     * 返回转换字符串到日期格式支持的格式
     * </p>
     *
     * @return 转换字符串到日期格式支持的格式
     */
    protected abstract String[] getFormats();

    /**
     * <p>
     * 转换传入类型为目标类型
     * </p>
     *
     * @param date date
     * @return 转换目标类型
     */
    protected abstract T convert(Date date);

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(T value, GenericType<T> genericType) {
        if (value != null) {
            if (Strings.isNotBlank(getFormat())) {
                logger.debug("format {} to string with {}", getSourceType().getName(), getFormat());
                DateFormat df = new SimpleDateFormat(getFormat());
                return df.format(value);
            } else {
                logger.warn("there is no format, use value.toString()");
                value.toString();
            }
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, GenericType<T> genericType) {
        String[] formats = getFormats();
        if (Lang.isEmpty(formats)) {
            logger.warn("there is no formats, can not parse {} to {}", value, getSourceType().getName());
        } else if (Strings.isNotBlank(value)) {
            for (String format : formats) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                try {
                    Date d = sdf.parse(value);
                    logger.debug("parse {} with format[{}] success", value, format);
                    return convert(d);
                } catch (ParseException e) {
                    logger.debug("parse {} with format[{}] error", value, format);
                }
            }
            throw new ConversionException("#convert_failed_with_type",
                    new Object[] { value, ArrayUtils.toString(formats), getSourceType().getName() });
        }
        return null;
    }
}
