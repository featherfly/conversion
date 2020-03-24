
package cn.featherfly.conversion.string.bp;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.string.AbstractToStringConvertor;


/**
 * <p>
 * 格式化转换器
 * </p>
 * @param <T> 转换对象泛型
 * @author 钟冀
 */
public abstract class BeanPropertyConvertor<T> extends AbstractToStringConvertor<T, BeanProperty<T>>{
    
    /**
     */
    public BeanPropertyConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<T> generecType) {
        if (generecType == null) {
            return false;        
        }
        return BeanProperty.class == generecType.getClass();
    }
}
