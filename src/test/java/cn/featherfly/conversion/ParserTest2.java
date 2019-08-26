
package cn.featherfly.conversion;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yufei.Role;
import org.yufei.User;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.conversion.parse.ClassParser;
import cn.featherfly.conversion.parse.JsonClassParser;
import cn.featherfly.conversion.parse.ParsePolity;
import cn.featherfly.conversion.parse.YamlClassParser;

/**
 * <p>
 * ParserTest
 * </p>
 * <p>
 * 2019-08-26
 * </p>
 *
 * @author zhongj
 */
public class ParserTest2 {

    ParsePolity parse;

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
    public void test() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("test1.txt", ParserTest2.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        User user = parse.parse(content, new GenericClass<>(User.class));

        System.out.println(user);
    }

    @Test
    public void test2() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("test2.txt", ParserTest2.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        Role user = parse.parse(content, new GenericClass<>(Role.class));

        System.out.println(user);
    }

    @Test
    public void testClassMethodParser() {

    }

}
