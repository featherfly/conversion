
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
 * The Class IterableListToArrayPropertyCodegenTest.
 *
 * @author zhongj
 */
public class IterableListToArrayPropertyCodegenTest extends IterablePropertyCodegenTest {

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void directAssign() {
        final String propertyName = "nameArrayToList";

        DirectAssignConvertorCodegen directAssign = new DirectAssignConvertorCodegen(String.class);

        System.out.println("iterable array to list direct assign");
        IterablePropertyCodegen iterableDirectAssign =
            new IterablePropertyCodegen(directAssign, Iterables.LIST, Iterables.ARRAY);
        toTarget = iterableDirectAssign.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getNameArrayToList())) {\n"
            + "    user.setNameArrayToList(new String[userDto.getNameArrayToList().size()]);\n"
            + "    int i = 0;\n"
            + "    for (String nameArrayToListElement : userDto.getNameArrayToList()) {\n"
            + "        if (nameArrayToListElement != null) {\n"
            + "            user.getNameArrayToList()[i] = nameArrayToListElement;\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArrayToList())) {\n"
            + "    userDto.setNameArrayToList(new java.util.ArrayList<>(user.getNameArrayToList().length));\n"
            + "    for (int i = 0; i < user.getNameArrayToList().length; i++) {\n"
            + "        String nameArrayToListElement = user.getNameArrayToList()[i];\n"
            + "        if (nameArrayToListElement != null) {\n"
            + "            userDto.getNameArrayToList().add(nameArrayToListElement);\n"
            + "        } else {\n"
            + "            userDto.getNameArrayToList().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");

        System.out.println("iterable  array to list direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getNameArrayToList())) {\n"
            + "    user.setNameArrayToList(new String[getNameArrayToList().size()]);\n"
            + "    int i = 0;\n"
            + "    for (String nameArrayToListElement : getNameArrayToList()) {\n"
            + "        if (nameArrayToListElement != null) {\n"
            + "            user.getNameArrayToList()[i] = nameArrayToListElement;\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArrayToList())) {\n"
            + "    setNameArrayToList(new java.util.ArrayList<>(user.getNameArrayToList().length));\n"
            + "    for (int i = 0; i < user.getNameArrayToList().length; i++) {\n"
            + "        String nameArrayToListElement = user.getNameArrayToList()[i];\n"
            + "        if (nameArrayToListElement != null) {\n"
            + "            getNameArrayToList().add(nameArrayToListElement);\n"
            + "        } else {\n"
            + "            getNameArrayToList().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void directAssignPrimitiveType() {
        final String propertyName = "ageArrayToListPrimitiveType";

        DirectAssignConvertorCodegen directAssign = new DirectAssignConvertorCodegen(int.class);

        System.out.println("iterable direct assign");
        IterablePropertyCodegen iterableDirectAssign =
            new IterablePropertyCodegen(directAssign, Iterables.LIST, Iterables.ARRAY);
        toTarget = iterableDirectAssign.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAgeArrayToListPrimitiveType())) {\n"
                + "    user.setAgeArrayToListPrimitiveType(new int[userDto.getAgeArrayToListPrimitiveType().size()]);\n"
                + "    int i = 0;\n"
                + "    for (int ageArrayToListPrimitiveTypeElement : userDto.getAgeArrayToListPrimitiveType()) {\n"
                + "        if (ageArrayToListPrimitiveTypeElement != null) {\n"
                + "            user.getAgeArrayToListPrimitiveType()[i] = ageArrayToListPrimitiveTypeElement;\n"
                + "        }\n"
                + "        i++;\n"
                + "    }\n"
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayToListPrimitiveType())) {\n"
                + "    userDto.setAgeArrayToListPrimitiveType(new java.util.ArrayList<>(user.getAgeArrayToListPrimitiveType().length));\n"
                + "    for (int i = 0; i < user.getAgeArrayToListPrimitiveType().length; i++) {\n"
                + "        int ageArrayToListPrimitiveTypeElement = user.getAgeArrayToListPrimitiveType()[i];\n"
                + "        userDto.getAgeArrayToListPrimitiveType().add(ageArrayToListPrimitiveTypeElement);\n"
                + "    }\n"
                + "}");

        System.out.println("iterable direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getAgeArrayToListPrimitiveType())) {\n"
            + "    user.setAgeArrayToListPrimitiveType(new int[getAgeArrayToListPrimitiveType().size()]);\n"
            + "    int i = 0;\n"
            + "    for (int ageArrayToListPrimitiveTypeElement : getAgeArrayToListPrimitiveType()) {\n"
            + "        if (ageArrayToListPrimitiveTypeElement != null) {\n"
            + "            user.getAgeArrayToListPrimitiveType()[i] = ageArrayToListPrimitiveTypeElement;\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayToListPrimitiveType())) {\n"
                + "    setAgeArrayToListPrimitiveType(new java.util.ArrayList<>(user.getAgeArrayToListPrimitiveType().length));\n"
                + "    for (int i = 0; i < user.getAgeArrayToListPrimitiveType().length; i++) {\n"
                + "        int ageArrayToListPrimitiveTypeElement = user.getAgeArrayToListPrimitiveType()[i];\n"
                + "        getAgeArrayToListPrimitiveType().add(ageArrayToListPrimitiveTypeElement);\n"
                + "    }\n"
                + "}");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void enumToEnum() {
        String domainGender = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);
        String voGender = getClassName(cn.featherfly.conversion.codegen.vo.Gender.class);

        EnumToEnumConvertorCodegen enumToEnum = new EnumToEnumConvertorCodegen(voGender, domainGender);
        IterablePropertyCodegen iterableEnumToEnum =
            new IterablePropertyCodegen(enumToEnum, Iterables.LIST, Iterables.ARRAY);

        System.out.println("iterable enum to enum");
        fromTarget = iterableEnumToEnum.generateFromTarget("genderList", "userDto", "user");
        toTarget = iterableEnumToEnum.generateToTarget("genderList", "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderList())) {\n"
            + "    user.setGenderList(new cn.featherfly.conversion.codegen.domain.User.Gender[userDto.getGenderList().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderListElement : userDto.getGenderList()) {\n"
            + "        if (genderListElement != null) {\n"
            + "            user.getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement);\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    userDto.setGenderList(new java.util.ArrayList<>(user.getGenderList().length));\n"
            + "    for (int i = 0; i < user.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderListElement = user.getGenderList()[i];\n"
            + "        if (genderListElement != null) {\n"
            + "            userDto.getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement));\n"
            + "        } else {\n"
            + "            userDto.getGenderList().add(null);\n"
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
            + "    user.setGenderList(new cn.featherfly.conversion.codegen.domain.User.Gender[getGenderList().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderListElement : getGenderList()) {\n"
            + "        if (genderListElement != null) {\n"
            + "            user.getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement);\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    setGenderList(new java.util.ArrayList<>(user.getGenderList().length));\n"
            + "    for (int i = 0; i < user.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderListElement = user.getGenderList()[i];\n"
            + "        if (genderListElement != null) {\n"
            + "            getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement));\n"
            + "        } else {\n"
            + "            getGenderList().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void enumToString() {
        final String propertyName = "genderArray";
        String voGender = getClassName(cn.featherfly.conversion.codegen.vo.Gender.class);
        String userGender = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);

        EnumToStringConvertorCodegen enumToString = new EnumToStringConvertorCodegen(voGender);
        IterablePropertyCodegen iterableEnumToEnum =
            new IterablePropertyCodegen(enumToString, Iterables.LIST, Iterables.ARRAY);

        System.out.println("iterable enum to string");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderArray())) {\n"
            + "    user.setGenderArray(new String[userDto.getGenderArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderArrayElement : userDto.getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray()[i] = genderArrayElement.name();\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new java.util.ArrayList<>(user.getGenderArray().length));\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = user.getGenderArray()[i];\n"
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
            + "    user.setGenderArray(new String[getGenderArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderArrayElement : getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray()[i] = genderArrayElement.name();\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new java.util.ArrayList<>(user.getGenderArray().length));\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = user.getGenderArray()[i];\n"
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
        iterableEnumToEnum = new IterablePropertyCodegen(stringToEnum, Iterables.LIST, Iterables.ARRAY);

        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderArray())) {\n"
            + "    user.setGenderArray(new cn.featherfly.conversion.codegen.domain.User.Gender[userDto.getGenderArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (String genderArrayElement : userDto.getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray()[i] = cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement);\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new java.util.ArrayList<>(user.getGenderArray().length));\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement != null) {\n"
            + "            userDto.getGenderArray().add(genderArrayElement.name());\n"
            + "        } else {\n"
            + "            userDto.getGenderArray().add(null);\n"
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
            + "    user.setGenderArray(new cn.featherfly.conversion.codegen.domain.User.Gender[getGenderArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (String genderArrayElement : getGenderArray()) {\n"
            + "        if (genderArrayElement != null) {\n"
            + "            user.getGenderArray()[i] = cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement);\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new java.util.ArrayList<>(user.getGenderArray().length));\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement != null) {\n"
            + "            getGenderArray().add(genderArrayElement.name());\n"
            + "        } else {\n"
            + "            getGenderArray().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void beanToBean() {
        final String propertyName = "userArray";
        BeanToBeanConvertorCodegen beanToBean = new BeanToBeanConvertorCodegen(UserDto.class, User.class);
        IterablePropertyCodegen iterableEnumToEnum =
            new IterablePropertyCodegen(beanToBean, Iterables.LIST, Iterables.ARRAY);

        System.out.println("iterable bean to bean (UserDto -> User);");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "roleDto", "role");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "roleDto", "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(roleDto.getUserArray())) {\n"
            + "    role.setUserArray(new cn.featherfly.conversion.codegen.domain.User[roleDto.getUserArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.vo.UserDto userArrayElement : roleDto.getUserArray()) {\n"
            + "        if (userArrayElement != null) {\n"
            + "            role.getUserArray()[i] = userArrayElement.toUser();\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    roleDto.setUserArray(new java.util.ArrayList<>(role.getUserArray().length));\n"
            + "    for (int i = 0; i < role.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User userArrayElement = role.getUserArray()[i];\n"
            + "        if (userArrayElement != null) {\n"
            + "            roleDto.getUserArray().add(new cn.featherfly.conversion.codegen.vo.UserDto(userArrayElement));\n"
            + "        } else {\n"
            + "            roleDto.getUserArray().add(null);\n"
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
            + "    role.setUserArray(new cn.featherfly.conversion.codegen.domain.User[getUserArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.vo.UserDto userArrayElement : getUserArray()) {\n"
            + "        if (userArrayElement != null) {\n"
            + "            role.getUserArray()[i] = userArrayElement.toUser();\n"
            + "        }\n"
            + "        i++;\n"
            + "    }\n"
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    setUserArray(new java.util.ArrayList<>(role.getUserArray().length));\n"
            + "    for (int i = 0; i < role.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User userArrayElement = role.getUserArray()[i];\n"
            + "        if (userArrayElement != null) {\n"
            + "            getUserArray().add(new cn.featherfly.conversion.codegen.vo.UserDto(userArrayElement));\n"
            + "        } else {\n"
            + "            getUserArray().add(null);\n"
            + "        }\n"
            + "    }\n"
            + "}");

    }
}
