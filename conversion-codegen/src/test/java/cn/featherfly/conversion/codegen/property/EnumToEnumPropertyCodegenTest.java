
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-13 14:16:13
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * EnumToEnumPropertyCodegenTest.
 *
 * @author zhongj
 */
public class EnumToEnumPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void test() {
        String domainGender = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);
        String voGender = getClassName(cn.featherfly.conversion.codegen.vo.Gender.class);
        EnumToEnumPropertyCodegen enumToEnum = new EnumToEnumPropertyCodegen(voGender, domainGender);
        fromTarget = enumToEnum.generateFromTarget("gender", "userDto", "user");
        toTarget = enumToEnum.generateToTarget("gender", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));");

        fromTarget = enumToEnum.generateFromTarget("gender", "", "user");
        toTarget = enumToEnum.generateToTarget("gender", "", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));");
    }
}
