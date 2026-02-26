
package cn.featherfly.conversion.string.bp;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.string.AbstractToStringConvertor;

/**
 * 格式化转换器.
 *
 * @author 钟冀
 * @param <T> the generic type
 */
public abstract class BeanPropertyConvertor<T> extends AbstractToStringConvertor<T, BeanProperty<?, T>> {

    /**
     * Instantiates a new bean property convertor.
     */
    protected BeanPropertyConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<T> generecType) {
        if (generecType == null) {
            return false;
        }
        return BeanProperty.class == generecType.getClass();
    }
}
