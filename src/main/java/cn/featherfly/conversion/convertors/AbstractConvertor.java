
package cn.featherfly.conversion.convertors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.Convertor;
import cn.featherfly.conversion.TypePolicys;

/**
 * <p>
 * AbstractConvertor
 * </p>
 *
 * @author zhongj
 */
public abstract class AbstractConvertor<S, T, G extends GenericType<S>> implements Convertor<S, T> {

    private Class<S> sourceType;

    private Class<T> targetType;

    private TypePolicys policy = TypePolicys.CLASS;

    /**
     */
    public AbstractConvertor() {
    }

    /**
     * @param sourceType
     * @param targetType
     * @param policy
     */
    public AbstractConvertor(Class<S> sourceType, Class<T> targetType, TypePolicys policy) {
        super();
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.policy = policy;
    }

    /**
     * 日志
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * <p>
     * 是否提供对传入类型的支持
     * </p>
     *
     * @param generecType generecType
     * @return 是否支持
     */
    protected abstract boolean supportFor(GenericType<S> generecType);

    /**
     * <p>
     * 源转目标
     * </p>
     *
     * @param source      源对象
     * @param genericType 指定对象的上下文属性
     * @return 目标对象
     */
    protected abstract T doSourceToTarget(S source, G genericType);

    /**
     * <p>
     * 目标转源
     * </p>
     *
     * @param target      目标对象
     * @param genericType 指定对象的上下文属性
     * @return 源对象
     */
    protected abstract S doTargetToSource(T target, G genericType);

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <GT extends GenericType<S>> T sourceToTarget(S value, GT genericType) {
        if (supportFor(genericType)) {
            return doSourceToTarget(value, (G) genericType);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <GT extends GenericType<S>> S targetToSource(T value, GT genericType) {
        if (supportFor(genericType)) {
            return doTargetToSource(value, (G) genericType);
        }
        return null;
    }

    /**
     * 返回sourceType
     *
     * @return sourceType
     */
    @Override
    public Class<S> getSourceType() {
        return sourceType;
    }

    /**
     * 设置sourceType
     *
     * @param sourceType sourceType
     */
    public void setSourceType(Class<S> sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 返回targetType
     *
     * @return targetType
     */
    @Override
    public Class<T> getTargetType() {
        return targetType;
    }

    /**
     * 设置targetType
     *
     * @param targetType targetType
     */
    public void setTargetType(Class<T> targetType) {
        this.targetType = targetType;
    }

    /**
     * 返回policy
     *
     * @return policy
     */
    public TypePolicys getPolicy() {
        return policy;
    }

    /**
     * 设置policy
     *
     * @param policy policy
     */
    public void setPolicy(TypePolicys policy) {
        this.policy = policy;
    }

}
