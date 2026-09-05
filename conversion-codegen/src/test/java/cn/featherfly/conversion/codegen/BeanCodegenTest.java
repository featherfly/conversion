
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-14 16:51:14
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.conversion.codegen.domain.Role;
import cn.featherfly.conversion.codegen.domain.User;
import cn.featherfly.conversion.codegen.vo.Gender;
import cn.featherfly.conversion.codegen.vo.RoleDto;
import cn.featherfly.conversion.codegen.vo.UserDto;

/**
 * BeanCodegenTest.
 *
 * @author zhongj
 */
public class BeanCodegenTest extends CodegenTest {

    Map<String, PropertyCodegen> propertyCodegenMap;

    List<ConvertibleProperty> properties;

    List<ConvertibleProperty> roleProps;

    @BeforeClass
    void beforeClass() {
        properties = Lang.list(new ConvertiblePropertyImpl("id", long.class, long.class),
            new ConvertiblePropertyImpl("name", String.class, String.class),
            new ConvertiblePropertyImpl("gender", cn.featherfly.conversion.codegen.domain.User.Gender.class,
                cn.featherfly.conversion.codegen.vo.Gender.class),
            new ConvertiblePropertyImpl("available", Boolean.class, boolean.class),
            new ConvertiblePropertyImpl("int2Integer", Integer.class, int.class),
            new ConvertiblePropertyImpl("long2Long", Long.class, long.class),
            new ConvertiblePropertyImpl("double2Double", Double.class, double.class),
            new ConvertiblePropertyImpl("float2Float", Float.class, float.class),
            new ConvertiblePropertyImpl("byte2Byte", Byte.class, byte.class),
            new ConvertiblePropertyImpl("short2Short", Short.class, short.class));

        roleProps = Lang.list( //
            new ConvertiblePropertyImpl("id", long.class, long.class),
            new ConvertiblePropertyImpl("name", String.class, String.class),
            new ConvertiblePropertyImpl("user", new TypeMetadataImpl(UserDto.class), new TypeMetadataImpl(User.class)),
            new ConvertiblePropertyImpl("users", new TypeMetadataImpl(UserDto[].class),
                new TypeMetadataImpl(User[].class)),
            new ConvertiblePropertyImpl("userList", new TypeMetadataImpl(List.class, UserDto.class),
                new TypeMetadataImpl(List.class, User.class)),
            new ConvertiblePropertyImpl("addresses", new TypeMetadataImpl(List.class, String.class),
                new TypeMetadataImpl(List.class, String.class)),
            new ConvertiblePropertyImpl("tags", new TypeMetadataImpl(String[].class),
                new TypeMetadataImpl(String[].class)),
            new ConvertiblePropertyImpl("numbers", new TypeMetadataImpl(int[].class),
                new TypeMetadataImpl(int[].class)),
            new ConvertiblePropertyImpl("genderList", new TypeMetadataImpl(List.class, Gender.class),
                new TypeMetadataImpl(List.class, cn.featherfly.conversion.codegen.domain.User.Gender.class)),
            new ConvertiblePropertyImpl("genderToStringList", new TypeMetadataImpl(List.class, Gender.class),
                new TypeMetadataImpl(List.class, String.class)),
            new ConvertiblePropertyImpl("genderFromStringList", new TypeMetadataImpl(List.class, String.class),
                new TypeMetadataImpl(List.class, cn.featherfly.conversion.codegen.domain.User.Gender.class)),
            new ConvertiblePropertyImpl("intToString", new TypeMetadataImpl(int.class),
                new TypeMetadataImpl(String.class)) // 这里没有对应的转换器，就会用BeanToBean转换器，生成的代码会报错 
        //
        );
    }

