
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
 * The Class IterableArrayToListPropertyCodegenTest.
 *
 * @author zhongj
 */
public class IterableArrayToListPropertyCodegenTest extends IterablePropertyCodegenTest {

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void directAssign() {
        final String propertyName = "nameArrayToList";

        DirectAssignConvertorCodegen directAssign = new DirectAssignConvertorCodegen(String.class);

        System.out.println("iterable array to list direct assign");
        IterablePropertyCodegen iterableDirectAssign = new IterablePropertyCodegen(directAssign, Iterables.ARRAY,
            Iterables.LIST);
        toTarget = iterableDirectAssign.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getNameArrayToList())) {\n"
                + "    user.setNameArrayToList(new java.util.ArrayList<>(userDto.getNameArrayToList().length));\n"
                + "    for (int i = 0; i < userDto.getNameArrayToList().length; i++) {\n"
                + "        String nameArrayToListElement = userDto.getNameArrayToList()[i];\n"
                + "        if (nameArrayToListElement == null) {\n" //
                + "            user.getNameArrayToList().add({null});\n" //
                + "            continue;\n" //
                + "        }\n" //
                + "        user.getNameArrayToList().add(nameArrayToListElement);\n"//
                + "    }\n" // 
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArrayToList())) {\n"
                + "    userDto.setNameArrayToList(new String[user.getNameArrayToList().size()]);\n"//
                + "    int i = 0;\n"//
                + "    for (String nameArrayToListElement : user.getNameArrayToList()) {\n"
                + "        if (nameArrayToListElement == null) continue;\n"
                + "        userDto.getNameArrayToList()[i] = nameArrayToListElement;\n"//
                + "        i++;\n"//
                + "    }\n"//
                + "}");

        System.out.println("iterable  array to list direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getNameArrayToList())) {\n"
                + "    user.setNameArrayToList(new java.util.ArrayList<>(getNameArrayToList().length));\n"
                + "    for (int i = 0; i < getNameArrayToList().length; i++) {\n"
                + "        String nameArrayToListElement = getNameArrayToList()[i];\n"
                + "        if (nameArrayToListElement == null) {\n" //
                + "            user.getNameArrayToList().add({null});\n"//
                + "            continue;\n"//
                + "        }\n"//
                + "        user.getNameArrayToList().add(nameArrayToListElement);\n"//
                + "    }\n"//
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArrayToList())) {\n"
                + "    setNameArrayToList(new String[user.getNameArrayToList().size()]);\n"//
                + "    int i = 0;\n"//
                + "    for (String nameArrayToListElement : user.getNameArrayToList()) {\n"
                + "        if (nameArrayToListElement == null) continue;\n" //
                + "        getNameArrayToList()[i] = nameArrayToListElement;\n"//
                + "        i++;\n"//
                + "    }\n"//
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
        IterablePropertyCodegen iterableDirectAssign = new IterablePropertyCodegen(directAssign, Iterables.ARRAY,
            Iterables.LIST);
        toTarget = iterableDirectAssign.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAgeArrayToListPrimitiveType())) {\n"
                + "    user.setAgeArrayToListPrimitiveType(new java.util.ArrayList<>(userDto.getAgeArrayToListPrimitiveType().length));\n"
                + "    for (int i = 0; i < userDto.getAgeArrayToListPrimitiveType().length; i++) {\n"
                + "        int ageArrayToListPrimitiveTypeElement = userDto.getAgeArrayToListPrimitiveType()[i];\n"
                + "        user.getAgeArrayToListPrimitiveType().add(ageArrayToListPrimitiveTypeElement);\n"//
                + "    }\n"//
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayToListPrimitiveType())) {\n"
                + "    userDto.setAgeArrayToListPrimitiveType(new int[user.getAgeArrayToListPrimitiveType().size()]);\n"
                + "    int i = 0;\n"
                + "    for (int ageArrayToListPrimitiveTypeElement : user.getAgeArrayToListPrimitiveType()) {\n"
                + "        if (ageArrayToListPrimitiveTypeElement == null) continue;\n"
                + "        userDto.getAgeArrayToListPrimitiveType()[i] = ageArrayToListPrimitiveTypeElement;\n"
                + "        i++;\n"//
                + "    }\n"//
                + "}");

        System.out.println("iterable direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getAgeArrayToListPrimitiveType())) {\n"
            + "    user.setAgeArrayToListPrimitiveType(new java.util.ArrayList<>(getAgeArrayToListPrimitiveType().length));\n"
            + "    for (int i = 0; i < getAgeArrayToListPrimitiveType().length; i++) {\n"
            + "        int ageArrayToListPrimitiveTypeElement = getAgeArrayToListPrimitiveType()[i];\n"
            + "        user.getAgeArrayToListPrimitiveType().add(ageArrayToListPrimitiveTypeElement);\n"//
            + "    }\n"//
            + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayToListPrimitiveType())) {\n"
                + "    setAgeArrayToListPrimitiveType(new int[user.getAgeArrayToListPrimitiveType().size()]);\n"
                + "    int i = 0;\n"
                + "    for (int ageArrayToListPrimitiveTypeElement : user.getAgeArrayToListPrimitiveType()) {\n"
                + "        if (ageArrayToListPrimitiveTypeElement == null) continue;\n"
                + "        getAgeArrayToListPrimitiveType()[i] = ageArrayToListPrimitiveTypeElement;\n"
                + "        i++;\n"//
                + "    }\n"//
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
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(enumToEnum, Iterables.ARRAY,
            Iterables.LIST);

        System.out.println("iterable enum to enum");
        fromTarget = iterableEnumToEnum.generateFromTarget("genderList", "userDto", "user");
        toTarget = iterableEnumToEnum.generateToTarget("genderList", "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderList())) {\n"
            + "    user.setGenderList(new java.util.ArrayList<>(userDto.getGenderList().length));\n"
            + "    for (int i = 0; i < userDto.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.Gender genderListElement = userDto.getGenderList()[i];\n"
            + "        if (genderListElement == null) {\n" //
            + "            user.getGenderList().add({null});\n"//
            + "            continue;\n"//
            + "        }\n"//
            + "        user.getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement));\n"
            + "    }\n"//
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    userDto.setGenderList(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderList().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderListElement : user.getGenderList()) {\n"
            + "        if (genderListElement == null) continue;\n"
            + "        userDto.getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement);\n"
            + "        i++;\n"//
            + "    }\n"//
            + "}");

        System.out.println("iterable enum to enum");
        fromTarget = iterableEnumToEnum.generateFromTarget("genderList", null, "user");
        toTarget = iterableEnumToEnum.generateToTarget("genderList", null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderList())) {\n"
            + "    user.setGenderList(new java.util.ArrayList<>(getGenderList().length));\n"
            + "    for (int i = 0; i < getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.Gender genderListElement = getGenderList()[i];\n"
            + "        if (genderListElement == null) {\n" + "            user.getGenderList().add({null});\n"//
            + "            continue;\n"//
            + "        }\n"//
            + "        user.getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement));\n"
            + "    }\n"//
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    setGenderList(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderList().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderListElement : user.getGenderList()) {\n"
            + "        if (genderListElement == null) continue;\n"
            + "        getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement);\n"
            + "        i++;\n"//
            + "    }\n"//
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
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(enumToString, Iterables.ARRAY,
            Iterables.LIST);

        System.out.println("iterable enum to string");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderArray())) {\n"
            + "    user.setGenderArray(new java.util.ArrayList<>(userDto.getGenderArray().length));\n"
            + "    for (int i = 0; i < userDto.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.Gender genderArrayElement = userDto.getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) {\n" //
            + "            user.getGenderArray().add({null});\n"//
            + "            continue;\n"//
            + "        }\n"//
            + "        user.getGenderArray().add(genderArrayElement.name());\n"//
            + "    }\n"//
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderArray().size()]);\n"
            + "    int i = 0;\n"//
            + "    for (String genderArrayElement : user.getGenderArray()) {\n"
            + "        if (genderArrayElement == null) continue;\n" //
            + "        userDto.getGenderArray()[i] = cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderArrayElement);\n"
            + "        i++;\n"//
            + "    }\n"//
            + "}");

        System.out.println("iterable enum to string with constructor");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "user");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderArray())) {\n"
                + "    user.setGenderArray(new java.util.ArrayList<>(getGenderArray().length));\n"
                + "    for (int i = 0; i < getGenderArray().length; i++) {\n"
                + "        cn.featherfly.conversion.codegen.vo.Gender genderArrayElement = getGenderArray()[i];\n"
                + "        if (genderArrayElement == null) {\n" //
                + "            user.getGenderArray().add({null});\n"//
                + "            continue;\n"//
                + "        }\n"//
                + "        user.getGenderArray().add(genderArrayElement.name());\n"//
                + "    }\n"//
                + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderArray().size()]);\n"
            + "    int i = 0;\n"//
            + "    for (String genderArrayElement : user.getGenderArray()) {\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        getGenderArray()[i] = cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderArrayElement);\n"
            + "        i++;\n"//
            + "    }\n"//
            + "}");

        // --------------------------
        System.out.println("iterable string to enum");

        EnumToStringConvertorCodegen stringToEnum = new EnumToStringConvertorCodegen(userGender, true);
        iterableEnumToEnum = new IterablePropertyCodegen(stringToEnum, Iterables.ARRAY, Iterables.LIST);

        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderArray())) {\n"
            + "    user.setGenderArray(new java.util.ArrayList<>(userDto.getGenderArray().length));\n"
            + "    for (int i = 0; i < userDto.getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = userDto.getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) {\n" //
            + "            user.getGenderArray().add({null});\n"//
            + "            continue;\n"//
            + "        }\n"//
            + "        user.getGenderArray().add(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement));\n"
            + "    }\n"//
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new String[user.getGenderArray().size()]);\n"//
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement : user.getGenderArray()) {\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        userDto.getGenderArray()[i] = genderArrayElement.name();\n"//
            + "        i++;\n"//
            + "    }\n"//
            + "}");

        System.out.println("iterable string to enum with constructor");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderArray())) {\n"
            + "    user.setGenderArray(new java.util.ArrayList<>(getGenderArray().length));\n"
            + "    for (int i = 0; i < getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) {\n" //
            + "            user.getGenderArray().add({null});\n"//
            + "            continue;\n"//
            + "        }\n"//
            + "        user.getGenderArray().add(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement));\n"
            + "    }\n"//
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new String[user.getGenderArray().size()]);\n"//
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement : user.getGenderArray()) {\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        getGenderArray()[i] = genderArrayElement.name();\n"//
            + "        i++;\n"//
            + "    }\n"//
            + "}");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void beanToBean() {
        final String propertyName = "userArray";
        BeanToBeanConvertorCodegen beanToBean = new BeanToBeanConvertorCodegen(iterableElementBeanCodegen,
            UserDto.class, User.class, 0);
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(beanToBean, Iterables.ARRAY,
            Iterables.LIST);

        System.out.println("iterable bean to bean (UserDto -> User);");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "roleDto", "role");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "roleDto", "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(roleDto.getUserArray())) {\n"
            + "    role.setUserArray(new java.util.ArrayList<>(roleDto.getUserArray().length));\n"
            + "    for (int i = 0; i < roleDto.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto userArrayElement = roleDto.getUserArray()[i];\n"
            + "        if (userArrayElement == null) {\n" // 
            + "            role.getUserArray().add({null});\n"//
            + "            continue;\n"//
            + "        }\n"//
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) role.getUserArray()[i].setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) role.getUserArray()[i].setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) role.getUserArray()[i].setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) role.getUserArray()[i].setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAvailable())) role.getUserArray()[i].setAvailable(userArrayElement.getAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) role.getUserArray()[i].setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) role.getUserArray()[i].setRegisterTime(cn.featherfly.common.lang.Dates.parse(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) role.getUserArray()[i].setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) role.getUserArray()[i].setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) role.getUserArray()[i].setEndTime(cn.featherfly.common.lang.Dates.toDate(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) role.getUserArray()[i].setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) role.getUserArray()[i].setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) role.getUserArray()[i].setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) role.getUserArray()[i].setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) role.getUserArray()[i].setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) role.getUserArray()[i].setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) role.getUserArray()[i].setDouble2BigDecimal(userArrayElement.getDouble2BigDecimal().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) role.getUserArray()[i].setDouble2BigDecimal2(userArrayElement.getDouble2BigDecimal2().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) role.getUserArray()[i].setLong2BigDecimal(userArrayElement.getLong2BigDecimal().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) role.getUserArray()[i].setLong2BigDecimal2(userArrayElement.getLong2BigDecimal2().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) role.getUserArray()[i].setLong2BigInteger(userArrayElement.getLong2BigInteger().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) role.getUserArray()[i].setLong2BigInteger2(userArrayElement.getLong2BigInteger2().longValue());\n"//
            + "    }\n"//
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    roleDto.setUserArray(new cn.featherfly.conversion.codegen.vo.UserDto[role.getUserArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User userArrayElement : role.getUserArray()) {\n"
            + "        if (userArrayElement == null) continue;\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) roleDto.getUserArray()[i].setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) roleDto.getUserArray()[i].setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) roleDto.getUserArray()[i].setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) roleDto.getUserArray()[i].setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.isAvailable())) roleDto.getUserArray()[i].setAvailable(userArrayElement.isAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) roleDto.getUserArray()[i].setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) roleDto.getUserArray()[i].setRegisterTime(cn.featherfly.common.lang.Dates.format(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) roleDto.getUserArray()[i].setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) roleDto.getUserArray()[i].setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) roleDto.getUserArray()[i].setEndTime(cn.featherfly.common.lang.Dates.toLocalDateTime(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) roleDto.getUserArray()[i].setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) roleDto.getUserArray()[i].setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) roleDto.getUserArray()[i].setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) roleDto.getUserArray()[i].setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) roleDto.getUserArray()[i].setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) roleDto.getUserArray()[i].setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) roleDto.getUserArray()[i].setDouble2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) roleDto.getUserArray()[i].setDouble2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) roleDto.getUserArray()[i].setLong2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) roleDto.getUserArray()[i].setLong2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) roleDto.getUserArray()[i].setLong2BigInteger(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) roleDto.getUserArray()[i].setLong2BigInteger2(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger2()));\n"
            + "        i++;\n"//
            + "    }\n"//
            + "}");

        System.out.println("iterable bean to bean (UserDto -> User) with construct");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "role");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getUserArray())) {\n"
            + "    role.setUserArray(new java.util.ArrayList<>(getUserArray().length));\n"
            + "    for (int i = 0; i < getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto userArrayElement = getUserArray()[i];\n"
            + "        if (userArrayElement == null) {\n" + "            role.getUserArray().add({null});\n"
            + "            continue;\n" + "        }\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) role.getUserArray()[i].setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) role.getUserArray()[i].setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) role.getUserArray()[i].setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) role.getUserArray()[i].setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAvailable())) role.getUserArray()[i].setAvailable(userArrayElement.getAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) role.getUserArray()[i].setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) role.getUserArray()[i].setRegisterTime(cn.featherfly.common.lang.Dates.parse(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) role.getUserArray()[i].setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) role.getUserArray()[i].setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) role.getUserArray()[i].setEndTime(cn.featherfly.common.lang.Dates.toDate(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) role.getUserArray()[i].setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) role.getUserArray()[i].setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) role.getUserArray()[i].setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) role.getUserArray()[i].setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) role.getUserArray()[i].setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) role.getUserArray()[i].setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) role.getUserArray()[i].setDouble2BigDecimal(userArrayElement.getDouble2BigDecimal().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) role.getUserArray()[i].setDouble2BigDecimal2(userArrayElement.getDouble2BigDecimal2().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) role.getUserArray()[i].setLong2BigDecimal(userArrayElement.getLong2BigDecimal().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) role.getUserArray()[i].setLong2BigDecimal2(userArrayElement.getLong2BigDecimal2().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) role.getUserArray()[i].setLong2BigInteger(userArrayElement.getLong2BigInteger().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) role.getUserArray()[i].setLong2BigInteger2(userArrayElement.getLong2BigInteger2().longValue());\n"
            + "    }\n"//
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    setUserArray(new cn.featherfly.conversion.codegen.vo.UserDto[role.getUserArray().size()]);\n"
            + "    int i = 0;\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User userArrayElement : role.getUserArray()) {\n"
            + "        if (userArrayElement == null) continue;\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) getUserArray()[i].setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) getUserArray()[i].setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) getUserArray()[i].setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) getUserArray()[i].setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.isAvailable())) getUserArray()[i].setAvailable(userArrayElement.isAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) getUserArray()[i].setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) getUserArray()[i].setRegisterTime(cn.featherfly.common.lang.Dates.format(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) getUserArray()[i].setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) getUserArray()[i].setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) getUserArray()[i].setEndTime(cn.featherfly.common.lang.Dates.toLocalDateTime(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) getUserArray()[i].setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) getUserArray()[i].setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) getUserArray()[i].setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) getUserArray()[i].setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) getUserArray()[i].setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) getUserArray()[i].setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) getUserArray()[i].setDouble2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) getUserArray()[i].setDouble2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) getUserArray()[i].setLong2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) getUserArray()[i].setLong2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) getUserArray()[i].setLong2BigInteger(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) getUserArray()[i].setLong2BigInteger2(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger2()));\n"
            + "        i++;\n"//
            + "    }\n"//
            + "}");

    }
}
