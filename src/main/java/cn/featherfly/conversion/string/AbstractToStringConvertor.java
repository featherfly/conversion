
package cn.featherfly.conversion.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.TypePolicys;

/**
 * 抽象转换器.
 *
 * @author 钟冀
 * @param <S> 转换对象
 * @param <G> Type
 */
public abstract class AbstractToStringConvertor<S, G extends Type<S>> implements ToStringConvertor<S> {

    private Class<S> type;

    private TypePolicys policy = TypePolicys.CLASS;

    /**
     * Instantiates a new abstract to string convertor.
     */
    protected AbstractToStringConvertor() {
        type = ClassUtils.getSuperClassGenericType(this.getClass());
    }

    /** 日志. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 是否提供对传入类型的支持.
     *
     * @param generecType generecType
     * @return 是否支持
     */
    protected abstract boolean supportFor(Type<S> generecType);

    /**
     * 对象转换为字符串.
     *
     * @param value 对象
     * @param genericType 指定对象的上下文属性
     * @return 字符串
     */
    protected abstract String doToString(S value, G genericType);

    /**
     * 字符串转换为对象.
     *
     * @param value 字符串
     * @param genericType 指定对象的上下文属性
     * @return 对象
     */
    protected abstract S doToObject(String value, G genericType);

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <GT extends Type<S>> String sourceToTarget(S value, GT genericType) {
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
    public <GT extends Type<S>> S targetToSource(String value, GT genericType) {
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
     * 返回policy.
     *
     * @return policy
     */
    @Override
    public TypePolicys getPolicy() {
        return policy;
    }

    /**
     * 设置policy.
     *
     * @param policy policy
     */
    public void setPolicy(TypePolicys policy) {
        this.policy = policy;
    }
}
