
package cn.featherfly.conversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.GenericType;



/**
 * <p>
 * 抽象转换器
 * </p>
 * @param <T> 转换对象
 * @param <G> 
 * @author 钟冀
 */
public abstract class AbstractConvertor<T, G extends GenericType<T>> implements Convertor<T>{
    
    private Class<T> type;
    
    /**
     */
    public AbstractConvertor() {
        type = ClassUtils.getSuperClassGenricType(this.getClass());
    }

    /**
     * 日志
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * <p>
     * 是否提供对传入类型的支持
     * </p>
     * @param generecType generecType
     * @return 是否支持
     */
    protected abstract boolean supportFor(GenericType<T> generecType);
    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * @param value 对象
     * @param genericType 指定对象的上下文属性
     * @return 字符串
     */
    protected abstract String doToString(T value, G genericType);
    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * @param value 字符串
     * @param genericType 指定对象的上下文属性
     * @return 对象
     */
    protected abstract T doToObject(String value, G genericType);
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <GT extends GenericType<T>> String toString(T value, GT genericType) {
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
    public <GT extends GenericType<T>> T toObject(String value, GT genericType) {
        if (supportFor(genericType)) {
            return doToObject(value, (G) genericType);
        }
        return null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Class<T> getType() {
        return type;
    }
    /**
     * <p>
     * 返回泛型声明的类型
     * </p>
     * @return 泛型声明的类型
     */
    protected Class<T> getGenricType() {
        return type;
    }
}
