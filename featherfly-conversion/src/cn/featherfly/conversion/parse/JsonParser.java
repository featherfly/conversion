
package cn.featherfly.conversion.parse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * json协议解析器抽象类
 * </p>
 * @param <G> 解析的目标类型描述
 * @author 钟冀
 */
public abstract class JsonParser<G extends GenericType<?>> extends AbstractParser<G>{

    /**
     * 协议字符串常量
     */
    public static final String CLASS_PROTOCOL = "json";
    /**
     * objectMapper
     */
    protected ObjectMapper objectMapper;

    /**
     */
    public JsonParser() {
        objectMapper = new ObjectMapper();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProtocol() {
        return CLASS_PROTOCOL;
    }

    /**
     * <p>
     * 创建ParameterizedType
     * </p>
     * @param rawType rawType
     * @param ownerType ownerType
     * @param ctualTypeArguments ctualTypeArguments
     * @return ParameterizedType
     */
    protected ParameterizedType createParameterizedType(final Type rawType
            , final Type ownerType, final Type...ctualTypeArguments) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return ctualTypeArguments;
            }

            @Override
            public Type getRawType() {
                return rawType;
            }

            @Override
            public Type getOwnerType() {
                return ownerType;
            }
        };
    }
    /**
     * <p>
     * 返回正文对象
     * </p>
     * @param content 正文
     * @return Content对象
     */
    protected Content getContent(String content) {
        Content objContent = new Content();
        String className = null;
        String jsonContent = null;
        int index = content.indexOf("#{");
        if (index == -1) {
            index = content.indexOf("#[");
            objContent.isMulty = (index != -1);
        }
        if (index != -1) {
            className = StringUtils.substring(content, 0, index);
            jsonContent = StringUtils.substring(content, index + 1);
        } else {
            jsonContent = content;
        }
        objContent.className = StringUtils.trim(className);
        objContent.jsonContent = StringUtils.trim(jsonContent);
        return objContent;
    }

    /**
     * <p>
     * 内部解析使用对象Content
     * </p>
     *
     * @author 钟冀
     */
    protected static final class Content {
        /***/
        private Content() {
        }
        /**
         * className
         */
        protected String className;
        /**
         * jsonContent
         */
        protected String jsonContent;
        /**
         * isMulty
         */
        protected boolean isMulty;
    }
}
