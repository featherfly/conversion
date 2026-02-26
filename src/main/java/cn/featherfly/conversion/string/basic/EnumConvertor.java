
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;

/**
 * Enum类转换器.
 *
 * @author 钟冀
 * @param <T> the generic type
 */
public class EnumConvertor<T extends Enum<T>> extends AbstractBasicConvertor<T, Type<T>> {

    /**
     * Instantiates a new enum convertor.
     */
    public EnumConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Class<T> getSourceType() {
        return (Class) Enum.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(T value, Type<T> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, Type<T> genericType) {
        if (Str.isNotBlank(value)) {
            try {
                T t = Lang.toEnum(genericType.getType(), value);
                if (t == null) {
                    throw new ConversionException("#convert_failed",
                        new Object[] { value, genericType.getType().getName() });
                }
                return t;
            } catch (IllegalArgumentException e) {
                throw new ConversionException("#convert_failed",
                    new Object[] { value, genericType.getType().getName() });
            }
        }
        return null;
    }
}
