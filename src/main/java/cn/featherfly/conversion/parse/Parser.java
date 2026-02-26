
package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.reflect.Type;

/**
 * Parser.
 *
 * @author 钟冀
 */
public interface Parser {

    /**
     * 获取解析器的协议.
     *
     * @return 协议
     */
    String getProtocol();

    /**
     * 解析传入的字符串.
     *
     * @param <TO> 类型描述
     * @param <T> 返回类型
     * @param content 需要解析的内容
     * @param to 解析的目标类型描述信息
     * @return 解析后的对象
     */
    <TO extends Type<T>, T> T parse(String content, TO to);
}
