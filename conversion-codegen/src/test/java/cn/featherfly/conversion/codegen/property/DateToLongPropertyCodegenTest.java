
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
 * DateToLongPropertyCodegenTest.
 *
 * @author zhongj
 */
public class DateToLongPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void testDate() {
        DateToLongPropertyCodegen dateToLong = new DateToLongPropertyCodegen("java.util.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(new java.util.Date(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
            + "}");

        DateToLongPropertyCodegen stringToDate = new DateToLongPropertyCodegen("java.util.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.util.Date(userDto.getCreateTime()));\n" //
            + "}");

        dateToLong = new DateToLongPropertyCodegen("java.util.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(new java.util.Date(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(getCreateTime().getTime());\n" //
            + "}");

        stringToDate = new DateToLongPropertyCodegen("java.util.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.util.Date(getCreateTime()));\n" //
            + "}");
    }

    @Test
    public void testSqlDate() {
        DateToLongPropertyCodegen dateToLong = new DateToLongPropertyCodegen("java.sql.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(new java.sql.Date(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
            + "}");

        DateToLongPropertyCodegen stringToDate = new DateToLongPropertyCodegen("java.sql.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.sql.Date(userDto.getCreateTime()));\n" //
            + "}");

        dateToLong = new DateToLongPropertyCodegen("java.sql.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(new java.sql.Date(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(getCreateTime().getTime());\n" //
            + "}");

        stringToDate = new DateToLongPropertyCodegen("java.sql.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.sql.Date(getCreateTime()));\n" //
            + "}");
    }

    @Test
    public void testSqlTime() {
        DateToLongPropertyCodegen dateToLong = new DateToLongPropertyCodegen("java.sql.Time");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(new java.sql.Time(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
            + "}");

        DateToLongPropertyCodegen stringToDate = new DateToLongPropertyCodegen("java.sql.Time", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.sql.Time(userDto.getCreateTime()));\n" //
            + "}");

        dateToLong = new DateToLongPropertyCodegen("java.sql.Time");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(new java.sql.Time(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(getCreateTime().getTime());\n" //
            + "}");

        stringToDate = new DateToLongPropertyCodegen("java.sql.Time", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.sql.Time(getCreateTime()));\n" //
            + "}");
    }

    @Test
    public void testSqlTimestamp() {
        DateToLongPropertyCodegen dateToLong = new DateToLongPropertyCodegen("java.sql.Timestamp");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(new java.sql.Timestamp(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
            + "}");

        DateToLongPropertyCodegen stringToDate = new DateToLongPropertyCodegen("java.sql.Timestamp", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.sql.Timestamp(userDto.getCreateTime()));\n" //
            + "}");

        dateToLong = new DateToLongPropertyCodegen("java.sql.Timestamp");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(new java.sql.Timestamp(user.getCreateTime()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(getCreateTime().getTime());\n" //
            + "}");

        stringToDate = new DateToLongPropertyCodegen("java.sql.Timestamp", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    setCreateTime(user.getCreateTime().getTime());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n" //
            + "    user.setCreateTime(new java.sql.Timestamp(getCreateTime()));\n" //
            + "}");
    }
}
