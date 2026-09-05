
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * BooleanDirectAssignPropertyCodegen.
 *
 * @author zhongj
 */
public class BooleanDirectAssignPropertyCodegenTest {

    @Test
    public void testBoolean2boolean() {
        BooleanDirectAssignPropertyCodegen codegen = new BooleanDirectAssignPropertyCodegen(Boolean.class,
            boolean.class);

        System.out.println(codegen.generateFromTarget("deleted", "userDto", "user"));
        assertEquals(codegen.generateFromTarget("deleted", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isDeleted())) userDto.setDeleted(user.isDeleted());");

        System.out.println(codegen.generateToTarget("deleted", "userDto", "user"));
        assertEquals(codegen.generateToTarget("deleted", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getDeleted())) user.setDeleted(userDto.getDeleted());");

        System.out.println(codegen.generateFromTarget("deleted", null, "user"));
        assertEquals(codegen.generateFromTarget("deleted", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isDeleted())) setDeleted(user.isDeleted());");

        System.out.println(codegen.generateToTarget("deleted", null, "user"));
        assertEquals(codegen.generateToTarget("deleted", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getDeleted())) user.setDeleted(getDeleted());");

    }

    @Test
    public void testboolean2Boolean() {
        BooleanDirectAssignPropertyCodegen codegen = new BooleanDirectAssignPropertyCodegen(boolean.class,
            Boolean.class);
        System.out.println(codegen.generateFromTarget("deleted", "userDto", "user"));
        assertEquals(codegen.generateFromTarget("deleted", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDeleted())) userDto.setDeleted(user.getDeleted());");

        System.out.println(codegen.generateToTarget("deleted", "userDto", "user"));
        assertEquals(codegen.generateToTarget("deleted", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(isDeleted())) user.setDeleted(userDto.isDeleted());");

        System.out.println(codegen.generateFromTarget("deleted", null, "user"));
        assertEquals(codegen.generateFromTarget("deleted", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDeleted())) setDeleted(user.getDeleted());");

        System.out.println(codegen.generateToTarget("deleted", null, "user"));
        assertEquals(codegen.generateToTarget("deleted", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(isDeleted())) user.setDeleted(isDeleted());");
    }
}
