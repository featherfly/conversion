
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
        EnumToIntPropertyCodegen enumToInt = new EnumToIntPropertyCodegen(genderClass);
        fromTarget = enumToInt.generateFromTarget("gender", "userDto", "user");
        toTarget = enumToInt.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
            + "    userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
            + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) {\n"
                + "    user.setGender(userDto.getGender().ordinal());\n" //
                + "}");

        EnumToIntPropertyCodegen intToEnum = new EnumToIntPropertyCodegen(genderClass, true);
        fromTarget = intToEnum.generateFromTarget("gender", "userDto", "user");
        toTarget = intToEnum.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    userDto.setGender(user.getGender().ordinal());\n" //
                + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) {\n" //
            + "    user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));\n"
            + "}");

        System.out.println();

        fromTarget = enumToInt.generateFromTarget("gender", "", "user");
        toTarget = enumToInt.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
            + "    setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) {\n" //
            + "    user.setGender(getGender().ordinal());\n" //
            + "}");

        fromTarget = intToEnum.generateFromTarget("gender", "", "user");
        toTarget = intToEnum.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n" //
            + "    setGender(user.getGender().ordinal());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) {\n" //
            + "    user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));\n"
            + "}");
    }
}
