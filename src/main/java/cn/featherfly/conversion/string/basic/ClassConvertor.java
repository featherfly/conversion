
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.conversion.ConversionException;

/**
 * <p>
 * class类转换器
 * </p>
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class ClassConvertor extends AbstractBasicConvertor<Class, Type<Class>> {

    /**
     */
    public ClassConvertor() {
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
        if (Strings.isNotBlank(value)) {
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
