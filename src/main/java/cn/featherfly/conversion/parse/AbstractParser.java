
package cn.featherfly.conversion.parse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.reflect.Type;

/**
 * AbstractParser.
 *
 * @author 钟冀
 * @param <G> 解析后的目标类型描述信息
 */
public abstract class AbstractParser<G extends Type<?>> implements Parser {

    /** 日志. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 是否提供对传入类型的支持.
     *
     * @param to to
     * @return 是否支持
     */
    protected abstract boolean supportFor(Type<?> to);

    /**
     * 解析传入的字符串.
     *
     * @param <T> 返回类型
     * @param content 需要解析的内容
     * @param to 解析的目标类型描述信息
     * @return 解析后的对象
     */
    protected abstract <T> T doParse(String content, G to);

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <TO extends Type<T>, T> T parse(String content, TO to) {
        if (supportFor(to)) {
            T result = doParse(content, (G) to);
            return result;
        }
        return null;
    }
}
