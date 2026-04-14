
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-16 15:29:16
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

/**
 * CodegenUtils.
 *
 * @author zhongj
 */
public final class CodegenUtils {

    private CodegenUtils() {

    }

    /**
     * Gets the class name.
     *
     * @param type the type
     * @return the class name
     */
    public static String getClassName(Class<?> type) {
        return getClassName(type.getName());
    }

    /**
     * Gets the class name.
     *
     * @param typeName the type name
     * @return the class name
     */
    public static String getClassName(String typeName) {
        return typeName.replaceAll("\\$", ".");
    }
}
