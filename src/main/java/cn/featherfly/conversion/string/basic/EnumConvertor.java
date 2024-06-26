
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.conversion.ConversionException;

/**
 * <p>
 * Enum类转换器
 * </p>
 *
 * @author 钟冀
 */
public class EnumConvertor<T extends Enum<T>> extends AbstractBasicConvertor<T, Type<T>> {

    /**
     */
    public EnumConvertor() {
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
        if (Strings.isNotBlank(value)) {
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
