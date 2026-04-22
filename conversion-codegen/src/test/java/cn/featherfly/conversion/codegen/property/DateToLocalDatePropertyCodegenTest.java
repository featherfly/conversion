
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-14 14:57:14
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * DateToLocalDatePropertyCodegenTest.
 *
 * @author zhongj
 */
public class DateToLocalDatePropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void testDate() {
        DateToLocalDatePropertyCodegen dateToLocalDate =
            new DateToLocalDatePropertyCodegen("java.util.Date");
        fromTarget = dateToLocalDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLocalDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.toDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(userDto.getCreateTime()));");

        DateToLocalDatePropertyCodegen localDateToDate =
            new DateToLocalDatePropertyCodegen("java.util.Date", true);
        fromTarget = localDateToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = localDateToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toDate(userDto.getCreateTime()));");

        dateToLocalDate = new DateToLocalDatePropertyCodegen("java.util.Date");
        fromTarget = dateToLocalDate.generateFromTarget("createTime", "", "user");
        toTarget = dateToLocalDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.toDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(getCreateTime()));");

        localDateToDate = new DateToLocalDatePropertyCodegen("java.util.Date", true);
        fromTarget = localDateToDate.generateFromTarget("createTime", "", "user");
        toTarget = localDateToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toDate(getCreateTime()));");
    }

    @Test
    public void testSqlDate() {
        DateToLocalDatePropertyCodegen dateToLocalDate =
            new DateToLocalDatePropertyCodegen("java.sql.Date");
        fromTarget = dateToLocalDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLocalDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.toDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(userDto.getCreateTime()));");

        DateToLocalDatePropertyCodegen localDateToDate =
            new DateToLocalDatePropertyCodegen("java.sql.Date", true);
        fromTarget = localDateToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = localDateToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toDate(userDto.getCreateTime()));");

        dateToLocalDate = new DateToLocalDatePropertyCodegen("java.sql.Date");
        fromTarget = dateToLocalDate.generateFromTarget("createTime", null, "user");
        toTarget = dateToLocalDate.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.toDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(getCreateTime()));");

        localDateToDate = new DateToLocalDatePropertyCodegen(
            "java.sql.Date", true);
        fromTarget = localDateToDate.generateFromTarget("createTime", null, "user");
        toTarget = localDateToDate.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.toLocalDate(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.toDate(getCreateTime()));");
    }
}
