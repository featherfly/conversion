
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-21 19:03:21
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import org.testng.annotations.Test;

/**
 * IterablePropertyCodegenTest.
 *
 * @author zhongj
 */
public abstract class IterablePropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public abstract void directAssign();

    @Test
    public abstract void directAssignPrimitiveType();

    @Test
    public abstract void enumToEnum();

    @Test
    public abstract void enumToString();

    @Test
    public abstract void beanToBean();
}
