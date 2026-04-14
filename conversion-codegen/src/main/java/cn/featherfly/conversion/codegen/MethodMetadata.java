
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-14 16:29:14
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

/**
 * MethodInfo.
 *
 * @author zhongj
 * @since 0.1.0
 */
public interface MethodMetadata {

    /**
     * Name.
     *
     * @return the string
     */
    String name();

    /**
     * Checks if is static.
     *
     * @return true, if is static
     */
    boolean isStatic();

    /**
     * Checks if is constructor.
     *
     * @return true, if is constructor
     */
    boolean isConstructor();
}
