
package cn.featherfly.conversion.string.basic;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.conversion.ConversionException;

/**
 * <p>
 * LocalTime类转换器
 * </p>
 *
 * @author 钟冀
 */
public class LocalTimeConvertor extends AbstractBasicConvertor<LocalTime, Type<LocalTime>> {

    private static final String DATE_TIME_FORMAT = "HH:mm:ss";

    private static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    /**
     */
    public LocalTimeConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(LocalTime value, Type<LocalTime> genericType) {
        if (value != null) {
            return value.format(DATE_TIME_PATTERN);
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LocalTime doToObject(String value, Type<LocalTime> genericType) {
        if (Strings.isNotBlank(value)) {
            value = value.trim();
            try {
                return LocalTime.parse(value, DATE_TIME_PATTERN);
            } catch (Exception e) {
                throw new ConversionException("#convert_failed_with_type",
                        new Object[] { value, DATE_TIME_FORMAT, getSourceType().getName() });
            }
        }
        return null;
    }
}
