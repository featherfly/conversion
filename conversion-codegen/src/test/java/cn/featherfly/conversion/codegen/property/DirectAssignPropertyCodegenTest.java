
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-13 15:04:13
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * DirectAssignPropertyCodegenTest.
 *
 * @author zhongj
 */
public class DirectAssignPropertyCodegenTest {

    @Test
    public void test() {
        DirectAssignPropertyCodegen codegen = new DirectAssignPropertyCodegen();

        System.out.println(codegen.generateFromTarget("id", "userDto", "user"));
        assertEquals(codegen.generateFromTarget("id", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId())");
        assertEquals(codegen.generateFromTarget("name", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName())");
        assertEquals(codegen.generateFromTarget("age", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAge())) userDto.setAge(user.getAge())");

        System.out.println(codegen.generateToTarget("id", "userDto", "user"));
        assertEquals(codegen.generateToTarget("id", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId())");
        assertEquals(codegen.generateToTarget("name", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getName())) user.setName(userDto.getName())");
        assertEquals(codegen.generateToTarget("age", "userDto", "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAge())) user.setAge(userDto.getAge())");

        System.out.println(codegen.generateFromTarget("id", null, "user"));
        assertEquals(codegen.generateFromTarget("id", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId())");
        assertEquals(codegen.generateFromTarget("name", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) setName(user.getName())");
        assertEquals(codegen.generateFromTarget("age", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAge())) setAge(user.getAge())");

        System.out.println(codegen.generateToTarget("id", null, "user"));
        assertEquals(codegen.generateToTarget("id", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId())");
        assertEquals(codegen.generateToTarget("name", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName())");
        assertEquals(codegen.generateToTarget("age", null, "user"),
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getAge())) user.setAge(getAge())");
    }
}
