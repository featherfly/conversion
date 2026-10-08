
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
 * The Class DateToLongWrapperPropertyCodegenTest.
 *
 * @author zhongj
 */
public class DateToLongWrapperPropertyCodegenTest extends PropertyCodegenTest {

    /**
     * Test date.
     */
    @Test
    public void testDate() {
        DateToLongWrapperPropertyCodegen dateToLong = new DateToLongWrapperPropertyCodegen("java.util.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(new java.util.Date(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
                + "}");

        DateToLongWrapperPropertyCodegen stringToDate = new DateToLongWrapperPropertyCodegen("java.util.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(new java.util.Date(userDto.getCreateTime()));\n" //
                + "}");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.util.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(new java.util.Date(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(getCreateTime().getTime());\n" //
                + "}");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.util.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(new java.util.Date(getCreateTime()));\n" //
                + "}");
    }

    /**
     * Test sql date.
     */
    @Test
    public void testSqlDate() {
        DateToLongWrapperPropertyCodegen dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(new java.sql.Date(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
                + "}");

        DateToLongWrapperPropertyCodegen stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(new java.sql.Date(userDto.getCreateTime()));\n" //
                + "}");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(new java.sql.Date(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(getCreateTime().getTime());\n" //
                + "}");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(new java.sql.Date(getCreateTime()));\n" //
                + "}");
    }

    /**
     * Test sql time.
     */
    @Test
    public void testSqlTime() {
        DateToLongWrapperPropertyCodegen dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Time");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(new java.sql.Time(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
                + "}");

        DateToLongWrapperPropertyCodegen stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Time", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(new java.sql.Time(userDto.getCreateTime()));\n" //
                + "}");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Time");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(new java.sql.Time(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(getCreateTime().getTime());\n" //
                + "}");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Time", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(new java.sql.Time(getCreateTime()));\n" //
                + "}");
    }

    /**
     * Test sql timestamp.
     */
    @Test
    public void testSqlTimestamp() {
        DateToLongWrapperPropertyCodegen dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Timestamp");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(new java.sql.Timestamp(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(userDto.getCreateTime().getTime());\n" //
                + "}");

        DateToLongWrapperPropertyCodegen stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Timestamp",
            true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    userDto.setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n"
                + "    user.setCreateTime(new java.sql.Timestamp(userDto.getCreateTime()));\n" //
                + "}");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Timestamp");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(new java.sql.Timestamp(user.getCreateTime()));\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(getCreateTime().getTime());\n" //
                + "}");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Timestamp", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n"
                + "    setCreateTime(user.getCreateTime().getTime());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) {\n"
                + "    user.setCreateTime(new java.sql.Timestamp(getCreateTime()));\n" //
                + "}");
    }
}
