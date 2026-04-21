
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.lang.reflect.Modifier;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yufei.User;

import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.conversion.parse.ClassFieldParser;
import cn.featherfly.conversion.parse.ClassMethodParser;
import cn.featherfly.conversion.parse.ClassParser;
import cn.featherfly.conversion.parse.ParsePolity;
import cn.featherfly.conversion.vo.Constants.Constant;
import cn.featherfly.conversion.vo.Constants2;

/**
 * ParserTest.
 *
 * @author zhongj
 */
public class ParserTest {

    ParsePolity parse;

    @BeforeClass
    public void before() {
        parse = new ParsePolity();
        parse.register(new ClassParser());
        parse.register(new ClassFieldParser());
        parse.register(new ClassMethodParser());
    }

    @Test
    public void classParse() {
        User user = parse.parse("class:org.yufei.User", new ClassType<>(User.class));
        assertNotNull(user);
        assertEquals(user.getClass(), User.class);
    }

    @Test
    public void classParser() {
        ClassParser classParser = new ClassParser();
        User user = classParser.parse("org.yufei.User", new ClassType<>(User.class));
        assertNotNull(user);
        assertEquals(user.getClass(), User.class);
    }

    @Test
    public void classFieldParse() {
        int value = parse.parse("field:java.lang.reflect.Modifier.FINAL", new ClassType<>(int.class));
        assertEquals(value, Modifier.FINAL);

        String name = parse.parse("field:cn.featherfly.conversion.vo.Constants$Constant.NAME",
            new ClassType<>(String.class));
        assertEquals(name, Constant.NAME);

        name = parse.parse("field:cn.featherfly.conversion.vo.Constants.CONSTANTS2.NAME",
            new ClassType<>(String.class));
        assertEquals(name, Constants2.NAME);
    }

    @Test
    public void classFieldParser() {
        ClassFieldParser classConstantParser = new ClassFieldParser();
        int value = classConstantParser.parse("java.lang.reflect.Modifier.FINAL", new ClassType<>(int.class));
        assertEquals(value, Modifier.FINAL);

        String name = classConstantParser.parse("cn.featherfly.conversion.vo.Constants$Constant.NAME",
            new ClassType<>(String.class));
        assertEquals(name, Constant.NAME);

        name = classConstantParser.parse("cn.featherfly.conversion.vo.Constants.CONSTANTS2.NAME",
            new ClassType<>(String.class));
        assertEquals(name, Constants2.NAME);
    }

    @Test
    public void classMethodParse() {
        String name = parse.parse("method:cn.featherfly.conversion.vo.Constants.name",
            new ClassType<>(String.class));
        System.out.println(name);
        assertEquals(name, cn.featherfly.conversion.vo.Constants.name());
    }

    @Test
    public void classMethodParser() {
        ClassMethodParser classConstantParser = new ClassMethodParser();

        String name = classConstantParser.parse("cn.featherfly.conversion.vo.Constants.name",
            new ClassType<>(String.class));
        System.out.println(name);
        assertEquals(name, cn.featherfly.conversion.vo.Constants.name());

        //        name = classConstantParser.parse("cn.featherfly.conversion.Constants.CONSTANTS2.NAME",
        //                new ClassType<>(String.class));
        //        assertEquals(name, Constants2.NAME);
    }

}
