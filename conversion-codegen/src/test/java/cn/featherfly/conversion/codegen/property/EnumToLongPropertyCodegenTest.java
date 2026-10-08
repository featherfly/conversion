package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author zhongj
 */
public class EnumToLongPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void test() {
        String genderClass = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);
        EnumToLongPropertyCodegen enumToLong = new EnumToLongPropertyCodegen(genderClass);
        fromTarget = enumToLong.generateFromTarget("gender", "userDto", "user");
        toTarget = enumToLong.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
            + "    userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
            + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) {\n"
                + "    user.setGender(userDto.getGender().ordinal());\n" //
                + "}");

        EnumToLongPropertyCodegen longToEnum = new EnumToLongPropertyCodegen(genderClass, true);
        fromTarget = longToEnum.generateFromTarget("gender", "userDto", "user");
        toTarget = longToEnum.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    userDto.setGender(user.getGender().ordinal());\n" //
                + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) {\n"
            + "    user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));\n"
            + "}");

        fromTarget = enumToLong.generateFromTarget("gender", "", "user");
        toTarget = enumToLong.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
            + "    setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
            + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) {\n"
                + "    user.setGender(getGender().ordinal());\n" //
                + "}");

        fromTarget = longToEnum.generateFromTarget("gender", "", "user");
        toTarget = longToEnum.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    setGender(user.getGender().ordinal());\n" //
                + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) {\n"
            + "    user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));\n"
            + "}");

    }
}
