
package cn.featherfly.conversion.core.basic;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;

/**
 * <p>
 * Timestamp类转换器
 * </p>
 *
 * @author 钟冀
 */
public class SqlTimestampConvertor extends AbstractBasicConvertor<Timestamp, GenericType<Timestamp>> {

    /**
     */
    public SqlTimestampConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Timestamp> getType() {
        return Timestamp.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Timestamp value, GenericType<Timestamp> genericType) {
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
    protected Timestamp doToObject(String value, GenericType<Timestamp> genericType) {
        if (StringUtils.isNotBlank(value)) {
            value = value.trim();
            String pattern = "yyyy-MM-dd";
            if (value.contains(":")) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }
            DateFormat df = new SimpleDateFormat(pattern);
            try {
                java.util.Date date = df.parse(value);
                return new Timestamp(date.getTime());
            } catch (ParseException e) {
                throw new ConversionException(
                    String.format("日期%s格式错误，不是yyyy-MM-dd或yyyy-MM-dd HH:mm:ss", value));
            }
        }
        return null;
    }
}
