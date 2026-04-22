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
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(Long.valueOf(userDto.getGender().ordinal()));");

        EnumToLongWrapperPropertyCodegen longToEnum =
            new EnumToLongWrapperPropertyCodegen(genderClass, true);
        fromTarget = longToEnum.generateFromTarget("gender", "userDto", "user");
        toTarget = longToEnum.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(Long.valueOf(user.getGender().ordinal()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));");

        fromTarget = enumToLong.generateFromTarget("gender", "", "user");
        toTarget = enumToLong.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(Long.valueOf(getGender().ordinal()));");

        fromTarget = longToEnum.generateFromTarget("gender", "", "user");
        toTarget = longToEnum.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(Long.valueOf(user.getGender().ordinal()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));");
    }
}
