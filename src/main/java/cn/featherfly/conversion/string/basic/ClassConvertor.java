
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;

/**
 * class类转换器.
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class ClassConvertor extends AbstractBasicConvertor<Class, Type<Class>> {

    /**
     * Instantiates a new class convertor.
     */
    public ClassConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Class> getSourceType() {
        return Class.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Class value, Type<Class> genericType) {
        if (value != null) {
            return value.getName();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class doToObject(String value, Type<Class> genericType) {
        if (Str.isNotBlank(value)) {
            try {
                return Class.forName(value);
            } catch (ClassNotFoundException e) {
                LogUtils.debug(e, logger);
                throw new ConversionException("#class_not_found", new Object[] { value });
            }
        }
        return null;
    }
}
