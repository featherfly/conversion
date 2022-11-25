
package cn.featherfly.conversion.string.basic;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.string.AbstractToStringConvertor;

/**
 * <p>
 * 基础类型转换器
 * </p>
 *
 * @param <T> 转换器对应的转换类型
 * @param <G> 转换器对应的转换类型描述信息
 * @author 钟冀
 */
public abstract class AbstractBasicConvertor<T, G extends Type<T>> extends AbstractToStringConvertor<T, G> {

    /**
     */
    public AbstractBasicConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(Type<T> generecType) {
        return generecType == null || ClassType.class == generecType.getClass()
                || BeanProperty.class == generecType.getClass();
    }
}
