package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author zhongj
 */
public class EnumToLongWrapperPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void test() {
        String genderClass = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);
        EnumToLongWrapperPropertyCodegen enumToLong = new EnumToLongWrapperPropertyCodegen(genderClass);
        fromTarget = enumToLong.generateFromTarget("gender", "userDto", "user");
        toTarget = enumToLong.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
            + "    userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
            + "}");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) {\n"
                + "    user.setGender(Long.valueOf(userDto.getGender().ordinal()));\n" //
                + "}");

        EnumToLongWrapperPropertyCodegen longToEnum = new EnumToLongWrapperPropertyCodegen(genderClass, true);
        fromTarget = longToEnum.generateFromTarget("gender", "userDto", "user");
        toTarget = longToEnum.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    userDto.setGender(Long.valueOf(user.getGender().ordinal()));\n" //
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
                + "    user.setGender(Long.valueOf(getGender().ordinal()));\n" //
                + "}");

        fromTarget = longToEnum.generateFromTarget("gender", "", "user");
        toTarget = longToEnum.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) {\n"
                + "    setGender(Long.valueOf(user.getGender().ordinal()));\n" //
                + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) {\n"
            + "    user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));\n"
            + "}");
    }
}
