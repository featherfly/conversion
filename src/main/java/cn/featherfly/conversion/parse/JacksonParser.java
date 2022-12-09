
package cn.featherfly.conversion.parse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用jackson解析协议的解析器抽象类.
 *
 * @author 钟冀
 * @param <G> 解析的目标类型描述
 */
public abstract class JacksonParser<G extends cn.featherfly.common.lang.reflect.Type<?>> extends AbstractParser<G> {

    /** objectMapper. */
    protected ObjectMapper objectMapper;

    /**
     * Instantiates a new jackson parser.
     *
     * @param objectMapper the object mapper
     */
    public JacksonParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * <p>
     * 创建ParameterizedType
     * </p>
     * .
     *
     * @param rawType            rawType
     * @param ownerType          ownerType
     * @param ctualTypeArguments ctualTypeArguments
     * @return ParameterizedType
     */
    protected ParameterizedType createParameterizedType(final Type rawType, final Type ownerType,
            final Type... ctualTypeArguments) {
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
     * .
     *
     * @param content 正文
     * @return Content对象
     */
    protected abstract Content getContent(String content);

    /**
     * <p>
     * 内部解析使用对象Content
     * </p>
     * .
     *
     * @author 钟冀
     */
    protected static final class Content {

        /**
         * Instantiates a new content.
         */
        protected Content() {
        }

        /** className. */
        protected String className;

        /** jsonContent. */
        protected String content;

        /** isMulty. */
        protected boolean isMulty;
    }
}
