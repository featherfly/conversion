
package cn.featherfly.conversion.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.GenericType;


/**
 * <p>
 * 使用BeanProperty作为参数的转换器.
 * </p>
 * @param <G> 类型信息
 * @author 钟冀
 */
public abstract class AbstractConversion<G extends GenericType<?>>  implements Conversion<G>{
    
    private ConversionPolicy conversionPolicy;

    /**
     * 日志
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 使用BASIC_CONVERSION_POLICY
     */
    public AbstractConversion() {
        this(ConversionPolicys.getBasicConversionPolicy());
    }
    /**
     * 使用传入conversionPolicy
     * @param conversionPolicy conversionPolicy
     */
    public AbstractConversion(ConversionPolicy conversionPolicy) {
        this.conversionPolicy = conversionPolicy;
    }
    
    /**
     * <p>
     * 内部状态检查
     * </p>
     */
    protected void check() {
        if (conversionPolicy == null) {
            throw new ConversionException("#no_policy");
        }
    }

    /**
     * <p>
     * 获取指定类型的转换器
     * </p>
     * @param <E> 泛型
     * @param type 类型
     * @return 转换器
     */
    protected <E> Convertor<E> getConvertor(Class<E> type) {
        @SuppressWarnings("unchecked")
        Convertor<E> convertor = (Convertor<E>) conversionPolicy.getConvertor(type);
        if (convertor == null) {
            throw new ConversionException("#no_convertor_with_type"
            		, new Object[]{type.getName()});
        }
        return convertor;
    }

    /**
     * 返回conversionPolicy
     * @return conversionPolicy
     */
    public ConversionPolicy getConversionPolicy() {
        return conversionPolicy;
    }
    /**
     * 设置conversionPolicy
     * @param conversionPolicy conversionPolicy
     */
    public void setConversionPolicy(ConversionPolicy conversionPolicy) {
        this.conversionPolicy = conversionPolicy;
    }
}
