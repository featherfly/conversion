
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-13 14:06:13
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * EnumToStringPropertyCodegenTest.
 *
 * @author zhongj
 */
public class EnumToStringPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void test() {
        String genderClass = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);

        System.out.println("source enum to string");
        EnumToStringPropertyCodegen enumToString = new EnumToStringPropertyCodegen(genderClass);
        fromTarget = enumToString.generateFromTarget("gender", "userDto", "user");
        toTarget = enumToString.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
            + "    userDto.setGender(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(user.getGender()));\n"
            + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) {\n"
                + "    user.setGender(userDto.getGender().name());\n" // 
                + "}");

        System.out.println("source string to enum");
        EnumToStringPropertyCodegen stringToEnum = new EnumToStringPropertyCodegen(
            cn.featherfly.conversion.codegen.domain.User.Gender.class.getName(), true);
        fromTarget = stringToEnum.generateFromTarget("gender", "userDto", "user");
        toTarget = stringToEnum.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    userDto.setGender(user.getGender().name());\n" //
                + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) {\n"
            + "    user.setGender(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(userDto.getGender()));\n"
            + "}");

        System.out.println("source enum to string");
        fromTarget = enumToString.generateFromTarget("gender", "", "user");
        toTarget = enumToString.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    setGender(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(user.getGender()));\n" // 
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) {\n"
                + "    user.setGender(getGender().name());\n" //
                + "}");

        System.out.println("source string to enum");
        fromTarget = stringToEnum.generateFromTarget("gender", "", "user");
        toTarget = stringToEnum.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    setGender(user.getGender().name());\n" //
                + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) {\n"
                + "    user.setGender(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(getGender()));\n" //
                + "}");

    }

}
