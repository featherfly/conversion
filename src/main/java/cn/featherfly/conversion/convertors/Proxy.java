
package cn.featherfly.conversion.convertors;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.reflect.Type;

/**
 * <p>
 * Proxy
 * </p>
 *
 * @author zhongj
 */
public class Proxy<T> implements Type<T> {

    private BeanProperty<?> proxy;

    private Class<T> proxyType;

    /**
     * @param proxy
     * @param proxyType
     */
    public Proxy(BeanProperty<?> proxy, Class<T> proxyType) {
        super();
        this.proxy = proxy;
        this.proxyType = proxyType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<T> getType() {
        return proxyType;
    }

    /**
     * 返回beanProperty
     *
     * @return beanProperty
     */
    public BeanProperty<?> getProxy() {
        return proxy;
    }
}
