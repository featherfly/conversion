
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-13 14:32:13
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * EnumToIntPropertyCodegenTest.
 *
 * @author zhongj
 */
public class EnumToIntPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void test() {
        String genderClass = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);
        EnumToIntPropertyCodegen enumToInt =
            new EnumToIntPropertyCodegen(genderClass);
        fromTarget = enumToInt.generateFromTarget("gender", "userDto", "user");
        toTarget = enumToInt.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(userDto.getGender().ordinal())");

        EnumToIntPropertyCodegen intToEnum = new EnumToIntPropertyCodegen(
            genderClass, true);
        fromTarget = intToEnum.generateFromTarget("gender", "userDto", "user");
        toTarget = intToEnum.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(user.getGender().ordinal())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()))");

        System.out.println();

        fromTarget = enumToInt.generateFromTarget("gender", "", "user");
        toTarget = enumToInt.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()))");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(getGender().ordinal())");

        fromTarget = intToEnum.generateFromTarget("gender", "", "user");
        toTarget = intToEnum.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(user.getGender().ordinal())");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()))");
    }
}
