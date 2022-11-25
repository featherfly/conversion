
package cn.featherfly.conversion.parse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.Strings;

/**
 * <p>
 * json协议解析器抽象类
 * </p>
 *
 * @param <G> 解析的目标类型描述
 * @author 钟冀
 */
public abstract class JsonParser<G extends Type<?>> extends JacksonParser<G> {

    /**
     * 协议字符串常量
     */
    public static final String PROTOCOL = "json";

    /**
     */
    public JsonParser() {
        super(new ObjectMapper());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Content getContent(String content) {
        Content objContent = new Content();
        String className = null;
        String jsonContent = null;
        int index = content.indexOf("#{");
        if (index == -1) {
            index = content.indexOf("#[");
            objContent.isMulty = index != -1;
        }
        if (index != -1) {
            className = org.apache.commons.lang3.StringUtils.substring(content, 0, index);
            jsonContent = org.apache.commons.lang3.StringUtils.substring(content, index + 1);
        } else {
            jsonContent = content;
        }
        objContent.className = Strings.trim(className);
        objContent.content = Strings.trim(jsonContent);
        return objContent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProtocol() {
        return PROTOCOL;
    }
}
