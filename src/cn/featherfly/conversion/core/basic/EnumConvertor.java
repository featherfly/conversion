
package cn.featherfly.conversion.core.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.core.ConversionException;

/**
 * <p>
 * Enum类转换器
 * </p>
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class EnumConvertor extends AbstractBasicConvertor<Enum, GenericType<Enum>>{

    /**
     */
    public EnumConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(Enum value, GenericType<Enum> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected Enum doToObject(String value, GenericType<Enum> genericType) {
        if (StringUtils.isNotBlank(value)) {
            try {
                return Enum.valueOf(genericType.getType() , value);
            } catch (IllegalArgumentException e) {
                throw new ConversionException("设置枚举报错！", e);
            }
        }
        return null;
    }

}
