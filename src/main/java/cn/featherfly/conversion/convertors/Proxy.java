
package cn.featherfly.conversion.convertors;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.reflect.Type;

/**
 * Proxy.
 *
 * @author     zhongj
 * @param  <T> the generic type
 */
public class Proxy<T> implements Type<T> {

    private BeanProperty<?, T> proxy;

    private Class<T> proxyType;

    /**
     * Instantiates a new proxy.
     *
     * @param proxy     the proxy
     * @param proxyType the proxy type
     */
    public Proxy(BeanProperty<?, T> proxy, Class<T> proxyType) {
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
     * 返回beanProperty.
     *
     * @return beanProperty
     */
    public BeanProperty<?, T> getProxy() {
        return proxy;
    }
}
