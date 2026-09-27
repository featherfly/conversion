
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
 * IterableListPropertyCodegenTest.
 *
 * @author zhongj
 */
public class IterableListPropertyCodegenTest extends IterablePropertyCodegenTest {

    @Override
    @Test
    public void directAssign() {
        final String propertyName = "nameList";
        DirectAssignConvertorCodegen directAssign = new DirectAssignConvertorCodegen(String.class);
        IterablePropertyCodegen iterableDirectAssign = new IterablePropertyCodegen(directAssign, Iterables.LIST);

        System.out.println("iterable direct assign");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getNameList())) {\n"
                + "    user.setNameList(new java.util.ArrayList<>(userDto.getNameList().size()));\n"
                + "    for (String nameListElement : userDto.getNameList()) {\n" //
                + "        if (nameListElement == null) {\n" //
                + "            user.getNameList().add(null);\n" //
                + "            continue;\n" //
                + "        }\n" // 
                + "        user.getNameList().add(nameListElement);\n" // 
                + "    }\n" // 
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameList())) {\n"
                + "    userDto.setNameList(new java.util.ArrayList<>(user.getNameList().size()));\n" //
                + "    for (String nameListElement : user.getNameList()) {\n" // 
                + "        if (nameListElement == null) {\n" //
                + "            userDto.getNameList().add(null);\n" // 
                + "            continue;\n" // 
                + "        }\n" // 
                + "        userDto.getNameList().add(nameListElement);\n" // 
                + "    }\n" //
                + "}");

        directAssign = new DirectAssignConvertorCodegen("java.lang.String");
        iterableDirectAssign = new IterablePropertyCodegen(directAssign, Iterables.LIST);
        System.out.println("iterable direct assign with constructor");
        toTarget = iterableDirectAssign.generateToTarget(propertyName, null, "user");
        fromTarget = iterableDirectAssign.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: this -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: this <- user");
        System.out.println(fromTarget);

        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getNameList())) {\n"
                + "    user.setNameList(new java.util.ArrayList<>(getNameList().size()));\n" //
                + "    for (java.lang.String nameListElement : getNameList()) {\n" //
                + "        if (nameListElement == null) {\n" //
                + "            user.getNameList().add(null);\n" // 
                + "            continue;\n" // 
                + "        }\n" //
                + "        user.getNameList().add(nameListElement);\n" //
                + "    }\n" //
                + "}");
        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getNameList())) {\n"
                + "    setNameList(new java.util.ArrayList<>(user.getNameList().size()));\n" //
                + "    for (java.lang.String nameListElement : user.getNameList()) {\n" //
                + "        if (nameListElement == null) {\n" //
                + "            getNameList().add(null);\n" //
                + "            continue;\n" //
                + "        }\n" //
                + "        getNameList().add(nameListElement);\n" //
                + "    }\n"  //
                + "}");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void directAssignPrimitiveType() {
        // 容器获取的类型都是对象类型
    }

    @Override
    @Test
    public void enumToEnum() {
        final String propertyName = "genderList";
        String domainGender = getClassName(cn.featherfly.conversion.codegen.domain.User.Gender.class);
        String voGender = getClassName(cn.featherfly.conversion.codegen.vo.Gender.class);

        EnumToEnumConvertorCodegen enumToEnum = new EnumToEnumConvertorCodegen(voGender, domainGender);
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(enumToEnum, Iterables.LIST);
        System.out.println("iterable enum to enum");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderList())) {\n"
            + "    user.setGenderList(new java.util.ArrayList<>(userDto.getGenderList().size()));\n" //
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderListElement : userDto.getGenderList()) {\n" //
            + "        if (genderListElement == null) {\n" //
            + "            user.getGenderList().add(null);\n" //
            + "            continue;\n" //
            + "        }\n" // 
            + "        user.getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement));\n" //
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    userDto.setGenderList(new java.util.ArrayList<>(user.getGenderList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderListElement : user.getGenderList()) {\n" //
            + "        if (genderListElement == null) {\n" //
            + "            userDto.getGenderList().add(null);\n"//
            + "            continue;\n" //
            + "        }\n" //
            + "        userDto.getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement));\n"
            + "    }\n" // 
            + "}");

        System.out.println("iterable enum to enum with constructor");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "user");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderList())) {\n"
            + "    user.setGenderList(new java.util.ArrayList<>(getGenderList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.vo.Gender genderListElement : getGenderList()) {\n"
            + "        if (genderListElement == null) {\n" //
            + "            user.getGenderList().add(null);\n"//
            + "            continue;\n" //
            + "        }\n"
            + "        user.getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, genderListElement));\n"
            + "    }\n" + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    setGenderList(new java.util.ArrayList<>(user.getGenderList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderListElement : user.getGenderList()) {\n"
            + "        if (genderListElement == null) {\n" //
            + "            getGenderList().add(null);\n" //
            + "            continue;\n" //
            + "        }\n" //
            + "        getGenderList().add(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, genderListElement));\n"
            + "    }\n"//
            + "}");
    }

    @Override
    @Test
    public void enumToString() {
        final String propertyName = "genderList";
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
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderList())) {\n"
                + "    user.setGenderList(new java.util.ArrayList<>(userDto.getGenderList().size()));\n"
                + "    for (cn.featherfly.conversion.codegen.vo.Gender genderListElement : userDto.getGenderList()) {\n"
                + "        if (genderListElement == null) {\n" //
                + "            user.getGenderList().add(null);\n" //
                + "            continue;\n"  // 
                + "        }\n" //
                + "        user.getGenderList().add(genderListElement.name());\n" // 
                + "    }\n" //
                + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    userDto.setGenderList(new java.util.ArrayList<>(user.getGenderList().size()));\n"
            + "    for (String genderListElement : user.getGenderList()) {\n" //
            + "        if (genderListElement == null) {\n" //
            + "            userDto.getGenderList().add(null);\n"//
            + "            continue;\n" //
            + "        }\n" //
            + "        userDto.getGenderList().add(cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderListElement));\n"
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
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderList())) {\n"
                + "    user.setGenderList(new java.util.ArrayList<>(getGenderList().size()));\n"
                + "    for (cn.featherfly.conversion.codegen.vo.Gender genderListElement : getGenderList()) {\n"
                + "        if (genderListElement == null) {\n" //
                + "            user.getGenderList().add(null);\n" //
                + "            continue;\n" //
                + "        }\n"  // 
                + "        user.getGenderList().add(genderListElement.name());\n" //
                + "    }\n" //
                + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    setGenderList(new java.util.ArrayList<>(user.getGenderList().size()));\n"
            + "    for (String genderListElement : user.getGenderList()) {\n" //
            + "        if (genderListElement == null) {\n" //
            + "            getGenderList().add(null);\n" //
            + "            continue;\n" // 
            + "        }\n"//
            + "        getGenderList().add(cn.featherfly.conversion.codegen.vo.Gender.valueOf(genderListElement));\n"
            + "    }\n"//
            + "}");

        // --------------------------
        System.out.println("iterable string to enum");

        EnumToStringConvertorCodegen stringToEnum = new EnumToStringConvertorCodegen(userGender, true);
        iterableEnumToEnum = new IterablePropertyCodegen(stringToEnum, Iterables.LIST);

        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "userDto", "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "userDto", "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGenderList())) {\n"
            + "    user.setGenderList(new java.util.ArrayList<>(userDto.getGenderList().size()));\n"
            + "    for (String genderListElement : userDto.getGenderList()) {\n" //
            + "        if (genderListElement == null) {\n" //
            + "            user.getGenderList().add(null);\n" //
            + "            continue;\n" // 
            + "        }\n" //
            + "        user.getGenderList().add(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderListElement));\n"
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    userDto.setGenderList(new java.util.ArrayList<>(user.getGenderList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderListElement : user.getGenderList()) {\n"
            + "        if (genderListElement == null) {\n" //
            + "            userDto.getGenderList().add(null);\n" //
            + "            continue;\n" //
            + "        }\n" //
            + "        userDto.getGenderList().add(genderListElement.name());\n" //
            + "    }\n" //
            + "}");

        System.out.println("iterable string to enum with constructor");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "user");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "user");
        System.out.println("toTarget: userDto -> user");
        System.out.println(toTarget);
        System.out.println("fromTarget: userDto <- user");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getGenderList())) {\n"
            + "    user.setGenderList(new java.util.ArrayList<>(getGenderList().size()));\n"
            + "    for (String genderListElement : getGenderList()) {\n" //
            + "        if (genderListElement == null) {\n" //
            + "            user.getGenderList().add(null);\n" //
            + "            continue;\n" // 
            + "        }\n" //
            + "        user.getGenderList().add(cn.featherfly.conversion.codegen.domain.User.Gender.valueOf(genderListElement));\n"
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGenderList())) {\n"
            + "    setGenderList(new java.util.ArrayList<>(user.getGenderList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User.Gender genderListElement : user.getGenderList()) {\n"
            + "        if (genderListElement == null) {\n" //
            + "            getGenderList().add(null);\n" //
            + "            continue;\n" //
            + "        }\n" //
            + "        getGenderList().add(genderListElement.name());\n" //
            + "    }\n" //
            + "}");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beanToBean() {
        final String propertyName = "userList";
        BeanToBeanConvertorCodegen beanToBean = new BeanToBeanConvertorCodegen(iterableElementBeanCodegen,
            UserDto.class, User.class, 2, false, true);
        IterablePropertyCodegen iterableEnumToEnum = new IterablePropertyCodegen(beanToBean, Iterables.LIST);

        System.out.println("iterable bean to bean (UserDto -> User);");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, "roleDto", "role");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, "roleDto", "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(roleDto.getUserList())) {\n"
            + "    role.setUserList(new java.util.ArrayList<>(roleDto.getUserList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.vo.UserDto userListElement : roleDto.getUserList()) {\n"
            + "        if (userListElement == null) {\n" //
            + "            role.getUserList().add(null);\n" //
            + "            continue;\n" //
            + "        }\n" //
            + "        role.getUserList()[i] = new cn.featherfly.conversion.codegen.domain.User();\n"
            + "        cn.featherfly.conversion.codegen.domain.User targetUserElement = role.getUserList()[i];\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getId())) targetUserElement.setId(userListElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getName())) targetUserElement.setName(userListElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getMobileNo())) targetUserElement.setMobileNo(userListElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getGender())) targetUserElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userListElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getAvailable())) targetUserElement.setAvailable(userListElement.getAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEmail())) targetUserElement.setEmail(userListElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getRegisterTime())) targetUserElement.setRegisterTime(cn.featherfly.common.lang.Dates.parse(userListElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getAlipayUserId())) targetUserElement.setAlipayUserId(userListElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getWechatUnionId())) targetUserElement.setWechatUnionId(userListElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEndTime())) targetUserElement.setEndTime(cn.featherfly.common.lang.Dates.toDate(userListElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getInt2Integer())) targetUserElement.setInt2Integer(userListElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2Long())) targetUserElement.setLong2Long(userListElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getByte2Byte())) targetUserElement.setByte2Byte(userListElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getShort2Short())) targetUserElement.setShort2Short(userListElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2Double())) targetUserElement.setDouble2Double(userListElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getFloat2Float())) targetUserElement.setFloat2Float(userListElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal())) targetUserElement.setDouble2BigDecimal(userListElement.getDouble2BigDecimal().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal2())) targetUserElement.setDouble2BigDecimal2(userListElement.getDouble2BigDecimal2().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal())) targetUserElement.setLong2BigDecimal(userListElement.getLong2BigDecimal().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal2())) targetUserElement.setLong2BigDecimal2(userListElement.getLong2BigDecimal2().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger())) targetUserElement.setLong2BigInteger(userListElement.getLong2BigInteger().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger2())) targetUserElement.setLong2BigInteger2(userListElement.getLong2BigInteger2().longValue());\n" // 
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserList())) {\n"
            + "    roleDto.setUserList(new java.util.ArrayList<>(role.getUserList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User userListElement : role.getUserList()) {\n"
            + "        if (userListElement == null) {\n" //
            + "            roleDto.getUserList().add(null);\n" //
            + "            continue;\n" //
            + "        }\n" //
            + "        roleDto.getUserList().get(i) = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto sourceUserDtoElement = roleDto.getUserList().get(i);\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getId())) sourceUserDtoElement.setId(userListElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getName())) sourceUserDtoElement.setName(userListElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getMobileNo())) sourceUserDtoElement.setMobileNo(userListElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getGender())) sourceUserDtoElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userListElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.isAvailable())) sourceUserDtoElement.setAvailable(userListElement.isAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEmail())) sourceUserDtoElement.setEmail(userListElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getRegisterTime())) sourceUserDtoElement.setRegisterTime(cn.featherfly.common.lang.Dates.format(userListElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getAlipayUserId())) sourceUserDtoElement.setAlipayUserId(userListElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getWechatUnionId())) sourceUserDtoElement.setWechatUnionId(userListElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEndTime())) sourceUserDtoElement.setEndTime(cn.featherfly.common.lang.Dates.toLocalDateTime(userListElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getInt2Integer())) sourceUserDtoElement.setInt2Integer(userListElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2Long())) sourceUserDtoElement.setLong2Long(userListElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getByte2Byte())) sourceUserDtoElement.setByte2Byte(userListElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getShort2Short())) sourceUserDtoElement.setShort2Short(userListElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2Double())) sourceUserDtoElement.setDouble2Double(userListElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getFloat2Float())) sourceUserDtoElement.setFloat2Float(userListElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal())) sourceUserDtoElement.setDouble2BigDecimal(java.math.BigDecimal.valueOf(userListElement.getDouble2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal2())) sourceUserDtoElement.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(userListElement.getDouble2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal())) sourceUserDtoElement.setLong2BigDecimal(java.math.BigDecimal.valueOf(userListElement.getLong2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal2())) sourceUserDtoElement.setLong2BigDecimal2(java.math.BigDecimal.valueOf(userListElement.getLong2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger())) sourceUserDtoElement.setLong2BigInteger(java.math.BigInteger.valueOf(userListElement.getLong2BigInteger()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger2())) sourceUserDtoElement.setLong2BigInteger2(java.math.BigInteger.valueOf(userListElement.getLong2BigInteger2()));\n"
            + "    }\n" //
            + "}");

        System.out.println("iterable bean to bean (UserDto -> User) with construct");
        toTarget = iterableEnumToEnum.generateToTarget(propertyName, null, "role");
        fromTarget = iterableEnumToEnum.generateFromTarget(propertyName, null, "role");
        System.out.println("toTarget: roleDto -> role");
        System.out.println(toTarget);
        System.out.println("fromTarget: roleDto <- role");
        System.out.println(fromTarget);
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(getUserList())) {\n"
            + "    role.setUserList(new java.util.ArrayList<>(getUserList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.vo.UserDto userListElement : getUserList()) {\n"
            + "        if (userListElement == null) {\n" //
            + "            role.getUserList().add(null);\n" //
            + "            continue;\n" // 
            + "        }\n" //
            + "        role.getUserList()[i] = new cn.featherfly.conversion.codegen.domain.User();\n"
            + "        cn.featherfly.conversion.codegen.domain.User targetUserElement = role.getUserList()[i];\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getId())) targetUserElement.setId(userListElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getName())) targetUserElement.setName(userListElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getMobileNo())) targetUserElement.setMobileNo(userListElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getGender())) targetUserElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userListElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getAvailable())) targetUserElement.setAvailable(userListElement.getAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEmail())) targetUserElement.setEmail(userListElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getRegisterTime())) targetUserElement.setRegisterTime(cn.featherfly.common.lang.Dates.parse(userListElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getAlipayUserId())) targetUserElement.setAlipayUserId(userListElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getWechatUnionId())) targetUserElement.setWechatUnionId(userListElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEndTime())) targetUserElement.setEndTime(cn.featherfly.common.lang.Dates.toDate(userListElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getInt2Integer())) targetUserElement.setInt2Integer(userListElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2Long())) targetUserElement.setLong2Long(userListElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getByte2Byte())) targetUserElement.setByte2Byte(userListElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getShort2Short())) targetUserElement.setShort2Short(userListElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2Double())) targetUserElement.setDouble2Double(userListElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getFloat2Float())) targetUserElement.setFloat2Float(userListElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal())) targetUserElement.setDouble2BigDecimal(userListElement.getDouble2BigDecimal().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal2())) targetUserElement.setDouble2BigDecimal2(userListElement.getDouble2BigDecimal2().doubleValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal())) targetUserElement.setLong2BigDecimal(userListElement.getLong2BigDecimal().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal2())) targetUserElement.setLong2BigDecimal2(userListElement.getLong2BigDecimal2().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger())) targetUserElement.setLong2BigInteger(userListElement.getLong2BigInteger().longValue());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger2())) targetUserElement.setLong2BigInteger2(userListElement.getLong2BigInteger2().longValue());\n" //
            + "    }\n" //
            + "}");
        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(role.getUserList())) {\n"
            + "    setUserList(new java.util.ArrayList<>(role.getUserList().size()));\n"
            + "    for (cn.featherfly.conversion.codegen.domain.User userListElement : role.getUserList()) {\n"
            + "        if (userListElement == null) {\n" //
            + "            getUserList().add(null);\n" //
            + "            continue;\n" //
            + "        }\n" //
            + "        getUserList().get(i) = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
            + "        cn.featherfly.conversion.codegen.vo.UserDto sourceUserDtoElement = getUserList().get(i);\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getId())) sourceUserDtoElement.setId(userListElement.getId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getName())) sourceUserDtoElement.setName(userListElement.getName());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getMobileNo())) sourceUserDtoElement.setMobileNo(userListElement.getMobileNo());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getGender())) sourceUserDtoElement.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userListElement.getGender()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.isAvailable())) sourceUserDtoElement.setAvailable(userListElement.isAvailable());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEmail())) sourceUserDtoElement.setEmail(userListElement.getEmail());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getRegisterTime())) sourceUserDtoElement.setRegisterTime(cn.featherfly.common.lang.Dates.format(userListElement.getRegisterTime(), \"yyyy-MM-dd HH:mm:ss\"));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getAlipayUserId())) sourceUserDtoElement.setAlipayUserId(userListElement.getAlipayUserId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getWechatUnionId())) sourceUserDtoElement.setWechatUnionId(userListElement.getWechatUnionId());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getEndTime())) sourceUserDtoElement.setEndTime(cn.featherfly.common.lang.Dates.toLocalDateTime(userListElement.getEndTime()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getInt2Integer())) sourceUserDtoElement.setInt2Integer(userListElement.getInt2Integer());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2Long())) sourceUserDtoElement.setLong2Long(userListElement.getLong2Long());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getByte2Byte())) sourceUserDtoElement.setByte2Byte(userListElement.getByte2Byte());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getShort2Short())) sourceUserDtoElement.setShort2Short(userListElement.getShort2Short());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2Double())) sourceUserDtoElement.setDouble2Double(userListElement.getDouble2Double());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getFloat2Float())) sourceUserDtoElement.setFloat2Float(userListElement.getFloat2Float());\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal())) sourceUserDtoElement.setDouble2BigDecimal(java.math.BigDecimal.valueOf(userListElement.getDouble2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getDouble2BigDecimal2())) sourceUserDtoElement.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(userListElement.getDouble2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal())) sourceUserDtoElement.setLong2BigDecimal(java.math.BigDecimal.valueOf(userListElement.getLong2BigDecimal()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigDecimal2())) sourceUserDtoElement.setLong2BigDecimal2(java.math.BigDecimal.valueOf(userListElement.getLong2BigDecimal2()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger())) sourceUserDtoElement.setLong2BigInteger(java.math.BigInteger.valueOf(userListElement.getLong2BigInteger()));\n"
            + "        if (cn.featherfly.common.lang.Lang.isNotEmpty(userListElement.getLong2BigInteger2())) sourceUserDtoElement.setLong2BigInteger2(java.math.BigInteger.valueOf(userListElement.getLong2BigInteger2()));\n"
            + "    }\n" //
            + "}");

    }
}
