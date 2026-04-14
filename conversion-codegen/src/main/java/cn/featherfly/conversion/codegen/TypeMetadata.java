
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
     * @return the string
     */
    String name();

    /**
     * Checks if is enum.
     *
     * @return true, if is enum
     */
    boolean isEnum();
}
