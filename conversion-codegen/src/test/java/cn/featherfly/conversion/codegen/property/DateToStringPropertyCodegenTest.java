
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
 * DateToStringPropertyCodegenTest.
 *
 * @author zhongj
 */
public class DateToStringPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void testDate() {
        DateToStringPropertyCodegen dateToString =
            new DateToStringPropertyCodegen("java.util.Date", "yyyy-MM-dd HH:mm:ss");
        fromTarget = dateToString.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToString.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.parse(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.format(userDto.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");

        DateToStringPropertyCodegen stringToDate =
            new DateToStringPropertyCodegen("java.util.Date", "yyyy-MM-dd HH:mm:ss", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.parse(userDto.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");

        dateToString = new DateToStringPropertyCodegen("java.util.Date", "yyyy-MM-dd HH:mm:ss");
        fromTarget = dateToString.generateFromTarget("createTime", "", "user");
        toTarget = dateToString.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.parse(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.format(getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");

        stringToDate = new DateToStringPropertyCodegen("java.util.Date", "yyyy-MM-dd HH:mm:ss", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "", "user");
        toTarget = stringToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.parse(getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
    }

    @Test
    public void testSqlDate() {
        DateToStringPropertyCodegen dateToString =
            new DateToStringPropertyCodegen("java.sql.Date", "yyyy-MM-dd HH:mm:ss");
        fromTarget = dateToString.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToString.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.parse(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.format(userDto.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");

        DateToStringPropertyCodegen stringToDate =
            new DateToStringPropertyCodegen("java.sql.Date", "yyyy-MM-dd HH:mm:ss", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.parse(userDto.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");

        dateToString = new DateToStringPropertyCodegen("java.sql.Date", "yyyy-MM-dd HH:mm:ss");
        fromTarget = dateToString.generateFromTarget("createTime", null, "user");
        toTarget = dateToString.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.parse(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.format(getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");

        stringToDate = new DateToStringPropertyCodegen(
            "java.sql.Date", "yyyy-MM-dd HH:mm:ss", true);
        fromTarget = stringToDate.generateFromTarget("createTime", null, "user");
        toTarget = stringToDate.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.parse(getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"));");
    }
}