    @Test
    public void testToTarget() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();
        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toUser", false, false),
            UserDto.class.getName(), User.class.getName(), properties, null, "user"));

        assertEquals(
            codegen.generateToTarget(new MethodMetadataImpl("toUser", false, false), UserDto.class.getName(),
                User.class.getName(), properties, null, "user"),
            "public cn.featherfly.conversion.codegen.domain.User toUser() {\n"
                + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getAvailable())) user.setAvailable(getAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getInt2Integer())) user.setInt2Integer(getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2Long())) user.setLong2Long(getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2Double())) user.setDouble2Double(getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getFloat2Float())) user.setFloat2Float(getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getByte2Byte())) user.setByte2Byte(getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getShort2Short())) user.setShort2Short(getShort2Short());\n"
                + "    return user;\n" + "}");

        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toUser", false, true),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user"));
        assertEquals(
            codegen.generateToTarget(new MethodMetadataImpl("toUser", false, true), UserDto.class.getName(),
                User.class.getName(), properties, "userDto", "user"),
            "public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto) {\n"
                + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
                + "    if (userDto == null) return user;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getName())) user.setName(userDto.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userDto.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAvailable())) user.setAvailable(userDto.getAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getInt2Integer())) user.setInt2Integer(userDto.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2Long())) user.setLong2Long(userDto.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2Double())) user.setDouble2Double(userDto.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getFloat2Float())) user.setFloat2Float(userDto.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getByte2Byte())) user.setByte2Byte(userDto.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getShort2Short())) user.setShort2Short(userDto.getShort2Short());\n"
                + "    return user;\n" + "}");
    }

    @Test
    public void testFromTarget() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();
        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("UserDto", true), UserDto.class.getName(),
            User.class.getName(), properties, null, "user"));

        assertEquals(
            codegen.generateFromTarget(new MethodMetadataImpl("UserDto", true), UserDto.class.getName(),
                User.class.getName(), properties, null, "user"),
            "public UserDto(cn.featherfly.conversion.codegen.domain.User user) {\n" + "    if (user == null) return;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) setName(user.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) setAvailable(user.isAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) setInt2Integer(user.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) setLong2Long(user.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) setDouble2Double(user.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) setFloat2Float(user.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) setByte2Byte(user.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) setShort2Short(user.getShort2Short());\n"
                + "}");

        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("fromUser", false),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user"));
        assertEquals(
            codegen.generateFromTarget(new MethodMetadataImpl("fromUser", false), UserDto.class.getName(),
                User.class.getName(), properties, "userDto", "user"),
            "public cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
                + "    cn.featherfly.conversion.codegen.vo.UserDto userDto = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
                + "    if (user == null) return userDto;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) userDto.setAvailable(user.isAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) userDto.setInt2Integer(user.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) userDto.setLong2Long(user.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) userDto.setDouble2Double(user.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) userDto.setFloat2Float(user.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) userDto.setByte2Byte(user.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) userDto.setShort2Short(user.getShort2Short());\n"
                + "    return userDto;\n" + "}");

        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("fromUser", false, true),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user"));
        assertEquals(
            codegen.generateFromTarget(new MethodMetadataImpl("fromUser", false, true), UserDto.class.getName(),
                User.class.getName(), properties, "userDto", "user"),
            "public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
                + "    cn.featherfly.conversion.codegen.vo.UserDto userDto = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
                + "    if (user == null) return userDto;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) userDto.setAvailable(user.isAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) userDto.setInt2Integer(user.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) userDto.setLong2Long(user.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) userDto.setDouble2Double(user.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) userDto.setFloat2Float(user.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) userDto.setByte2Byte(user.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) userDto.setShort2Short(user.getShort2Short());\n"
                + "    return userDto;\n" + "}");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStaticMethdoSourceObjectNameNull() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();

        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toUser", false, true),
            UserDto.class.getName(), User.class.getName(), properties, null, "user"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIsStaticAndIsConstructorBothTrue() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();

        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toUser", true, true),
            UserDto.class.getName(), User.class.getName(), properties, null, "user"));
    }

    @Test
    public void roleDtoToTarget() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();
        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toRole", false, false),
            RoleDto.class.getName(), Role.class.getName(), roleProps, null, "role"));

        //        assertEquals(codegen.generateToTarget(new MethodMetadataImpl("toRole", false, false),
        //            UserDto.class.getName(), User.class.getName(),
        //            properties, null, "user"),
        //            "public cn.featherfly.conversion.codegen.domain.User toUser() {\n"
        //                + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, getGender()));\n"
        //                + "    return user;\n"
        //                + "}");

        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toRole", false, true),
            UserDto.class.getName(), User.class.getName(), roleProps, "roleDto", "role"));
        //        assertEquals(codegen.generateToTarget(new MethodMetadataImpl("toRole", false, true),
        //            UserDto.class.getName(), User.class.getName(),
        //            properties, "userDto", "user"),
        //            "public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto) {\n"
        //                + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getName())) user.setName(userDto.getName());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, userDto.getGender()));\n"
        //                + "    return user;\n"
        //                + "}");
    }

    @Test
    public void roleDtoFromTarget() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();
        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("RoleDto", true), RoleDto.class.getName(),
            Role.class.getName(), roleProps, null, "role"));

        //        assertEquals(codegen.generateToTarget(new MethodMetadataImpl("toRole", false, false),
        //            UserDto.class.getName(), User.class.getName(),
        //            properties, null, "user"),
        //            "public cn.featherfly.conversion.codegen.domain.User toUser() {\n"
        //                + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, getGender()));\n"
        //                + "    return user;\n"
        //                + "}");

        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("fromRole", false),
            RoleDto.class.getName(), Role.class.getName(), roleProps, "roleDto", "user"));
        //        assertEquals(codegen.generateFromTarget(new MethodMetadataImpl("fromUser", false),
        //            UserDto.class.getName(), User.class.getName(),
        //            properties, "userDto", "user"),
        //            "public cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
        //                + "    cn.featherfly.conversion.codegen.vo.UserDto userDto = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
        //                + "    return userDto;\n"
        //                + "}");

        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("fromRole", false, true),
            RoleDto.class.getName(), Role.class.getName(), roleProps, "roleDto", "user"));
        //        assertEquals(codegen.generateFromTarget(new MethodMetadataImpl("fromUser", false, true),
        //            UserDto.class.getName(), User.class.getName(),
        //            properties, "userDto", "user"),
        //            "public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
        //                + "    cn.featherfly.conversion.codegen.vo.UserDto userDto = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
        //                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, user.getGender()));\n"
        //                + "    return userDto;\n"
        //                + "}");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void noConvertorException() {
        BeanCodegen codegen = BeanCodegenImpl.builder().setNoConvertorException(true).build();
        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("RoleDto", true), RoleDto.class.getName(),
            Role.class.getName(), roleProps, null, "role"));
    }
}
