
package cn.featherfly.conversion.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 格式化转换注解类
 * </p>
 *
 * @author 钟冀
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Format {
    /**
     * <p>
     * 格式化转换输出格式
     * </p>
     */
    String format();
    /**
     * <p>
     * 格式化支持的输入格式
     * </p>
     */
    String[] formats();
}
