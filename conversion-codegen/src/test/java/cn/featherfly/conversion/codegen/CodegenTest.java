
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-16 15:26:16
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

/**
 * CodegenTest.
 *
 * @author zhongj
 */
public class CodegenTest {

    protected String getClassName(Class<?> type) {
        return CodegenUtils.getClassName(type);
    }
}
