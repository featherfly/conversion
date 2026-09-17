
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
     * The Enum MethodType.
     *
     * @author zhongj
     */
    public enum MethodType {

        /** constructor. */
        CONSTRUCTOR,

        /** method. */
        METHOD,

        /** static method. */
        STATIC_METHOD
    }

    /**
     * Name.
     *
     * @return the string
     */
    String name();

    /**
     * methodType.
     *
     * @return MethodType
     */
    MethodType methodType();

    /**
     * Checks if is given argument.
     *
     * @return true, if is given argument
     */
    boolean isGivenArgument();

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
