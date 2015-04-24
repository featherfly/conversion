
package cn.featherfly.conversion.basic;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.conversion.AbstractConvertor;

/**
 * <p>
 * 基础类型转换器
 * </p>
 * @param <T> 转换器对应的转换类型
 * @param <G> 转换器对应的转换类型描述信息
 * @author 钟冀
 */
public abstract class AbstractBasicConvertor<T, G extends GenericType<T>> extends AbstractConvertor<T, G> {

    /**
     */
    public AbstractBasicConvertor() {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<T> generecType) {
        return generecType == null 
                || GenericClass.class == generecType.getClass()
                || BeanProperty.class == generecType.getClass();
    }
}
