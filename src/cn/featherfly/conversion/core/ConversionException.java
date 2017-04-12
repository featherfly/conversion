
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
	 * @param message
	 * @param locale
	 * @param ex
	 */
	public ConversionException(String message, Locale locale, Throwable ex) {
		super(message, locale, ex);
	}

	/**
	 * @param message
	 * @param locale
	 */
	public ConversionException(String message, Locale locale) {
		super(message, locale);
	}

	/**
	 * @param message
	 * @param argus
	 * @param locale
	 * @param ex
	 */
	public ConversionException(String message, Object[] argus, Locale locale, Throwable ex) {
		super(message, argus, locale, ex);
	}

	/**
	 * @param message
	 * @param argus
	 * @param locale
	 */
	public ConversionException(String message, Object[] argus, Locale locale) {
		super(message, argus, locale);
	}

	/**
	 * @param message
	 * @param argus
	 * @param ex
	 */
	public ConversionException(String message, Object[] argus, Throwable ex) {
		super(message, argus, ex);
	}

	/**
	 * @param message
	 * @param argus
	 */
	public ConversionException(String message, Object[] argus) {
		super(message, argus);
	}

	/**
	 * @param ex
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
