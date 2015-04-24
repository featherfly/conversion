
package cn.featherfly.conversion.core.format;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.conversion.core.AbstractConvertor;
import cn.featherfly.conversion.core.Convertor;


/**
 * <p>
 * 格式化转换器
 * </p>
 * @param <T> 转换对象
 * @author 钟冀
 */
public abstract class FormatConvertor<T> extends AbstractConvertor<T, FormatType<T>>{

    private Convertor<T> convertor;
    
    /**
     * @param convertor convertor
     */
    public FormatConvertor(Convertor<T> convertor) {
        this.convertor = convertor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<T> generecType) {
        if (generecType == null) {
            return false;
        }
        return FormatType.class == generecType.getClass();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected String doToString(T value, FormatType<T> genericType) {
        String result = formatToString(value, genericType);
        if (result == null) {
            return convertor.toString(value, null);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T doToObject(String value, FormatType<T> genericType) {
        T result = formatToObject(value, genericType);
        if (result == null) {
            return convertor.toObject(value, null);
        }
        return result;
    }

    /**
     * 返回convertor
     * @return convertor
     */
    public Convertor<T> getConvertor() {
        return convertor;
    }
    
    /**
     * <p>
     * 对象转换为字符串
     * </p>
     * @param value 对象
     * @param genericType 指定对象的上下文属性
     * @return 字符串
     */
    protected abstract String formatToString(T value, FormatType<T> genericType);
    /**
     * <p>
     * 字符串转换为对象
     * </p>
     * @param value 字符串
     * @param genericType 指定对象的上下文属性
     * @return 对象
     */
    protected abstract T formatToObject(String value, FormatType<T> genericType);
}
