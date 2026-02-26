
package cn.featherfly.conversion.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 格式化转换注解类.
 *
 * @author 钟冀
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Format {

    /**
     * 格式化转换器转换时使用的格式.
     *
     * @return format
     */
    String format();

    /**
     * 格式化转换器转换时使用的格式.
     *
     * @return formats
     */
    String[] formats();
}
