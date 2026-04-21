
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
import cn.featherfly.conversion.parse.YamlClassParser;

/**
 * ParserTest.
 *
 * @author zhongj
 */
public class YamlClassParserTest {

    ParsePolity parse;

    @SuppressWarnings("rawtypes")
    @BeforeClass
    public void before() {
        parse = new ParsePolity();
        parse.register(new ClassParser());
        parse.register(new JsonClassParser());
        //        parse.register(new JsonBeanPropertyParser());
        parse.register(new YamlClassParser());
        //        parse.register(new YamlBeanPropertyParser());
    }

    @Test
    public void yamlUser() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("yaml_user.txt", YamlClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        User user = parse.parse(content, new ClassType<>(User.class));

        System.out.println(user);

        assertEquals(user.getName(), "test_user_name");
        assertEquals(user.getAge(), new Integer(21));
    }

    @Test(expectedExceptions = ParseException.class)
    public void yamlUserUnknowType() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("yaml_user.txt", YamlClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        User user = parse.parse(content, null);

        System.out.println(user);

        assertEquals(user.getName(), "test_user_name");
        assertEquals(user.getAge(), new Integer(21));
    }

    @Test
    public void yamlUserClass() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("yaml_user_class.txt", YamlClassParserTest.class).getFile());
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
    public void yamlRole() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("yaml_role.txt", YamlClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        Role role = parse.parse(content, new ClassType<>(Role.class));

        System.out.println(role);
        assertEquals(role.getName(), "test_role_name");
        assertEquals(role.getUser().getName(), "test_user_name_in_role");
        assertEquals(role.getUser().getAge(), new Integer(33));
    }

    @Test(expectedExceptions = ParseException.class)
    public void yamlRoleUnknowType() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("yaml_role.txt", YamlClassParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        Role role = parse.parse(content, null);

        System.out.println(role);
        assertEquals(role.getName(), "test_role_name");
        assertEquals(role.getUser().getName(), "test_user_name_in_role");
        assertEquals(role.getUser().getAge(), new Integer(33));
    }

    @Test
    public void yamlRoleClass() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("yaml_role_class.txt", YamlClassParserTest.class).getFile());
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
