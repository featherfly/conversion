
package cn.featherfly.conversion.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.TypePolicys;

/**
 * <p>
 * 抽象转换器
 * </p>
 *
 * @param <S> 转换对象
 * @param <G> GenericType
 * @author 钟冀
 */
public abstract class AbstractToStringConvertor<S, G extends GenericType<S>> implements ToStringConvertor<S> {

    private Class<S> type;

    private TypePolicys policy = TypePolicys.CLASS;

    /**
     */
    public AbstractToStringConvertor() {
        type = ClassUtils.getSuperClassGenericType(this.getClass());
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
     * 对象转换为字符串
     * </p>
     *
     * @param value       对象
     * @param genericType 指定对象的上下文属性
     * @return 字符串
     */
    protected abstract String doToString(S value, G genericType);

    /**
     * <p>
     * 字符串转换为对象
     * </p>
     *
     * @param value       字符串
     * @param genericType 指定对象的上下文属性
     * @return 对象
     */
    protected abstract S doToObject(String value, G genericType);

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <GT extends GenericType<S>> String sourceToTarget(S value, GT genericType) {
        if (supportFor(genericType)) {
            return doToString(value, (G) genericType);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <GT extends GenericType<S>> S targetToSource(String value, GT genericType) {
        if (supportFor(genericType)) {
            return doToObject(value, (G) genericType);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<S> getSourceType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<String> getTargetType() {
        return String.class;
    }

    /**
     * 返回policy
     *
     * @return policy
     */
    @Override
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
