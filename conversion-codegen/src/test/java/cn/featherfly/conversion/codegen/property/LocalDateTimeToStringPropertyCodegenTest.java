
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
 * LocalDateTimeToStringPropertyCodegenTest.
 *
 * @author zhongj
 */
public class LocalDateTimeToStringPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void testDefaultFormat() {
        LocalDateTimeToStringPropertyCodegen dateToString =
            new LocalDateTimeToStringPropertyCodegen();
        fromTarget = dateToString.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToString.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDateTime(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.formatDateTime(userDto.getCreateTime()))");

        LocalDateTimeToStringPropertyCodegen stringToDate = new LocalDateTimeToStringPropertyCodegen(true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.formatDateTime(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDateTime(userDto.getCreateTime()))");

        dateToString = new LocalDateTimeToStringPropertyCodegen();
        fromTarget = dateToString.generateFromTarget("createTime", null, "user");
        toTarget = dateToString.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDateTime(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.formatDateTime(getCreateTime()))");

        stringToDate = new LocalDateTimeToStringPropertyCodegen(true);
        fromTarget = stringToDate.generateFromTarget("createTime", null, "user");
        toTarget = stringToDate.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.formatDateTime(user.getCreateTime()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.parseLocalDateTime(getCreateTime()))");
    }

    @Test
    public void testWithFormat() {
        LocalDateTimeToStringPropertyCodegen dateToString =
            new LocalDateTimeToStringPropertyCodegen("yyyy-MM-dd HH:mm:ss");
        fromTarget = dateToString.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToString.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(java.time.LocalDateTime.parse(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.format(userDto.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");

        LocalDateTimeToStringPropertyCodegen stringToDate =
            new LocalDateTimeToStringPropertyCodegen("yyyy-MM-dd HH:mm:ss", true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(java.time.LocalDateTime.parse(userDto.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");

        dateToString = new LocalDateTimeToStringPropertyCodegen("yyyy-MM-dd HH:mm:ss");
        fromTarget = dateToString.generateFromTarget("createTime", null, "user");
        toTarget = dateToString.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(java.time.LocalDateTime.parse(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(cn.featherfly.common.lang.Dates.format(getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");

        stringToDate = new LocalDateTimeToStringPropertyCodegen("yyyy-MM-dd HH:mm:ss", true);
        fromTarget = stringToDate.generateFromTarget("createTime", null, "user");
        toTarget = stringToDate.generateToTarget("createTime", null, "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(cn.featherfly.common.lang.Dates.format(user.getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(java.time.LocalDateTime.parse(getCreateTime(), \"yyyy-MM-dd HH:mm:ss\"))");
    }

}
