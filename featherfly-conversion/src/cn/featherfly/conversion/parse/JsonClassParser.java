
package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.reflect.GenericClass;


/**
 * <p>
 * json class类协议解析器
 * </p>
 *
 * @author 钟冀
 */
public class JsonClassParser extends JsonParser<GenericClass<Class<?>>>{
    /**
     */
    public JsonClassParser() {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportFor(GenericType<?> to) {
        if (to == null) {
            return false;
        }
        return to.getClass() == GenericClass.class;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T doParse(String content, GenericClass<Class<?>> gt) {
        if (LangUtils.isEmpty(content)) {
            return null;
        }
        try {
            Content objContent = getContent(content);
            String className = objContent.className;
            String jsonContent = objContent.jsonContent;
            
            if (LangUtils.isEmpty(className)) {
                className = gt.getType().getName();
            }

            if (LangUtils.isEmpty(className)) {
                throw new IllegalArgumentException("parse(String content)必须显示指定类型（class）");
            }
            return (T) objectMapper.reader(Class.forName(className)).readValue(jsonContent);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }
}
