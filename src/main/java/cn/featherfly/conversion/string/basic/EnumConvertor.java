
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.ConversionException;

/**
 * <p>	
 * Enum类转换器
 * </p>
 *
 * @author 钟冀
 */
public class EnumConvertor<T extends Enum<T>> extends AbstractBasicConvertor<T, GenericType<T>>{

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
    protected String doToString(T value, GenericType<T> genericType) {
        if (value != null) {
            return value.toString();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, GenericType<T> genericType) {
        if (StringUtils.isNotBlank(value)) {
            try {
            	T t = LangUtils.toEnum(genericType.getType(), value);
            	if (t == null) {
            		throw new ConversionException("#convert_failed", new Object[]{value, genericType.getType().getName()});	
            	}
            	return t;
            } catch (IllegalArgumentException e) {
                throw new ConversionException("#convert_failed", new Object[]{value, genericType.getType().getName()});
            }
        }
        return null;
    }
}
