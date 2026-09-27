
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
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getNameArray())) {\n"
                + "    user.setNameArray(new String[userDto.getNameArray().length]);\n"
                + "    for (int i = 0; i < userDto.getNameArray().length; i++) {\n"
                + "        String nameArrayElement = userDto.getNameArray()[i];\n"
                + "        if (nameArrayElement == null) continue;\n"
                + "        user.getNameArray()[i] = nameArrayElement;\n" //
                + "    }\n" //
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArray())) {\n"
                + "    userDto.setNameArray(new String[user.getNameArray().length]);\n"
                + "    for (int i = 0; i < user.getNameArray().length; i++) {\n"
                + "        String nameArrayElement = user.getNameArray()[i];\n"
                + "        if (nameArrayElement == null) continue;\n"
                + "        userDto.getNameArray()[i] = nameArrayElement;\n" //
                + "    }\n" //
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

        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getNameArray())) {\n"
                + "    user.setNameArray(new java.lang.String[getNameArray().length]);\n"
                + "    for (int i = 0; i < getNameArray().length; i++) {\n"
                + "        java.lang.String nameArrayElement = getNameArray()[i];\n"
                + "        if (nameArrayElement == null) continue;\n"
                + "        user.getNameArray()[i] = nameArrayElement;\n" //
                + "    }\n" // 
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameArray())) {\n"
                + "    setNameArray(new java.lang.String[user.getNameArray().length]);\n"
                + "    for (int i = 0; i < user.getNameArray().length; i++) {\n"
                + "        java.lang.String nameArrayElement = user.getNameArray()[i];\n"
                + "        if (nameArrayElement == null) continue;\n" //
                + "        getNameArray()[i] = nameArrayElement;\n" //
                + "    }\n" // 
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
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAgeArrayPrimitiveType())) {\n"
                + "    user.setAgeArrayPrimitiveType(new int[userDto.getAgeArrayPrimitiveType().length]);\n"
                + "    for (int i = 0; i < userDto.getAgeArrayPrimitiveType().length; i++) {\n"
                + "        int ageArrayPrimitiveTypeElement = userDto.getAgeArrayPrimitiveType()[i];\n"
                + "        user.getAgeArrayPrimitiveType()[i] = ageArrayPrimitiveTypeElement;\n" + "    }\n" + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayPrimitiveType())) {\n"
                + "    userDto.setAgeArrayPrimitiveType(new int[user.getAgeArrayPrimitiveType().length]);\n"
                + "    for (int i = 0; i < user.getAgeArrayPrimitiveType().length; i++) {\n"
                + "        int ageArrayPrimitiveTypeElement = user.getAgeArrayPrimitiveType()[i];\n"
                + "        userDto.getAgeArrayPrimitiveType()[i] = ageArrayPrimitiveTypeElement;\n" + "    }\n" + "}");

        System.out.println("iterable direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getAgeArrayPrimitiveType())) {\n"
                + "    user.setAgeArrayPrimitiveType(new int[getAgeArrayPrimitiveType().length]);\n"
                + "    for (int i = 0; i < getAgeArrayPrimitiveType().length; i++) {\n"
                + "        int ageArrayPrimitiveTypeElement = getAgeArrayPrimitiveType()[i];\n"
                + "        user.getAgeArrayPrimitiveType()[i] = ageArrayPrimitiveTypeElement;\n" + "    }\n" + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getAgeArrayPrimitiveType())) {\n"
                + "    setAgeArrayPrimitiveType(new int[user.getAgeArrayPrimitiveType().length]);\n"
                + "    for (int i = 0; i < user.getAgeArrayPrimitiveType().length; i++) {\n"
                + "        int ageArrayPrimitiveTypeElement = user.getAgeArrayPrimitiveType()[i];\n"
                + "        getAgeArrayPrimitiveType()[i] = ageArrayPrimitiveTypeElement;\n" + "    }\n" + "}");
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
            + "        if (genderListElement == null) continue;\n"
            + "        user.getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement);\n"
            + "    }\n" // 
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    userDto.setGenderList(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderList().length]);\n"
            + "    for (int i = 0; i < user.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderListElement = user.getGenderList()[i];\n"
            + "        if (genderListElement == null) continue;\n"
            + "        userDto.getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement);\n"
            + "    }\n" //
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
            + "        if (genderListElement == null) continue;\n"
            + "        user.getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement);\n"
            + "    }\n" // 
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    setGenderList(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderList().length]);\n"
            + "    for (int i = 0; i < user.getGenderList().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderListElement = user.getGenderList()[i];\n"
            + "        if (genderListElement == null) continue;\n"
            + "        getGenderList()[i] = cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement);\n"
            + "    }\n" //
            + "}");
    }

    @Override
    @Test
    public void enumToString() {
        final String propertyName = "genderArray";
        String voGender = getClassName(cn.featherfly.conversion.codegen.vo.Gender.class);
        String userGender = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);

        EnumToStringConvertorCodegen enumToString = new EnumToStringConvertorCodegen(voGender);
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(enumToString, Iterables.ARRAY);

        System.out.println("iterable enum to string");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderArray())) {\n"
            + "    user.setGenderArray(new String[userDto.getGenderArray().length]);\n"
            + "    for (int i = 0; i < userDto.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.Gender genderArrayElement = userDto.getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        user.getGenderArray()[i] = genderArrayElement.name();\n" // 
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderArray().length]);\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        userDto.getGenderArray()[i] = cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderArrayElement);\n"
            + "    }\n" // 
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
                + "    user.setGenderArray(new String[getGenderArray().length]);\n"
                + "    for (int i = 0; i < getGenderArray().length; i++) {\n"
                + "        cn.featherfly.conversion.codegen.vo.Gender genderArrayElement = getGenderArray()[i];\n"
                + "        if (genderArrayElement == null) continue;\n"
                + "        user.getGenderArray()[i] = genderArrayElement.name();\n" // 
                + "    }\n" // 
                + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new cn.featherfly.conversion.codegen.vo.Gender[user.getGenderArray().length]);\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        String genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        getGenderArray()[i] = cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderArrayElement);\n"
            + "    }\n" // 
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
            + "        if (genderArrayElement == null) continue;\n"
            + "        user.getGenderArray()[i] = cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement);\n"
            + "    }\n" + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    userDto.setGenderArray(new String[user.getGenderArray().length]);\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        userDto.getGenderArray()[i] = genderArrayElement.name();\n" //
            + "    }\n" //
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
            + "        if (genderArrayElement == null) continue;\n"
            + "        user.getGenderArray()[i] = cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderArrayElement);\n"
            + "    }\n" + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderArray())) {\n"
            + "    setGenderArray(new String[user.getGenderArray().length]);\n"
            + "    for (int i = 0; i < user.getGenderArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User.Gender genderArrayElement = user.getGenderArray()[i];\n"
            + "        if (genderArrayElement == null) continue;\n"
            + "        getGenderArray()[i] = genderArrayElement.name();\n" // 
            + "    }\n"  // 
            + "}");
    }

    @Override
    @Test
    public void beanToBean() {
        final String propertyName = "userArray";
        BeanToBeanConvertorCodegen beanToBean = new BeanToBeanConvertorCodegen(iterableElementBeanCodegen,
            UserDto.class, User.class, 2, false, true);
        IterablePropertyCodegen iterableBeanToBean = new IterablePropertyCodegen(beanToBean, Iterables.ARRAY);

        System.out.println("iterable bean to bean (UserDto -> User);");
        toTarget = iterableBeanToBean.generateToTarget(propertyName, "roleDto", "role");
        fromTarget = iterableBeanToBean.generateFromTarget(propertyName, "roleDto", "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(roleDto.getUserArray())) {\n"
            + "    role.setUserArray(new cn.featherfly.conversion.codegen.domain.User[roleDto.getUserArray().length]);\n"
            + "    for (int i = 0; i < roleDto.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto userArrayElement = roleDto.getUserArray()[i];\n"
            + "        if (userArrayElement == null) continue;\n"
            + "        role.getUserArray()[i] = new cn.featherfly.conversion.codegen.domain.User();\n"
            + "        cn.featherfly.conversion.codegen.domain.User targetUserElement = role.getUserArray()[i];\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) targetUserElement.setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) targetUserElement.setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) targetUserElement.setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) targetUserElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAvailable())) targetUserElement.setAvailable(userArrayElement.getAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) targetUserElement.setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) targetUserElement.setRegisterTime(cn.featherfly.common.lang.Dates.parse(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) targetUserElement.setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) targetUserElement.setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) targetUserElement.setEndTime(cn.featherfly.common.lang.Dates.toDate(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) targetUserElement.setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) targetUserElement.setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) targetUserElement.setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) targetUserElement.setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) targetUserElement.setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) targetUserElement.setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) targetUserElement.setDouble2BigDecimal(userArrayElement.getDouble2BigDecimal().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) targetUserElement.setDouble2BigDecimal2(userArrayElement.getDouble2BigDecimal2().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) targetUserElement.setLong2BigDecimal(userArrayElement.getLong2BigDecimal().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) targetUserElement.setLong2BigDecimal2(userArrayElement.getLong2BigDecimal2().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) targetUserElement.setLong2BigInteger(userArrayElement.getLong2BigInteger().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) targetUserElement.setLong2BigInteger2(userArrayElement.getLong2BigInteger2().longValue());\n"
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    roleDto.setUserArray(new cn.featherfly.conversion.codegen.vo.UserDto[role.getUserArray().length]);\n"
            + "    for (int i = 0; i < role.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User userArrayElement = role.getUserArray()[i];\n"
            + "        if (userArrayElement == null) continue;\n"
            + "        roleDto.getUserArray()[i] = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto sourceUserDtoElement = roleDto.getUserArray()[i];\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) sourceUserDtoElement.setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) sourceUserDtoElement.setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) sourceUserDtoElement.setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) sourceUserDtoElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.isAvailable())) sourceUserDtoElement.setAvailable(userArrayElement.isAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) sourceUserDtoElement.setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) sourceUserDtoElement.setRegisterTime(cn.featherfly.common.lang.Dates.format(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) sourceUserDtoElement.setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) sourceUserDtoElement.setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) sourceUserDtoElement.setEndTime(cn.featherfly.common.lang.Dates.toLocalDateTime(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) sourceUserDtoElement.setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) sourceUserDtoElement.setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) sourceUserDtoElement.setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) sourceUserDtoElement.setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) sourceUserDtoElement.setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) sourceUserDtoElement.setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) sourceUserDtoElement.setDouble2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) sourceUserDtoElement.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) sourceUserDtoElement.setLong2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) sourceUserDtoElement.setLong2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) sourceUserDtoElement.setLong2BigInteger(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) sourceUserDtoElement.setLong2BigInteger2(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger2()));\n"
            + "    }\n" //
            + "}");

        System.out.println("iterable bean to bean (UserDto -> User) with construct");
        toTarget = iterableBeanToBean.generateToTarget(propertyName, null, "role");
        fromTarget = iterableBeanToBean.generateFromTarget(propertyName, null, "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getUserArray())) {\n"
            + "    role.setUserArray(new cn.featherfly.conversion.codegen.domain.User[getUserArray().length]);\n"
            + "    for (int i = 0; i < getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto userArrayElement = getUserArray()[i];\n"
            + "        if (userArrayElement == null) continue;\n"
            + "        role.getUserArray()[i] = new cn.featherfly.conversion.codegen.domain.User();\n"
            + "        cn.featherfly.conversion.codegen.domain.User targetUserElement = role.getUserArray()[i];\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) targetUserElement.setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) targetUserElement.setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) targetUserElement.setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) targetUserElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAvailable())) targetUserElement.setAvailable(userArrayElement.getAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) targetUserElement.setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) targetUserElement.setRegisterTime(cn.featherfly.common.lang.Dates.parse(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) targetUserElement.setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) targetUserElement.setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) targetUserElement.setEndTime(cn.featherfly.common.lang.Dates.toDate(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) targetUserElement.setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) targetUserElement.setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) targetUserElement.setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) targetUserElement.setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) targetUserElement.setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) targetUserElement.setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) targetUserElement.setDouble2BigDecimal(userArrayElement.getDouble2BigDecimal().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) targetUserElement.setDouble2BigDecimal2(userArrayElement.getDouble2BigDecimal2().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) targetUserElement.setLong2BigDecimal(userArrayElement.getLong2BigDecimal().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) targetUserElement.setLong2BigDecimal2(userArrayElement.getLong2BigDecimal2().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) targetUserElement.setLong2BigInteger(userArrayElement.getLong2BigInteger().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) targetUserElement.setLong2BigInteger2(userArrayElement.getLong2BigInteger2().longValue());\n"
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserArray())) {\n"
            + "    setUserArray(new cn.featherfly.conversion.codegen.vo.UserDto[role.getUserArray().length]);\n"
            + "    for (int i = 0; i < role.getUserArray().length; i++) {\n"
            + "        cn.featherfly.conversion.codegen.domain.User userArrayElement = role.getUserArray()[i];\n"
            + "        if (userArrayElement == null) continue;\n"
            + "        getUserArray()[i] = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto sourceUserDtoElement = getUserArray()[i];\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getId())) sourceUserDtoElement.setId(userArrayElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getName())) sourceUserDtoElement.setName(userArrayElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getMobileNo())) sourceUserDtoElement.setMobileNo(userArrayElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getGender())) sourceUserDtoElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userArrayElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.isAvailable())) sourceUserDtoElement.setAvailable(userArrayElement.isAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEmail())) sourceUserDtoElement.setEmail(userArrayElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getRegisterTime())) sourceUserDtoElement.setRegisterTime(cn.featherfly.common.lang.Dates.format(userArrayElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getAlipayUserId())) sourceUserDtoElement.setAlipayUserId(userArrayElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getWechatUnionId())) sourceUserDtoElement.setWechatUnionId(userArrayElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getEndTime())) sourceUserDtoElement.setEndTime(cn.featherfly.common.lang.Dates.toLocalDateTime(userArrayElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getInt2Integer())) sourceUserDtoElement.setInt2Integer(userArrayElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2Long())) sourceUserDtoElement.setLong2Long(userArrayElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getByte2Byte())) sourceUserDtoElement.setByte2Byte(userArrayElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getShort2Short())) sourceUserDtoElement.setShort2Short(userArrayElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2Double())) sourceUserDtoElement.setDouble2Double(userArrayElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getFloat2Float())) sourceUserDtoElement.setFloat2Float(userArrayElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal())) sourceUserDtoElement.setDouble2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getDouble2BigDecimal2())) sourceUserDtoElement.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getDouble2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal())) sourceUserDtoElement.setLong2BigDecimal(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigDecimal2())) sourceUserDtoElement.setLong2BigDecimal2(java.math.BigDecimal.valueOf(userArrayElement.getLong2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger())) sourceUserDtoElement.setLong2BigInteger(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userArrayElement.getLong2BigInteger2())) sourceUserDtoElement.setLong2BigInteger2(java.math.BigInteger.valueOf(userArrayElement.getLong2BigInteger2()));\n"
            + "    }\n" //
            + "}");

    }
}
