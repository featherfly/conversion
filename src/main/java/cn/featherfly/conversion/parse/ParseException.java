
package cn.featherfly.conversion.parse;

import java.util.Locale;

import cn.featherfly.common.exception.LocalizedException;

/**
 * 配置读取解析的时候发生的异常.
 *
 * @author 钟冀
 */
public class ParseException extends LocalizedException {

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
     * @param t 异常
     * @param msg 信息
     */
    public ParseException(Throwable t, String msg) {
        super(msg, t);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param ex the ex
     * @param locale the locale
     * @param message the message
     */
    public ParseException(Throwable ex, Locale locale, String message) {
        super(message, locale, ex);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param locale the locale
     * @param message the message
     */
    public ParseException(Locale locale, String message) {
        super(message, locale);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param ex the ex
     * @param locale the locale
     * @param message the message
     * @param args the args
     */
    public ParseException(Throwable ex, Locale locale, String message, Object... args) {
        super(message, args, locale, ex);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param locale the locale
     * @param message the message
     * @param args the args
     */
    public ParseException(Locale locale, String message, Object... args) {
        super(message, args, locale);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param ex the ex
     * @param message the message
     * @param args the args
     */
    public ParseException(Throwable ex, String message, Object... args) {
        super(message, args, ex);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param message the message
     * @param args the args
     */
    public ParseException(String message, Object... args) {
        super(message, args);
    }

}
