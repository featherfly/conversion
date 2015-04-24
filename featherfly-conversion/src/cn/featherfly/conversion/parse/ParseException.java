
package cn.featherfly.conversion.parse;

/**
 * <p>
 * 配置读取解析的时候发生的异常.
 * </p>
 * @author 钟冀
 */
public class ParseException extends RuntimeException{

    private static final long serialVersionUID = 1348668900325588507L;

    private static final String MSG_PRE = "解析出错 ";

    /**
     * 构造方法
     */
    public ParseException() {
        super(MSG_PRE);
    }

    /**
     * 构造方法
     * @param t 异常
     */
    public ParseException(Throwable t) {
        super(t);
    }

    /**
     * 构造方法
     * @param msg 信息
     */
    public ParseException(String msg) {
        super(msg);
    }

    /**
     * 构造方法
     * @param msg 信息
     * @param t 异常
     */
    public ParseException(String msg, Throwable t) {
        super(msg, t);
    }
}
