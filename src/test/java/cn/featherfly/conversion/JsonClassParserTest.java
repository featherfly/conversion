
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yufei.Role;
import org.yufei.User;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.conversion.parse.ClassParser;
import cn.featherfly.conversion.parse.JsonClassParser;
import cn.featherfly.conversion.parse.ParseException;
import cn.featherfly.conversion.parse.ParsePolity;

/**
 * ParserTest.
 *
 * @author zhongj
 */
public class JsonClassParserTest {

    ParsePolity parse;

    @BeforeClass
    public void before() {
        parse = new ParsePolity();
        parse.register(new ClassParser());
        parse.register(new JsonClassParser());
    }

    @Test
    public void jsonUser() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("json_user.txt", JsonClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        User user = parse.parse(content, new ClassType<>(User.class));

        System.out.println(user);

        assertEquals(user.getName(), "test_user_name");
        assertEquals(user.getAge(), new Integer(21));
    }

    @Test(expectedExceptions = ParseException.class)
    public void jsonUserUnknowType() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("json_user.txt", JsonClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        User user = parse.parse(content, null);

        System.out.println(user);

        assertEquals(user.getName(), "test_user_name");
        assertEquals(user.getAge(), new Integer(21));
    }

    @Test
    public void jsonUserClass() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("json_user_class.txt", JsonClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        User user = parse.parse(content, new ClassType<>(User.class));

        System.out.println(user);

        assertEquals(user.getName(), "test_user_name");
        assertEquals(user.getAge(), new Integer(21));

        user = parse.parse(content, null);

        System.out.println(user);

        assertEquals(user.getName(), "test_user_name");
        assertEquals(user.getAge(), new Integer(21));
    }

    @Test
    public void jsonRole() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("json_role.txt", JsonClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        Role role = parse.parse(content, new ClassType<>(Role.class));

        System.out.println(role);
        assertEquals(role.getName(), "test_role_name");
        assertEquals(role.getUser().getName(), "test_user_name_in_role");
        assertEquals(role.getUser().getAge(), new Integer(33));
    }

    @Test(expectedExceptions = ParseException.class)
    public void jsonRoleUnknowType() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("json_role.txt", JsonClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        Role role = parse.parse(content, null);

        System.out.println(role);
        assertEquals(role.getName(), "test_role_name");
        assertEquals(role.getUser().getName(), "test_user_name_in_role");
        assertEquals(role.getUser().getAge(), new Integer(33));
    }

    @Test
    public void jsonRoleClass() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("json_role_class.txt", JsonClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        Role role = parse.parse(content, new ClassType<>(Role.class));

        System.out.println(role);
        assertEquals(role.getName(), "test_role_name");
        assertEquals(role.getUser().getName(), "test_user_name_in_role");
        assertEquals(role.getUser().getAge(), new Integer(33));

        role = parse.parse(content, null);

        System.out.println(role);
        assertEquals(role.getName(), "test_role_name");
        assertEquals(role.getUser().getName(), "test_user_name_in_role");
        assertEquals(role.getUser().getAge(), new Integer(33));
    }
}
