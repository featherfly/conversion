
package cn.featherfly.conversion.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.featherfly.conversion.Convertor;

/**
 * 手动设置转换类的注解.
 *
 * @author 钟冀
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Assign {

    /**
     * 手动设置转换类.
     *
     * @return 转换器类型
     */
    Class<? extends Convertor<?, ?>> conversion();
}
