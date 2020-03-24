
package cn.featherfly.conversion.string.format;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.lang.GenericType;

/**
 * <p>
 * Format
 * </p>
 * @param <T> 对象类型
 * @author 钟冀
 */
public class FormatType<T> implements GenericType<T>{
    
    /**
     * 
     * @param type type
     */
    public FormatType(Class<T> type) {
        this.type = type;
    }

    private Class<T> type;
    
    private String format;
    
    private List<String> formats = new ArrayList<>(0);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Class<T> getType() {
        return type;
    }

    /**
     * 返回format
     * @return format
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置format
     * @param format format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * 返回formats
     * @return formats
     */
    public List<String> getFormats() {
        return formats;
    }

    /**
     * 设置formats
     * @param formats formats
     */
    public void setFormats(List<String> formats) {
        this.formats = formats;
    }
}
