
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-17 17:29:17
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

/**
 * TypeMetadata.
 *
 * @author zhongj
 */
public interface TypeMetadata {

    /**
     * Name.
     *
     * @return the name
     */
    String name();

    /**
     * array or iterable element type if is array or iterable.
     *
     * @return the element type
     */
    TypeMetadata elementType();

    /**
     * Checks if is enum.
     *
     * @return true, if is enum
     */
    boolean isEnum();

    /**
     * Checks if is array.
     *
     * @return true, if is array
     */
    boolean isArray();

    /**
     * Checks if is iterable.
     *
     * @return true, if is iterable
     */
    boolean isIterable();
}
