
package cn.featherfly.conversion.string.bp;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.GenericType;

/**
 * <p>
 * BeanPropertyContainerType
 * </p>
 *
 * @param <T> 对象类型
 * @author 钟冀
 */
public class BeanPropertyContainerType<C> implements GenericType<Object> {
    /**
     * @param beanProperty beanProperty
     */
    public BeanPropertyContainerType(BeanProperty<C> beanProperty) {
        this.beanProperty = beanProperty;
    }

    private BeanProperty<C> beanProperty;

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Class<Object> getType() {
        return (Class<Object>) beanProperty.getGenericType();
    }

    /**
     * 返回beanProperty
     *
     * @return beanProperty
     */
    public BeanProperty<C> getBeanProperty() {
        return beanProperty;
    }

}
