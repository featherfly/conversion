
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-13 15:10:13
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * LocalDateToStringPropertyCodegenTest.
 *
 * @author zhongj
 */
public class LocalDateToStringPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void testDefaultFormat() {
        LocalDateToStringPropertyCodegen dateToString = new LocalDateToStringPropertyCodegen();
        fromTarget = dateToString.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToString.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDate(user.getCreateTime()));\n"
                + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
            + "    user.setCreateTime(cn.featherfly.common.lang.Dates.formatDate(userDto.getCreateTime()));\n" + "}");

        LocalDateToStringPropertyCodegen stringToDate = new LocalDateToStringPropertyCodegen(true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
            + "    userDto.setCreateTime(cn.featherfly.common.lang.Dates.formatDate(user.getCreateTime()));\n" + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDate(userDto.getCreateTime()));\n"
                + "}");

        dateToString = new LocalDateToStringPropertyCodegen();
        fromTarget = dateToString.generateFromTarget("createTime", null, "user");
        toTarget = dateToString.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
            + "    setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDate(user.getCreateTime()));\n" + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
            + "    user.setCreateTime(cn.featherfly.common.lang.Dates.formatDate(getCreateTime()));\n" + "}");

        stringToDate = new LocalDateToStringPropertyCodegen(true);
        fromTarget = stringToDate.generateFromTarget("createTime", null, "user");
        toTarget = stringToDate.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
            + "    setCreateTime(cn.featherfly.common.lang.Dates.formatDate(user.getCreateTime()));\n" + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
            + "    user.setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDate(getCreateTime()));\n" + "}");
    }

    @Test
    public void testWithFormat() {
        LocalDateToStringPropertyCodegen dateToString = new LocalDateToStringPropertyCodegen("yyyy-MM-dd");
        fromTarget = dateToString.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToString.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
            + "    userDto.setCreateTime(java.time.LocalDate.parse(user.getCreateTime(), \"yyyy-MM-dd\"));\n" + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
            + "    user.setCreateTime(cn.featherfly.common.lang.Dates.format(userDto.getCreateTime(), \"yyyy-MM-dd\"));\n"
            + "}");

        LocalDateToStringPropertyCodegen stringToDate = new LocalDateToStringPropertyCodegen("yyyy-MM-dd", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
            + "    userDto.setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd\"));\n"
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
            + "    user.setCreateTime(java.time.LocalDate.parse(userDto.getCreateTime(), \"yyyy-MM-dd\"));\n" + "}");

        dateToString = new LocalDateToStringPropertyCodegen("yyyy-MM-dd");
        fromTarget = dateToString.generateFromTarget("createTime", null, "user");
        toTarget = dateToString.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
            + "    setCreateTime(java.time.LocalDate.parse(user.getCreateTime(), \"yyyy-MM-dd\"));\n" + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(cn.featherfly.common.lang.Dates.format(getCreateTime(), \"yyyy-MM-dd\"));\n"
                + "}");

        stringToDate = new LocalDateToStringPropertyCodegen("yyyy-MM-dd", true);
        fromTarget = stringToDate.generateFromTarget("createTime", null, "user");
        toTarget = stringToDate.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd\"));\n"
                + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
            + "    user.setCreateTime(java.time.LocalDate.parse(getCreateTime(), \"yyyy-MM-dd\"));\n" + "}");
    }

}
