
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
 * TimeToLocalTimePropertyCodegenTest.
 *
 * @author zhongj
 */
public class TimeToLocalTimePropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void test() {
        TimeToLocalTimePropertyCodegen dateToLocalDate =
            new TimeToLocalTimePropertyCodegen("java.util.Date");
        fromTarget = dateToLocalDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = dateToLocalDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(java.sql.Time.valueOf(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(userDto.getCreateTime().toLocalTime());");

        TimeToLocalTimePropertyCodegen localDateToDate =
            new TimeToLocalTimePropertyCodegen("java.util.Date", true);
        fromTarget = localDateToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = localDateToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(user.getCreateTime().toLocalTime());");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(java.sql.Time.valueOf(userDto.getCreateTime()));");

        dateToLocalDate = new TimeToLocalTimePropertyCodegen("java.util.Date");
        fromTarget = dateToLocalDate.generateFromTarget("createTime", "", "user");
        toTarget = dateToLocalDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(java.sql.Time.valueOf(user.getCreateTime()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(getCreateTime().toLocalTime());");

        localDateToDate = new TimeToLocalTimePropertyCodegen("java.util.Date", true);
        fromTarget = localDateToDate.generateFromTarget("createTime", "", "user");
        toTarget = localDateToDate.generateToTarget("createTime", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) setCreateTime(user.getCreateTime().toLocalTime());");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getCreateTime())) user.setCreateTime(java.sql.Time.valueOf(getCreateTime()));");
    }
}
