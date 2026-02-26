
package cn.featherfly.conversion.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;

/**
 * 使用BeanProperty作为参数的转换器.
 *
 * @author 钟冀
 */
public abstract class AbstractToStringConversion {

    private ToStringConversionPolicy conversionPolicy;

    /** 日志. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 使用传入conversionPolicy.
     *
     * @param conversionPolicy conversionPolicy
     */
    protected AbstractToStringConversion(ToStringConversionPolicy conversionPolicy) {
        this.conversionPolicy = conversionPolicy;
    }

    /**
     * 内部状态检查.
     */
    protected void check() {
        if (conversionPolicy == null) {
            throw new ConversionException("#no_policy");
        }
    }

    /**
     * 获取指定类型的转换器.
     *
     * @param <E> 泛型
     * @param type 类型
     * @return 转换器
     */
    protected <E> ToStringConvertor<E> getConvertor(Type<E> type) {
        ToStringConvertor<E> convertor = conversionPolicy.getConvertor(type);
        if (convertor == null) {
            throw new ConversionException("#no_convertor_with_type", new Object[] { type.getType().getName() });
        }
        return convertor;
    }

    /**
     * 返回conversionPolicy.
     *
     * @return conversionPolicy
     */
    public ToStringConversionPolicy getConversionPolicy() {
        return conversionPolicy;
    }

    /**
     * 设置conversionPolicy.
     *
     * @param conversionPolicy conversionPolicy
     */
    public void setConversionPolicy(ToStringConversionPolicy conversionPolicy) {
        this.conversionPolicy = conversionPolicy;
    }
}
