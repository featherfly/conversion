
package cn.featherfly.conversion.parse;

import cn.featherfly.common.lang.GenericType;



/**
 * <p>
 * Parser
 * </p>
 *
 * @author 钟冀
 */
public interface Parser {
    /**
     * <p>
     * 获取解析器的协议
     * </p>
     * @return 协议
     */
    String getProtocol();
    /**
     * <p>
     * 解析传入的字符串
     * </p>
     * @param <T> 返回类型
     * @param <TO> 类型描述
     * @param content 需要解析的内容
     * @param to 解析的目标类型描述信息
     * @return 解析后的对象
     */
    <TO extends GenericType<T>, T> T parse(String content, TO to);
}
