
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-21 19:03:21
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.Iterables;
import cn.featherfly.conversion.codegen.convertor.BeanToBeanConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.DirectAssignConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToEnumConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToStringConvertorCodegen;
import cn.featherfly.conversion.codegen.domain.User;
import cn.featherfly.conversion.codegen.vo.UserDto;

/**
 * IterableArrayPropertyCodegenTest.
 *
 * @author zhongj
 */
public class IterableArrayPropertyCodegenTest extends IterablePropertyCodegenTest {

    @Override
    @Test
    public void directAssign() {
        final String propertyName = "nameArray";

        DirectAssignConvertorCodegen directAssign = new DirectAssignConvertorCodegen(String.class);

        System.out.println("iterable direct assign");
        IterablePropertyCodegen iterableDirectAssign = new IterablePropertyCodegen(directAssign, Iterables.ARRAY);
        toTarget = iterableDirectAssign.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getNameArray())) {\n"
            + "    user.setNameArray(new String[userDto.getNameArray().length]);\n"
            + "    for (int i = 0; i < userDto.getNameArray().length; i++) {\n"
            + "        String nameArrayElement = userDto.getNameArray()[i];\n"
            + "        if (nameArrayElement != null) {\n"
            + "            user.getNameArray[i] = nameArrayElement;\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArray())) {\n"
            + "    userDto.setNameArray(new String[user.getNameArray().length]);\n"
            + "    for (int i = 0; i < user.getNameArray().length; i++) {\n"
            + "        String nameArrayElement = user.getNameArray()[i];\n"
            + "        if (nameArrayElement != null) {\n"
            + "            userDto.getNameArray()[i] = nameArrayElement;\n"
            + "        }\n"
            + "    }\n"
            + "}");

        directAssign = new DirectAssignConvertorCodegen("java.lang.String");
        iterableDirectAssign = new IterablePropertyCodegen(directAssign, Iterables.ARRAY);
        System.out.println("iterable direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getNameArray())) {\n"
            + "    user.setNameArray(new java.lang.String[getNameArray().length]);\n"
            + "    for (int i = 0; i < getNameArray().length; i++) {\n"
            + "        java.lang.String nameArrayElement = getNameArray()[i];\n"
            + "        if (nameArrayElement != null) {\n"
            + "            user.getNameArray[i] = nameArrayElement;\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArray())) {\n"
            + "    setNameArray(new java.lang.String[user.getNameArray().length]);\n"
            + "    for (int i = 0; i < user.getNameArray().length; i++) {\n"
            + "        java.lang.String nameArrayElement = user.getNameArray()[i];\n"
            + "        if (nameArrayElement != null) {\n"
            + "            getNameArray()[i] = nameArrayElement;\n"
            + "        }\n"
            + "    }\n"
            + "}");
    }

    @Override
    @Test
    public void directAssignPrimitiveType() {
        final String propertyName = "ageArrayPrimitiveType";

        DirectAssignConvertorCodegen directAssign = new DirectAssignConvertorCodegen(int.class);

        System.out.println("iterable direct assign");
        IterablePropertyCodegen iterableDirectAssign = new IterablePropertyCodegen(directAssign, Iterables.ARRAY);
        toTarget = iterableDirectAssign.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAgeArrayPrimitiveType())) {\n"
            + "    user.setAgeArrayPrimitiveType(new int[userDto.getAgeArrayPrimitiveType().length]);\n"
            + "    for (int i = 0; i < userDto.getAgeArrayPrimitiveType().length; i++) {\n"
            + "        int ageArrayPrimitiveTypeElement = userDto.getAgeArrayPrimitiveType()[i];\n"
            + "        user.getAgeArrayPrimitiveType[i] = ageArrayPrimitiveTypeElement;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayPrimitiveType())) {\n"
            + "    userDto.setAgeArrayPrimitiveType(new int[user.getAgeArrayPrimitiveType().length]);\n"
            + "    for (int i = 0; i < user.getAgeArrayPrimitiveType().length; i++) {\n"
            + "        int ageArrayPrimitiveTypeElement = user.getAgeArrayPrimitiveType()[i];\n"
            + "        userDto.getAgeArrayPrimitiveType()[i] = ageArrayPrimitiveTypeElement;\n"
            + "    }\n"
            + "}");

        System.out.println("iterable direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getAgeArrayPrimitiveType())) {\n"
            + "    user.setAgeArrayPrimitiveType(new int[getAgeArrayPrimitiveType().length]);\n"
            + "    for (int i = 0; i < getAgeArrayPrimitiveType().length; i++) {\n"
            + "        int ageArrayPrimitiveTypeElement = getAgeArrayPrimitiveType()[i];\n"
            + "        user.getAgeArrayPrimitiveType[i] = ageArrayPrimitiveTypeElement;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayPrimitiveType())) {\n"
            + "    setAgeArrayPrimitiveType(new int[user.getAgeArrayPrimitiveType().length]);\n"
            + "    for (int i = 0; i < user.getAgeArrayPrimitiveType().length; i++) {\n"
            + "        int ageArrayPrimitiveTypeElement = user.getAgeArrayPrimitiveType()[i];\n"
            + "        getAgeArrayPrimitiveType()[i] = ageArrayPrimitiveTypeElement;\n"
            + "    }\n"
            + "}");
    }

    @Override
    @Test
    public void enumToEnum() {
        String domainGender = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);
        String voGender = getClassName(cn.featherfly.conversion.codegen.vo.Gender.class);

        EnumToEnumConvertorCodegen enumToEnum = new EnumToEnumConvertorCodegen(voGender, domainGender);
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(enumToEnum, Iterables.ARRAY);

        System.out.println("iterable enum to enum");
        fromTarget = iterableEnumToEnum.generateFromTarget("genderList", "userDto", "user");
        toTarget = iterableEnumToEnum.generateToTarget("genderList", "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderList())) {\n"
            + "    user.setGenderList(new cn.featherfly.conversion.codegen.domain.User.Gender[userDto.getGenderList().length]);\n"
            + "    for (int i = 0; i < userDto.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.Gender genderListElement = userDto.getGenderList()[i];\n"
            + "        if (genderListElement != null) {\n"
            + "            user.getGenderList[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    userDto.setGenderList(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderList().length]);\n"
            + "    for (int i = 0; i < user.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderListElement = user.getGenderList()[i];\n"
            + "        if (genderListElement != null) {\n"
            + "            userDto.getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");

        System.out.println("iterable enum to enum");
        fromTarget = iterableEnumToEnum.generateFromTarget("genderList", null, "user");
        toTarget = iterableEnumToEnum.generateToTarget("genderList", null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderList())) {\n"
            + "    user.setGenderList(new cn.featherfly.conversion.codegen.domain.User.Gender[getGenderList().length]);\n"
            + "    for (int i = 0; i < getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.Gender genderListElement = getGenderList()[i];\n"
            + "        if (genderListElement != null) {\n"
            + "            user.getGenderList[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    setGenderList(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderList().length]);\n"
            + "    for (int i = 0; i < user.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderListElement = user.getGenderList()[i];\n"
            + "        if (genderListElement != null) {\n"
            + "            getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");
    }

    @Override
    @Test
    public void enumToString() {
        final String propertyName = "genderArray";
        String voGender = getClassName(cn.featherfly.conversion.codegen.vo.Gender.class);
        String userGender = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);

        EnumToStringConvertorCodegen enumToString = new EnumToStringConvertorCodegen(voGender);
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(enumToString, Iterables.LIST);

        System.out.println("iterable enum to string");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderArray())) {\n"
            + "    user.setGenderArray(new java.util.ArrayList<>(userDto.getGenderArray().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderArrayElement : userDto.getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray().add(genderArrayElement.name());\n"
            + "        } else {\n"
            + "            user.getGenderArray().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new java.util.ArrayList<>(user.getGenderArray().size()));\n"
            + "    for (String genderArrayElement : user.getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            userDto.getGenderArray().add(cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderArrayElement));\n"
            + "        } else {\n"
            + "            userDto.getGenderArray().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");

        System.out.println("iterable enum to string with constructor");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "user");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderArray())) {\n"
            + "    user.setGenderArray(new java.util.ArrayList<>(getGenderArray().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderArrayElement : getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray().add(genderArrayElement.name());\n"
            + "        } else {\n"
            + "            user.getGenderArray().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new java.util.ArrayList<>(user.getGenderArray().size()));\n"
            + "    for (String genderArrayElement : user.getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            getGenderArray().add(cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderArrayElement));\n"
            + "        } else {\n"
            + "            getGenderArray().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");

        // --------------------------
        System.out.println("iterable string to enum");

        EnumToStringConvertorCodegen stringToEnum = new EnumToStringConvertorCodegen(userGender, true);
        iterableEnumToEnum = new IterablePropertyCodegen(stringToEnum, Iterables.ARRAY);

        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderArray())) {\n"
            + "    user.setGenderArray(new cn.featherfly.conversion.codegen.domain.User.Gender[userDto.getGenderArray().length]);\n"
            + "    for (int i = 0; i < userDto.getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = userDto.getGenderArray()[i];\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray[i] = cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new String[user.getGenderArray().length]);\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement != null) {\n"
            + "            userDto.getGenderArray()[i] = genderArrayElement.name();\n"
            + "        }\n"
            + "    }\n"
            + "}");

        System.out.println("iterable string to enum with constructor");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderArray())) {\n"
            + "    user.setGenderArray(new cn.featherfly.conversion.codegen.domain.User.Gender[getGenderArray().length]);\n"
            + "    for (int i = 0; i < getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = getGenderArray()[i];\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray[i] = cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new String[user.getGenderArray().length]);\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement != null) {\n"
            + "            getGenderArray()[i] = genderArrayElement.name();\n"
            + "        }\n"
            + "    }\n"
            + "}");
    }

    @Override
    @Test
    public void beanToBean() {
        final String propertyName = "userArray";
        BeanToBeanConvertorCodegen beanToBean = new BeanToBeanConvertorCodegen(UserDto.class, User.class);
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(beanToBean, Iterables.ARRAY);

        System.out.println("iterable bean to bean (UserDto -> User);");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "roleDto", "role");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "roleDto", "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(roleDto.getUserArray())) {\n"
            + "    role.setUserArray(new cn.featherfly.conversion.codegen.domain.User[roleDto.getUserArray().length]);\n"
            + "    for (int i = 0; i < roleDto.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto userArrayElement = roleDto.getUserArray()[i];\n"
            + "        if (userArrayElement != null) {\n"
            + "            role.getUserArray[i] = userArrayElement.toUser();\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    roleDto.setUserArray(new cn.featherfly.conversion.codegen.vo.UserDto[role.getUserArray().length]);\n"
            + "    for (int i = 0; i < role.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User userArrayElement = role.getUserArray()[i];\n"
            + "        if (userArrayElement != null) {\n"
            + "            roleDto.getUserArray()[i] = new cn.featherfly.conversion.codegen.vo.UserDto(userArrayElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");

        System.out.println("iterable bean to bean (UserDto -> User) with construct");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "role");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getUserArray())) {\n"
            + "    role.setUserArray(new cn.featherfly.conversion.codegen.domain.User[getUserArray().length]);\n"
            + "    for (int i = 0; i < getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto userArrayElement = getUserArray()[i];\n"
            + "        if (userArrayElement != null) {\n"
            + "            role.getUserArray[i] = userArrayElement.toUser();\n"
            + "        }\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    setUserArray(new cn.featherfly.conversion.codegen.vo.UserDto[role.getUserArray().length]);\n"
            + "    for (int i = 0; i < role.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User userArrayElement = role.getUserArray()[i];\n"
            + "        if (userArrayElement != null) {\n"
            + "            getUserArray()[i] = new cn.featherfly.conversion.codegen.vo.UserDto(userArrayElement);\n"
            + "        }\n"
            + "    }\n"
            + "}");

    }
}
