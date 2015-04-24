
package cn.featherfly.conversion.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.featherfly.conversion.Convertor;

/**
 * <p>
 * 手动设置转换类的注解
 * </p>
 *
 * @author 钟冀
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Assign {
    /**
     * <p>
     * 手动设置转换类
     * </p>
     */
    Class<? extends Convertor<?>> conversion();
}
