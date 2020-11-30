
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yufei.Actor;
import org.yufei.Person;
import org.yufei.Role;
import org.yufei.User;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.conversion.parse.ClassParser;
import cn.featherfly.conversion.parse.JsonClassParser;
import cn.featherfly.conversion.parse.ParsePolity;
import cn.featherfly.conversion.parse.YamlBeanPropertyParser;
import cn.featherfly.conversion.parse.YamlClassParser;

/**
 * <p>
 * ParserTest
 * </p>
 *
 * @author zhongj
 */
public class ParserTest2 {

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
    public void test() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("test1.txt", ParserTest2.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        User user = parse.parse(content, new GenericClass<>(User.class));

        System.out.println(user);

        assertEquals(user.getName(), "test_user_name");
        assertEquals(user.getAge(), new Integer(21));
    }

    @Test
    public void test2() throws IOException {
        File file = new File(ClassLoaderUtils.getResource("test2.txt", ParserTest2.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        Role role = parse.parse(content, new GenericClass<>(Role.class));

        System.out.println(role);
        assertEquals(role.getName(), "test_role_name");
        assertEquals(role.getUser().getName(), "test_user_name_in_role");
        assertEquals(role.getUser().getAge(), new Integer(33));
    }

    @Test
    public void test3() throws IOException {
        parse.unregister(new YamlClassParser());
        parse.register(new YamlBeanPropertyParser());

        File file = new File(ClassLoaderUtils.getResource("test3.txt", ParserTest2.class).getFile());
        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        BeanDescriptor<Role> bd = BeanDescriptor.getBeanDescriptor(Role.class);
        BeanProperty<Actor[]> bp = bd.getBeanProperty("actors");
        Actor[] actors = parse.parse(content, bp);

        System.out.println(ArrayUtils.toString(actors));
        assertEquals(actors[0].getName(), "actors1");
        assertEquals(actors[1].getName(), "actors2");
    }

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        //        File file = new File(ClassLoaderUtils.getResource("test3.txt", ParserTest2.class).getFile());
        //        String content = org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        Person[] persons = new Person[2];
        Actor[] actors = new Actor[2];
        for (int i = 0; i < 2; i++) {
            Person u = new Person();
            u.setName("name" + i);
            u.setAge(i);
            actors[i] = u;
            persons[i] = u;
        }
        System.out.println(ArrayUtils.toString(actors));
        System.out.println(ArrayUtils.toString(persons));

        BeanDescriptor<Role> bd = BeanDescriptor.getBeanDescriptor(Role.class);
        BeanProperty<Actor[]> toBeanProperty = bd.getBeanProperty("actors");

        Type toType = null;

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        if (toBeanProperty.getField().getType().isArray()) {
            toType = Array.newInstance(Person.class, 0).getClass();
        } else {
            toType = createParameterizedType(toBeanProperty.getField().getType(), null, Person.class);
        }

        if (toType instanceof ParameterizedType) {
            final Type parameterizedType = toType;
            mapper.writerFor(new TypeReference<Actor[]>() {
                /**
                 * {@inheritDoc}
                 */
                @Override
                public Type getType() {
                    return parameterizedType;
                }
            }).writeValue(System.out, actors);
        } else {
            System.out.println(actors.getClass());
            String yaml = mapper.writerFor(actors.getClass()).writeValueAsString(actors);
            //            mapper.writerFor((Class<?>) toType).writeValue(System.out, actors);
            String yaml2 = mapper.writerFor(persons.getClass()).writeValueAsString(persons);
            System.out.println("yaml \n " + yaml);
            System.out.println("yam2 \n " + yaml2);

            System.out.println(toType);

            actors = mapper.readerFor((Class<?>) toType).readValue(yaml);
            System.out.println(ArrayUtils.toString(actors));

            actors = mapper.readerFor((Class<?>) toType).readValue(yaml2);
            System.out.println(ArrayUtils.toString(actors));

            persons = mapper.readerFor(persons.getClass()).readValue(yaml2);
            System.out.println(ArrayUtils.toString(persons));

            actors = mapper.readerFor(new TypeReference<Actor[]>() {
                /**
                 * {@inheritDoc}
                 */
                @Override
                public Type getType() {
                    return (GenericArrayType) () -> Person.class;
                }
            }).readValue(yaml2);
            System.out.println(ArrayUtils.toString(actors));
        }

    }

    protected static ParameterizedType createParameterizedType(final Type rawType, final Type ownerType,
            final Type... ctualTypeArguments) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return ctualTypeArguments;
            }

            @Override
            public Type getRawType() {
                return rawType;
            }

            @Override
            public Type getOwnerType() {
                return ownerType;
            }
        };
    }
}
