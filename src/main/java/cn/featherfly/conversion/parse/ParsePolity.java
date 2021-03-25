
package cn.featherfly.conversion.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.StringUtils;

/**
 * <p>
 * 解析策略
 * </p>
 *
 * @author 钟冀
 */
public class ParsePolity {

    /**
     */
    public ParsePolity() {
    }

    /*
     * parsers
     */
    private Map<String, Parser> parsers = new HashMap<String, Parser>();

    /**
     * <p>
     * 解析传入的字符串
     * </p>
     * @param <T> 返回类型
     * @param resolve 需要解析的字符串
     * @param gt 需要解析完成后的目标GenericType
     * @return 解析后的对象
     */
    public <T> T parse(String resolve, GenericType<T> gt) {
        String protocol = null;
        if (Lang.isNotEmpty(resolve)) {
            protocol = getProtocol(resolve);
        }
        if (Lang.isEmpty(protocol)) {
            return null;
        }
        String content = getContent(resolve);
        for (Parser parser : parsers.values()) {
            if (protocol.equals(parser.getProtocol())) {
                return (T) parser.parse(content, gt);
            }
        }
        return null;
    }

    /**
     * <p>
     * 判断传入的字符串是否可以被解析
     * </p>
     * @param resolve 需要解析的字符串
     * @return 是否可以解析传入字符串
     */
    public boolean canParse(String resolve) {
        for (String protocol : parsers.keySet()) {
            if (resolve.startsWith(protocol + ":")) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * 批量注册解析器
     * </p>
     * @param parsers 解析器集合
     */
    public void register(Collection<Parser> parsers) {
        if (Lang.isNotEmpty(parsers)) {
            for (Parser parser : parsers) {
                register(parser);
            }
        }
    }
    /**
     * <p>
     * 批量注册解析器
     * </p>
     * @param parsers 解析器数组
     */
    public void register(Parser...parsers) {
        if (Lang.isNotEmpty(parsers)) {
            for (Parser parser : parsers) {
                register(parser);
            }
        }
    }
    /**
     * <p>
     * 注册解析器
     * </p>
     * @param parser 解析器
     */
    public void register(Parser parser) {
        if (parser != null) {
            if (isRegister(parser)) {
                throw new ParseException(
                    StringUtils.format("协议[#1]已经被[#2]注册"
                        , parser.getProtocol()
                        , getParser(parser.getProtocol()).getClass().getName()));
            }
            parsers.put(parser.getProtocol(), parser);
        }
    }
    /**
     * <p>
     * 注销协议
     * </p>
     * @param protocol 解析协议
     */
    public void unregister(String protocol) {
        parsers.remove(protocol);
    }
    /**
     * <p>
     * 注销解析器
     * </p>
     * @param parser 解析解析器
     */
    public void unregister(Parser parser) {
        if (parser != null) {
            parsers.remove(parser.getProtocol());
        }
    }
    /**
     * <p>
     * 返回已经注册的所有协议
     * </p>
     * @return 已经注册的所有协议
     */
    public Collection<String> getProtocols() {
        return new ArrayList<String>(parsers.keySet());
    }

    /**
     * <p>
     * 返回已经注册的所有解析器
     * </p>
     * @return 已经注册的所有解析器
     */
    public Collection<Parser> getParsers() {
        return new ArrayList<Parser>(parsers.values());
    }

    /**
     * <p>
     * 返回是否注册有传入的协议
     * </p>
     * @param protocol 解析协议
     * @return 是否注册协议
     */
    public boolean isRegister(String protocol) {
        return parsers.containsKey(protocol);
    }

    /**
     * <p>
     * 返回是否注册有传入解析器
     * </p>
     * @param parser 解析器
     * @return 是否注册解析器
     */
    public boolean isRegister(Parser parser) {
        return isRegister(parser.getProtocol());
    }

    /**
     * <p>
     * 返回指定协议解析器
     * </p>
     * @param protocol 解析协议
     * @return 解析器
     */
    public Parser getParser(String protocol) {
        return parsers.get(protocol);
    }

    // ********************************************************************
    //
    // ********************************************************************

    // ********************************************************************
    //
    // ********************************************************************

    /**
     * <p>
     * 获取传入字符串的解析协议
     * </p>
     * @param resolve 需要解析的字符串
     * @return 传入字符串的解析协议
     */
    protected String getProtocol(String resolve) {
        if (Lang.isEmpty(resolve)) {
            return null;
        }
        int index = resolve.indexOf(':');
        if (index > 0) {
            return resolve.substring(0, index);
        }
        return null;
    }
    /**
     * <p>
     * 获取传入字符串的内容
     * </p>
     * @param resolve 需要解析的字符串
     * @return 传入字符串的内容
     */
    protected String getContent(String resolve) {
        if (Lang.isEmpty(resolve)) {
            return null;
        }
        int index = resolve.indexOf(':');
        if (index > 0) {
            return resolve.substring(index + 1);
        }
        return null;
    }
}
