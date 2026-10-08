
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-14 16:51:14
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.MethodMetadata.MethodType;
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
        // source UserDto target User
        properties = Lang.list(new ConvertiblePropertyImpl("id", long.class, long.class),
            new ConvertiblePropertyImpl("name", String.class, String.class),
            new ConvertiblePropertyImpl("gender", cn.featherfly.conversion.codegen.vo.Gender.class,
                cn.featherfly.conversion.codegen.domain.User.Gender.class),
            new ConvertiblePropertyImpl("available", Boolean.class, boolean.class),
            new ConvertiblePropertyImpl("int2Integer", Integer.class, int.class),
            new ConvertiblePropertyImpl("long2Long", Long.class, long.class),
            new ConvertiblePropertyImpl("double2Double", Double.class, double.class),
            new ConvertiblePropertyImpl("float2Float", Float.class, float.class),
            new ConvertiblePropertyImpl("byte2Byte", Byte.class, byte.class),
            new ConvertiblePropertyImpl("short2Short", Short.class, short.class),
            new ConvertiblePropertyImpl("double2BigDecimal", BigDecimal.class, double.class),
            new ConvertiblePropertyImpl("double2BigDecimal2", BigDecimal.class, Double.class),
            new ConvertiblePropertyImpl("long2BigDecimal", BigDecimal.class, long.class),
            new ConvertiblePropertyImpl("long2BigDecimal2", BigDecimal.class, Long.class),
            new ConvertiblePropertyImpl("long2BigInteger", BigInteger.class, long.class),
            new ConvertiblePropertyImpl("long2BigInteger", BigInteger.class, Long.class));

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
        String result = null;
        BeanCodegen codegen = BeanCodegenImpl.builder().setGenerateJavadoc(false).build();

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.METHOD), UserDto.class.getName(),
            User.class.getName(), properties, null, "user");
        System.out.println(result);

        assertEquals(result, "public cn.featherfly.conversion.codegen.domain.User toUser() {\n"
            + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getAvailable())) user.setAvailable(getAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getInt2Integer())) user.setInt2Integer(getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2Long())) user.setLong2Long(getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2Double())) user.setDouble2Double(getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getFloat2Float())) user.setFloat2Float(getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getByte2Byte())) user.setByte2Byte(getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getShort2Short())) user.setShort2Short(getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal())) user.setDouble2BigDecimal(getDouble2BigDecimal().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal2())) user.setDouble2BigDecimal2(getDouble2BigDecimal2().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal())) user.setLong2BigDecimal(getLong2BigDecimal().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal2())) user.setLong2BigDecimal2(getLong2BigDecimal2().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
            + "    return user;\n" + "}");

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.METHOD, true),
            UserDto.class.getName(), User.class.getName(), properties, null, "user");
        System.out.println(result);

        assertEquals(result,
            "public cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
                + "    if (user == null) return user;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getAvailable())) user.setAvailable(getAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getInt2Integer())) user.setInt2Integer(getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2Long())) user.setLong2Long(getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2Double())) user.setDouble2Double(getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getFloat2Float())) user.setFloat2Float(getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getByte2Byte())) user.setByte2Byte(getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getShort2Short())) user.setShort2Short(getShort2Short());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal())) user.setDouble2BigDecimal(getDouble2BigDecimal().doubleValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal2())) user.setDouble2BigDecimal2(getDouble2BigDecimal2().doubleValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal())) user.setLong2BigDecimal(getLong2BigDecimal().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal2())) user.setLong2BigDecimal2(getLong2BigDecimal2().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
                + "    return user;\n" + "}");

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);

        assertEquals(result,
            "public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto) {\n"
                + "    if (userDto == null) return null;\n"
                + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getName())) user.setName(userDto.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAvailable())) user.setAvailable(userDto.getAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getInt2Integer())) user.setInt2Integer(userDto.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2Long())) user.setLong2Long(userDto.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2Double())) user.setDouble2Double(userDto.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getFloat2Float())) user.setFloat2Float(userDto.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getByte2Byte())) user.setByte2Byte(userDto.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getShort2Short())) user.setShort2Short(userDto.getShort2Short());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal())) user.setDouble2BigDecimal(userDto.getDouble2BigDecimal().doubleValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal2())) user.setDouble2BigDecimal2(userDto.getDouble2BigDecimal2().doubleValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal())) user.setLong2BigDecimal(userDto.getLong2BigDecimal().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal2())) user.setLong2BigDecimal2(userDto.getLong2BigDecimal2().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
                + "    return user;\n" + "}");

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.STATIC_METHOD, true),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);

        assertEquals(result,
            "public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto, cn.featherfly.conversion.codegen.domain.User user) {\n"
                + "    if (user == null || userDto == null) return user;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getName())) user.setName(userDto.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAvailable())) user.setAvailable(userDto.getAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getInt2Integer())) user.setInt2Integer(userDto.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2Long())) user.setLong2Long(userDto.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2Double())) user.setDouble2Double(userDto.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getFloat2Float())) user.setFloat2Float(userDto.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getByte2Byte())) user.setByte2Byte(userDto.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getShort2Short())) user.setShort2Short(userDto.getShort2Short());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal())) user.setDouble2BigDecimal(userDto.getDouble2BigDecimal().doubleValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal2())) user.setDouble2BigDecimal2(userDto.getDouble2BigDecimal2().doubleValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal())) user.setLong2BigDecimal(userDto.getLong2BigDecimal().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal2())) user.setLong2BigDecimal2(userDto.getLong2BigDecimal2().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
                + "    return user;\n" + "}");
    }

    @Test
    public void testToTargetWithJavadoc() {
        String result = null;
        BeanCodegen codegen = BeanCodegenImpl.builder().build();

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.METHOD), UserDto.class.getName(),
            User.class.getName(), properties, null, "user");
        System.out.println(result);

        assertEquals(result, "/**\n" //
            + " * create a new cn.featherfly.conversion.codegen.domain.User and copy properties from this\n" //
            + " * @return new cn.featherfly.conversion.codegen.domain.User\n" //
            + " */\n" //
            + "public cn.featherfly.conversion.codegen.domain.User toUser() {\n"
            + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getAvailable())) user.setAvailable(getAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getInt2Integer())) user.setInt2Integer(getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2Long())) user.setLong2Long(getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2Double())) user.setDouble2Double(getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getFloat2Float())) user.setFloat2Float(getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getByte2Byte())) user.setByte2Byte(getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getShort2Short())) user.setShort2Short(getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal())) user.setDouble2BigDecimal(getDouble2BigDecimal().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal2())) user.setDouble2BigDecimal2(getDouble2BigDecimal2().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal())) user.setLong2BigDecimal(getLong2BigDecimal().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal2())) user.setLong2BigDecimal2(getLong2BigDecimal2().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
            + "    return user;\n" + "}");

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.METHOD, true),
            UserDto.class.getName(), User.class.getName(), properties, null, "user");
        System.out.println(result);

        assertEquals(result, "/**\n" //
            + " * copy properties from this to argument user\n" //
            + " * @param user user\n" //
            + " * @return the argument user\n" //
            + " */\n" //
            + "public cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
            + "    if (user == null) return user;\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getName())) user.setName(getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getAvailable())) user.setAvailable(getAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getInt2Integer())) user.setInt2Integer(getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2Long())) user.setLong2Long(getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2Double())) user.setDouble2Double(getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getFloat2Float())) user.setFloat2Float(getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getByte2Byte())) user.setByte2Byte(getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getShort2Short())) user.setShort2Short(getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal())) user.setDouble2BigDecimal(getDouble2BigDecimal().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getDouble2BigDecimal2())) user.setDouble2BigDecimal2(getDouble2BigDecimal2().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal())) user.setLong2BigDecimal(getLong2BigDecimal().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigDecimal2())) user.setLong2BigDecimal2(getLong2BigDecimal2().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(getLong2BigInteger())) user.setLong2BigInteger(getLong2BigInteger().longValue());\n"
            + "    return user;\n" + "}");

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);

        assertEquals(result, "/**\n" //
            + " * create a new cn.featherfly.conversion.codegen.domain.User and copy properties from userDto\n" //
            + " * @param userDto userDto\n" //
            + " * @return new cn.featherfly.conversion.codegen.domain.User\n" //
            + " */\n" //
            + "public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto) {\n"
            + "    if (userDto == null) return null;\n"
            + "    cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getName())) user.setName(userDto.getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAvailable())) user.setAvailable(userDto.getAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getInt2Integer())) user.setInt2Integer(userDto.getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2Long())) user.setLong2Long(userDto.getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2Double())) user.setDouble2Double(userDto.getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getFloat2Float())) user.setFloat2Float(userDto.getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getByte2Byte())) user.setByte2Byte(userDto.getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getShort2Short())) user.setShort2Short(userDto.getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal())) user.setDouble2BigDecimal(userDto.getDouble2BigDecimal().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal2())) user.setDouble2BigDecimal2(userDto.getDouble2BigDecimal2().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal())) user.setLong2BigDecimal(userDto.getLong2BigDecimal().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal2())) user.setLong2BigDecimal2(userDto.getLong2BigDecimal2().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
            + "    return user;\n" + "}");

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.STATIC_METHOD, true),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);

        assertEquals(result, "/**\n" //
            + " * copy properties from argument userDto to argument user\n" //
            + " * @param userDto userDto\n" //
            + " * @param user user\n" //
            + " * @return the argument user\n" //
            + " */\n" //
            + "public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto, cn.featherfly.conversion.codegen.domain.User user) {\n"
            + "    if (user == null || userDto == null) return user;\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getName())) user.setName(userDto.getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getGender())) user.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, userDto.getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getAvailable())) user.setAvailable(userDto.getAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getInt2Integer())) user.setInt2Integer(userDto.getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2Long())) user.setLong2Long(userDto.getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2Double())) user.setDouble2Double(userDto.getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getFloat2Float())) user.setFloat2Float(userDto.getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getByte2Byte())) user.setByte2Byte(userDto.getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getShort2Short())) user.setShort2Short(userDto.getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal())) user.setDouble2BigDecimal(userDto.getDouble2BigDecimal().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getDouble2BigDecimal2())) user.setDouble2BigDecimal2(userDto.getDouble2BigDecimal2().doubleValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal())) user.setLong2BigDecimal(userDto.getLong2BigDecimal().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigDecimal2())) user.setLong2BigDecimal2(userDto.getLong2BigDecimal2().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getLong2BigInteger())) user.setLong2BigInteger(userDto.getLong2BigInteger().longValue());\n"
            + "    return user;\n" + "}");
    }

    @Test
    public void testToTargetWithContent() {
        String result = null;
        BeanCodegen codegen = BeanCodegenImpl.builder().setGenerateJavadoc(false).build();

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.METHOD), UserDto.class.getName(),
            User.class.getName(),
            indent -> indent + "return toUser(new cn.featherfly.conversion.codegen.domain.User());", null, "user");
        System.out.println(result);

        assertEquals(result, "public cn.featherfly.conversion.codegen.domain.User toUser() {\n"
            + "    return toUser(new cn.featherfly.conversion.codegen.domain.User());\n" + "}");

        result = codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(),
            indent -> indent + "return toUser(userDto, new cn.featherfly.conversion.codegen.domain.User());", "userDto",
            "user");
        System.out.println(result);

        assertEquals(result,
            "public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto) {\n"
                + "    return toUser(userDto, new cn.featherfly.conversion.codegen.domain.User());\n" + "}");
    }

    @Test
    public void testFromTarget() {
        String result = null;
        BeanCodegen codegen = BeanCodegenImpl.builder().setGenerateJavadoc(false).build();

        result = codegen.generateFromTarget(new MethodMetadataImpl("UserDto", MethodType.CONSTRUCTOR),
            UserDto.class.getName(), User.class.getName(), properties, null, "user");
        System.out.println(result);

        assertEquals(result, "public UserDto(cn.featherfly.conversion.codegen.domain.User user) {\n"
            + "    if (user == null) return;\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) setName(user.getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) setAvailable(user.isAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) setInt2Integer(user.getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) setLong2Long(user.getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) setDouble2Double(user.getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) setFloat2Float(user.getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) setByte2Byte(user.getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) setShort2Short(user.getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "}");

        result = codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.METHOD),
            UserDto.class.getName(), User.class.getName(), properties, null, "user");
        System.out.println(result);
        assertEquals(result,
            "public cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
                + "    if (user == null) return this;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) setName(user.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) setAvailable(user.isAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) setInt2Integer(user.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) setLong2Long(user.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) setDouble2Double(user.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) setFloat2Float(user.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) setByte2Byte(user.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) setShort2Short(user.getShort2Short());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
                + "    return this;\n" + "}");

        result = codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);
        assertEquals(result,
            "public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
                + "    if (user == null) return null;\n"
                + "    cn.featherfly.conversion.codegen.vo.UserDto userDto = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) userDto.setAvailable(user.isAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) userDto.setInt2Integer(user.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) userDto.setLong2Long(user.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) userDto.setDouble2Double(user.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) userDto.setFloat2Float(user.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) userDto.setByte2Byte(user.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) userDto.setShort2Short(user.getShort2Short());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) userDto.setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) userDto.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) userDto.setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) userDto.setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
                + "    return userDto;\n" + "}");

        result = codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.STATIC_METHOD, true),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);
        assertEquals(result,
            "public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user, cn.featherfly.conversion.codegen.vo.UserDto userDto) {\n"
                + "    if (user == null || userDto == null) return userDto;\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) userDto.setAvailable(user.isAvailable());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) userDto.setInt2Integer(user.getInt2Integer());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) userDto.setLong2Long(user.getLong2Long());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) userDto.setDouble2Double(user.getDouble2Double());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) userDto.setFloat2Float(user.getFloat2Float());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) userDto.setByte2Byte(user.getByte2Byte());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) userDto.setShort2Short(user.getShort2Short());\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) userDto.setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) userDto.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) userDto.setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) userDto.setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
                + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
                + "    return userDto;\n" + "}");
    }

    @Test
    public void testFromTargetWithJavadoc() {
        String result = null;
        BeanCodegen codegen = BeanCodegenImpl.builder().build();

        result = codegen.generateFromTarget(new MethodMetadataImpl("UserDto", MethodType.CONSTRUCTOR),
            UserDto.class.getName(), User.class.getName(), properties, null, "user");
        System.out.println(result);

        assertEquals(result, "/**\n" //
            + " * Instantiates a new cn.featherfly.conversion.codegen.vo.UserDto and copy properties from user\n" //
            + " * @param user user\n" //
            + " */\n" //
            + "public UserDto(cn.featherfly.conversion.codegen.domain.User user) {\n"
            + "    if (user == null) return;\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) setName(user.getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) setAvailable(user.isAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) setInt2Integer(user.getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) setLong2Long(user.getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) setDouble2Double(user.getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) setFloat2Float(user.getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) setByte2Byte(user.getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) setShort2Short(user.getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "}");

        result = codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.METHOD),
            UserDto.class.getName(), User.class.getName(), properties, null, "user");
        System.out.println(result);
        assertEquals(result, "/**\n" //
            + " * copy properties from user to this\n" //
            + " * @param user user\n" //
            + " * @return this\n" //
            + " */\n" //
            + "public cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
            + "    if (user == null) return this;\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) setName(user.getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) setAvailable(user.isAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) setInt2Integer(user.getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) setLong2Long(user.getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) setDouble2Double(user.getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) setFloat2Float(user.getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) setByte2Byte(user.getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) setShort2Short(user.getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    return this;\n" + "}");

        result = codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);
        assertEquals(result, "/**\n" //
            + " * create a new cn.featherfly.conversion.codegen.vo.UserDto and copy properties from user\n" //
            + " * @param user user\n" //
            + " * @return new cn.featherfly.conversion.codegen.vo.UserDto\n" //
            + " */\n" //
            + "public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
            + "    if (user == null) return null;\n"
            + "    cn.featherfly.conversion.codegen.vo.UserDto userDto = new cn.featherfly.conversion.codegen.vo.UserDto();\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) userDto.setAvailable(user.isAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) userDto.setInt2Integer(user.getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) userDto.setLong2Long(user.getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) userDto.setDouble2Double(user.getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) userDto.setFloat2Float(user.getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) userDto.setByte2Byte(user.getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) userDto.setShort2Short(user.getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) userDto.setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) userDto.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) userDto.setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) userDto.setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    return userDto;\n" + "}");

        result = codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.STATIC_METHOD, true),
            UserDto.class.getName(), User.class.getName(), properties, "userDto", "user");
        System.out.println(result);
        assertEquals(result, "/**\n" //
            + " * copy properties from user to userDto\n" //
            + " * @param user user\n" //
            + " * @param userDto userDto\n" //
            + " * @return the argument userDto\n" //
            + " */\n" //
            + "public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user, cn.featherfly.conversion.codegen.vo.UserDto userDto) {\n"
            + "    if (user == null || userDto == null) return userDto;\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getName())) userDto.setName(user.getName());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getGender())) userDto.setGender(cn.featherfly.common.lang.Lang.toEnum(cn.featherfly.conversion.codegen.vo.Gender.class, user.getGender()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.isAvailable())) userDto.setAvailable(user.isAvailable());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getInt2Integer())) userDto.setInt2Integer(user.getInt2Integer());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2Long())) userDto.setLong2Long(user.getLong2Long());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2Double())) userDto.setDouble2Double(user.getDouble2Double());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getFloat2Float())) userDto.setFloat2Float(user.getFloat2Float());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getByte2Byte())) userDto.setByte2Byte(user.getByte2Byte());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getShort2Short())) userDto.setShort2Short(user.getShort2Short());\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal())) userDto.setDouble2BigDecimal(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getDouble2BigDecimal2())) userDto.setDouble2BigDecimal2(java.math.BigDecimal.valueOf(user.getDouble2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal())) userDto.setLong2BigDecimal(java.math.BigDecimal.valueOf(user.getLong2BigDecimal()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigDecimal2())) userDto.setLong2BigDecimal2(java.math.BigDecimal.valueOf(user.getLong2BigDecimal2()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getLong2BigInteger())) userDto.setLong2BigInteger(java.math.BigInteger.valueOf(user.getLong2BigInteger()));\n"
            + "    return userDto;\n" + "}");
    }

    @Test
    public void testFromTargetWithContent() {
        String result = null;
        BeanCodegen codegen = BeanCodegenImpl.builder().setGenerateJavadoc(false).build();

        result = codegen.generateFromTarget(new MethodMetadataImpl("UserDto", MethodType.CONSTRUCTOR),
            UserDto.class.getName(), User.class.getName(), indent -> indent + "fromUser(user);\n", "userDto", "user");
        System.out.println(result);
        assertEquals(result, "public UserDto(cn.featherfly.conversion.codegen.domain.User user) {\n" // 
            + "    fromUser(user);\n" + "}");

        result = codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(),
            indent -> indent + "return fromUser(user, new cn.featherfly.conversion.codegen.vo.UserDto());\n", "userDto",
            "user");
        System.out.println(result);
        assertEquals(result,
            "public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {\n"
                + "    return fromUser(user, new cn.featherfly.conversion.codegen.vo.UserDto());\n" + "}");

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStaticMethdoSourceObjectNameNull() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();

        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toUser", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(), properties, null, "user"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIsStaticAndIsConstructorBothTrue() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();

        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toUser", null), UserDto.class.getName(),
            User.class.getName(), properties, null, "user"));
    }

    @Test
    public void roleDtoToTarget() {
        BeanCodegen codegen = BeanCodegenImpl.builder().build();
        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toRole", MethodType.METHOD),
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

        System.out.println(codegen.generateToTarget(new MethodMetadataImpl("toRole", MethodType.STATIC_METHOD),
            UserDto.class.getName(), User.class.getName(), roleProps, "roleDto", "role"));
        //        assertEquals(codegen.generateToTarget(new MethodMetadataImpl("toRole", MethodType.STATIC_METHOD),
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
        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("RoleDto", MethodType.CONSTRUCTOR),
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

        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("fromRole", MethodType.METHOD),
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

        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("fromRole", MethodType.STATIC_METHOD),
            RoleDto.class.getName(), Role.class.getName(), roleProps, "roleDto", "user"));
        //        assertEquals(codegen.generateFromTarget(new MethodMetadataImpl("fromUser", MethodType.STATIC_METHOD),
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
        System.out.println(codegen.generateFromTarget(new MethodMetadataImpl("RoleDto", MethodType.CONSTRUCTOR),
            RoleDto.class.getName(), Role.class.getName(), roleProps, null, "role"));
    }

    @Test
    public void convertorCodegenFinder() {
        String result = null;
        List<ConvertibleProperty> roleProps = Lang.list( //
            new ConvertiblePropertyImpl("user", new TypeMetadataImpl(UserDto.class), new TypeMetadataImpl(User.class)),
            new ConvertiblePropertyImpl("users", new TypeMetadataImpl(UserDto[].class),
                new TypeMetadataImpl(User[].class)),
            new ConvertiblePropertyImpl("userList", new TypeMetadataImpl(List.class, UserDto.class),
                new TypeMetadataImpl(List.class, User.class))
        //
        );
        String indent = "    ";
        BeanCodegen codegen = BeanCodegenImpl.builder() //
            .setGenerateJavadoc(false) //
            .setIndentSymbol(indent) //
            .addConvertorCodegenFinder((property, source, target, indentStart) -> {
                if (source.endsWith("Dto")) {
                    return new ConvertorCodegen() {

                        @Override
                        public String targetType() {
                            return target;
                        }

                        @Override
                        public String sourceType() {
                            return source;
                        }

                        @Override
                        public boolean isInverse() {
                            return false;
                        }

                        @Override
                        public String generateToTarget(String source, String target) {
                            if (property.sourceType().isArray()) {
                                return source + ".to"
                                    + StringUtils.substringAfterLast(targetType(), ".") + "();";
                            } else if (property.sourceType().isCollection()) {
                                return source + ".to"
                                    + StringUtils.substringAfterLast(targetType(), ".") + "()";
                            } else if (target.endsWith("()")) {
                                String t = target.replaceAll("\\.get", ".set");
                                t = t.substring(0, t.length() - 1);
                                return Str.join(indent, indentStart) + t + source + ".to"
                                    + StringUtils.substringAfterLast(targetType(), ".") + "());";
                            } else {
                                return Str.join(indent, indentStart) + target + " = " + source + ".to"
                                    + StringUtils.substringAfterLast(targetType(), ".") + "();";
                            }
                        }

                        @Override
                        public String generateToSource(String target, String source) {
                            return "new " + sourceType() + "(" + target + ")";
                        }
                    };
                }
                return null;
            })
            .build();

        result = codegen.generateToTarget(new MethodMetadataImpl("toRole", MethodType.METHOD), RoleDto.class.getName(),
            Role.class.getName(), roleProps, null, "role");
        System.out.println(result);
        result =
            codegen.generateFromTarget(new MethodMetadataImpl("toRole", MethodType.METHOD), RoleDto.class.getName(),
                Role.class.getName(), roleProps, null, "role");
        System.out.println(result);
    }
}
