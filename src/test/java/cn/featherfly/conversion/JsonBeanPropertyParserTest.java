
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yufei.Actor;
import org.yufei.Role;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.conversion.parse.JsonBeanPropertyParser;
import cn.featherfly.conversion.parse.ParsePolity;

/**
 * ParserTest.
 *
 * @author zhongj
 */
public class JsonBeanPropertyParserTest {

    ParsePolity parse;

    @BeforeClass
    public void before() {
        parse = new ParsePolity();
        parse.register(new JsonBeanPropertyParser());
    }

    @Test
    public void jsonBeanPropertyParser() throws IOException {

        File file = new File(
            ClassLoaderUtils.getResource("json_bean_property.txt", JsonBeanPropertyParserTest.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        BeanDescriptor<Role> bd = BeanDescriptor.getBeanDescriptor(Role.class);
        BeanProperty<Role, Actor[]> bp = bd.getBeanProperty("actors");
        Actor[] actors = parse.parse(content, bp);

        System.out.println(ArrayUtils.toString(actors));
        assertEquals(actors[0].getName(), "actors1");
        assertEquals(actors[1].getName(), "actors2");
    }
}
