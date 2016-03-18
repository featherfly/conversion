
package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.LogUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;

/**
 * <p>
 * class类转换器
 * </p>
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class ClassConvertor extends AbstractBasicConvertor<Class, GenericType<Class>>{

    /**
     */
    public ClassConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Class> getType() {
        return Class.class;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Class value, GenericType<Class> genericType) {
        if (value != null) {
            return value.getName();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class doToObject(String value, GenericType<Class> genericType) {
        if (StringUtils.isNotBlank(value)) {
            try {
                return Class.forName(value);
            } catch (ClassNotFoundException e) {
                LogUtils.debug(e, logger);
                throw new ConversionException(String.format("设置常量时，类%s没有找到", value));
            }
        }
        return null;
    }
}
