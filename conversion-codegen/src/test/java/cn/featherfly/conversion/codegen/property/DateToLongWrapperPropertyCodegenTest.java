
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
        DateToLongWrapperPropertyCodegen dateToLong =
            new DateToLongWrapperPropertyCodegen("java.util.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(new java.util.Date(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(userDto.getCreateTime().getTime())");

        DateToLongWrapperPropertyCodegen stringToDate =
            new DateToLongWrapperPropertyCodegen("java.util.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(new java.util.Date(userDto.getCreateTime()))");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.util.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(new java.util.Date(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(getCreateTime().getTime())");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.util.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(new java.util.Date(getCreateTime()))");
    }

    /**
     * Test sql date.
     */
    @Test
    public void testSqlDate() {
        DateToLongWrapperPropertyCodegen dateToLong =
            new DateToLongWrapperPropertyCodegen("java.sql.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(new java.sql.Date(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(userDto.getCreateTime().getTime())");

        DateToLongWrapperPropertyCodegen stringToDate =
            new DateToLongWrapperPropertyCodegen("java.sql.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(new java.sql.Date(userDto.getCreateTime()))");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Date");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(new java.sql.Date(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(getCreateTime().getTime())");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Date", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(new java.sql.Date(getCreateTime()))");
    }

    /**
     * Test sql time.
     */
    @Test
    public void testSqlTime() {
        DateToLongWrapperPropertyCodegen dateToLong =
            new DateToLongWrapperPropertyCodegen("java.sql.Time");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(new java.sql.Time(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(userDto.getCreateTime().getTime())");

        DateToLongWrapperPropertyCodegen stringToDate =
            new DateToLongWrapperPropertyCodegen("java.sql.Time", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(new java.sql.Time(userDto.getCreateTime()))");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Time");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(new java.sql.Time(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(getCreateTime().getTime())");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Time", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(new java.sql.Time(getCreateTime()))");
    }

    /**
     * Test sql timestamp.
     */
    @Test
    public void testSqlTimestamp() {
        DateToLongWrapperPropertyCodegen dateToLong =
            new DateToLongWrapperPropertyCodegen("java.sql.Timestamp");
        fromTarget = dateToLong.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLong.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(new java.sql.Timestamp(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(userDto.getCreateTime().getTime())");

        DateToLongWrapperPropertyCodegen stringToDate =
            new DateToLongWrapperPropertyCodegen("java.sql.Timestamp", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(new java.sql.Timestamp(userDto.getCreateTime()))");

        dateToLong = new DateToLongWrapperPropertyCodegen("java.sql.Timestamp");
        fromTarget = dateToLong.generateFromTarget("createTime", "", "user");
        toTarget = dateToLong.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(new java.sql.Timestamp(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(getCreateTime().getTime())");

        stringToDate = new DateToLongWrapperPropertyCodegen("java.sql.Timestamp", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(user.getCreateTime().getTime())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(new java.sql.Timestamp(getCreateTime()))");
    }
}
