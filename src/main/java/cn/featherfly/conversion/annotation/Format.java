
package cn.featherfly.conversion.annotation;

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
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Format {
    /**
     * <p>
     * 格式化转换器转换时使用的格式
     * </p>
     *
     * @return format
     */
    String format();

    /**
     * <p>
     * 格式化转换器转换时使用的格式
     * </p>
     *
     * @return formats
     */
    String[] formats();
}
