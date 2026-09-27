
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

    //    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDeleted())) user.setDeleted(userDto.getDeleted());
    //    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDeleted())) user.setDeleted(userDto.getDeleted());

    @Test
    public void testBoolean2boolean() {
        BooleanDirectAssignPropertyCodegen codegen = new BooleanDirectAssignPropertyCodegen(Boolean.class,
            boolean.class);

        String result = codegen.generateFromTarget("deleted", "userDto", "user");

        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isDeleted())) userDto.setDeleted(user.isDeleted());");

        result = codegen.generateToTarget("deleted", "userDto", "user");
        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDeleted())) user.setDeleted(userDto.getDeleted());");

        result = codegen.generateFromTarget("deleted", null, "user");
        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isDeleted())) setDeleted(user.isDeleted());");

        result = codegen.generateToTarget("deleted", null, "user");
        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getDeleted())) user.setDeleted(getDeleted());");

    }

    @Test
    public void testboolean2Boolean() {
        BooleanDirectAssignPropertyCodegen codegen = new BooleanDirectAssignPropertyCodegen(boolean.class,
            Boolean.class);

        String result = codegen.generateFromTarget("deleted", "userDto", "user");
        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDeleted())) userDto.setDeleted(user.getDeleted());");

        result = codegen.generateToTarget("deleted", "userDto", "user");
        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.isDeleted())) user.setDeleted(userDto.isDeleted());");

        result = codegen.generateFromTarget("deleted", null, "user");
        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDeleted())) setDeleted(user.getDeleted());");

        result = codegen.generateToTarget("deleted", null, "user");
        System.out.println(result);
        assertEquals(result,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(isDeleted())) user.setDeleted(isDeleted());");
    }
}
