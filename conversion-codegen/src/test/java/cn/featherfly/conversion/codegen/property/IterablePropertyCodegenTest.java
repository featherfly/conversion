
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-21 19:03:21
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import org.testng.annotations.Test;

import cn.featherfly.conversion.codegen.BeanCodegen;
import cn.featherfly.conversion.codegen.BeanCodegenImpl;

/**
 * IterablePropertyCodegenTest.
 *
 * @author zhongj
 */
public abstract class IterablePropertyCodegenTest extends PropertyCodegenTest {

    // 因为主生成没有的indentStart为0，所有element的 indentStart为1
    protected BeanCodegen iterableElementBeanCodegen = BeanCodegenImpl.builder().setIndentStart(1).build();

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
