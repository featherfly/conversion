
package cn.featherfly.conversion.convertors;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.reflect.Type;

/**
 * Proxy.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public class Proxy<T> implements Type<T> {

    private BeanProperty<?> proxy;

    private Class<T> proxyType;

    /**
     * Instantiates a new proxy.
     *
     * @param proxy     the proxy
     * @param proxyType the proxy type
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
     * 返回beanProperty.
     *
     * @return beanProperty
     */
    public BeanProperty<?> getProxy() {
        return proxy;
    }
}
