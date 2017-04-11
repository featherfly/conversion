
package cn.featherfly.conversion.core.basic;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;

/**
 * <p>
 * SqlDate类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimeConvertor extends AbstractBasicConvertor<Time, GenericType<Time>> {

    /**
     */
    public SqlTimeConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Time> getType() {
        return Time.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Time value, GenericType<Time> genericType) {
        if (value != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(value);
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Time doToObject(String value, GenericType<Time> genericType) {
        if (StringUtils.isNotBlank(value)) {
            value = value.trim();
            String pattern = "yyyy-MM-dd";
            if (value.contains(":")) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }
            DateFormat df = new SimpleDateFormat(pattern);
            try {
                java.util.Date date = df.parse(value);
                return new Time(date.getTime());
            } catch (ParseException e) {
                throw new ConversionException(
                    String.format("日期%s格式错误，不是yyyy-MM-dd或yyyy-MM-dd HH:mm:ss", value));
            }
        }
        return null;
    }
}
