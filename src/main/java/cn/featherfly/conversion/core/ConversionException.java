
package cn.featherfly.conversion.core;

import java.util.Locale;

import cn.featherfly.common.exception.LocalizedException;

/**
 * <p>
 * 类型转换的时候发生的异常.
 * </p>
 * @author 钟冀
 */
public class ConversionException extends LocalizedException{

    private static final long serialVersionUID = 1348668900325588507L;

    private static final String MSG_PRE = "#msg_pre";

    /**
	 * @param message message
	 * @param locale locale
	 * @param ex ex
	 */
	public ConversionException(String message, Locale locale, Throwable ex) {
		super(message, locale, ex);
	}

	/**
	 * @param message message
	 * @param locale locale
	 */
	public ConversionException(String message, Locale locale) {
		super(message, locale);
	}

	/**
	 * @param message message
	 * @param argus argus
	 * @param locale locale
	 * @param ex ex
	 */
	public ConversionException(String message, Object[] argus, Locale locale, Throwable ex) {
		super(message, argus, locale, ex);
	}

	/**
	 * @param message message
	 * @param argus argus
	 * @param locale locale
	 */
	public ConversionException(String message, Object[] argus, Locale locale) {
		super(message, argus, locale);
	}

	/**
	 * @param message message
	 * @param argus argus
	 * @param ex ex
	 */
	public ConversionException(String message, Object[] argus, Throwable ex) {
		super(message, argus, ex);
	}

	/**
	 * @param message message
	 * @param argus argus
	 */
	public ConversionException(String message, Object[] argus) {
		super(message, argus);
	}

	/**
	 * @param ex ex
	 */
	public ConversionException(Throwable ex) {
		super(ex);
	}

	/**
     * 构造方法
     */
    public ConversionException() {
        super(MSG_PRE);
    }

    /**
     * 构造方法
     * @param msg 信息
     */
    public ConversionException(String msg) {
        super(msg);
    }

    /**
     * 构造方法
     * @param msg 信息
     * @param t 异常
     */
    public ConversionException(String msg, Throwable t) {
        super(msg, t);
    }
}
