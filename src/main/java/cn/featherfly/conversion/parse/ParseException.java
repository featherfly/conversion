
package cn.featherfly.conversion.parse;

/**
 * 配置读取解析的时候发生的异常.
 *
 * @author 钟冀
 */
public class ParseException extends RuntimeException {

    private static final long serialVersionUID = 1348668900325588507L;

    private static final String MSG_PRE = "解析出错 ";

    /**
     * Instantiates a new parses the exception.
     */
    public ParseException() {
        super(MSG_PRE);
    }

    /**
     * 构造方法.
     *
     * @param t 异常
     */
    public ParseException(Throwable t) {
        super(t);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param msg 信息
     */
    public ParseException(String msg) {
        super(msg);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param msg 信息
     * @param t 异常
     */
    public ParseException(String msg, Throwable t) {
        super(msg, t);
    }
}
