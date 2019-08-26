
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Modifier;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.conversion.vo.Constants.Constant;
import main.java.cn.featherfly.conversion.parse.ClassFieldParser;
import main.java.cn.featherfly.conversion.parse.ClassMethodParser;
import cn.featherfly.conversion.vo.Constants2;

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
public class ParserTest {

    @Test
    public void testClassFieldParser() {
        ClassFieldParser<GenericType<?>> classConstantParser = new ClassFieldParser<>();
        int value = classConstantParser.parse("java.lang.reflect.Modifier.FINAL", new GenericClass<>(int.class));
        assertEquals(value, Modifier.FINAL);

        String name = classConstantParser.parse("cn.featherfly.conversion.vo.Constants$Constant.NAME",
                new GenericClass<>(String.class));
        assertEquals(name, Constant.NAME);

        name = classConstantParser.parse("cn.featherfly.conversion.vo.Constants.CONSTANTS2.NAME",
                new GenericClass<>(String.class));
        assertEquals(name, Constants2.NAME);
    }

    @Test
    public void testClassMethodParser() {
        ClassMethodParser<GenericType<?>> classConstantParser = new ClassMethodParser<>();

        String name = classConstantParser.parse("cn.featherfly.conversion.vo.Constants.name",
                new GenericClass<>(String.class));
        System.out.println(name);
        assertEquals(name, cn.featherfly.conversion.vo.Constants.name());

        //        name = classConstantParser.parse("cn.featherfly.conversion.Constants.CONSTANTS2.NAME",
        //                new GenericClass<>(String.class));
        //        assertEquals(name, Constants2.NAME);
    }

}
