
package cn.featherfly.conversion.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.featherfly.conversion.core.Convertor;

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
     * @return 转换器类型
     */
    Class<? extends Convertor<?>> conversion();
}
