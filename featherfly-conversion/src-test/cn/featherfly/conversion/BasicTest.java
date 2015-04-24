
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.DateUtils;
import cn.featherfly.conversion.basic.ClassConvertor;
import cn.featherfly.conversion.basic.EnumConvertor;
import cn.featherfly.conversion.basic.IntArrayConvertor;
import cn.featherfly.conversion.basic.IntConvertor;
import cn.featherfly.conversion.basic.IntegerConvertor;
import cn.featherfly.conversion.basic.StringConvertor;
import cn.featherfly.conversion.format.DateFormatConvertor;

/**
 * <p>
 * BasicTest
 * 类的说明放这里
 * </p>
 * 
 * @author 钟冀
 */
public class BasicTest {

    ConversionPolicy policy;
    
    @BeforeClass
    public void setUp() {
        policy = new ConversionPolicy();
        policy.addConvertors(
                new IntConvertor(), new IntegerConvertor()
                , new ClassConvertor(), new StringConvertor()
                , new DateFormatConvertor()
                , new IntArrayConvertor()
                , new EnumConvertor()
        );
    }
    
    @Test
    public void testTypeConversion() {
        TypeConversion convertor = new TypeConversion();
//        convertor.setConversionPolicy(policy);
        
        assertEquals(new Integer(12), convertor.toObject("12", Integer.class));
        assertEquals("12", convertor.toString(12, Integer.class));
        
        assertEquals(Sex.male, convertor.toObject("male", Sex.class));
        assertEquals("female", convertor.toString(Sex.female, Sex.class));

        assertEquals(new Integer[]{1,2,3,4,5} , convertor.toObject("1,2,3,4,5", Integer[].class));
        assertEquals("5,4,3,2,1" , convertor.toString(new Integer[]{5,4,3,2,1}, Integer[].class));
        
        String className = User.class.getName();
        assertEquals(User.class , convertor.toObject(className, Class.class));
        
        assertEquals(className , convertor.toString(User.class, Class.class));
    }
    @Test
    public void testBeanPropertyConversion() {
        BeanPropertyConversion beanPropertyConversion = new BeanPropertyConversion();
        beanPropertyConversion.setConversionPolicy(policy);

        BeanDescriptor<User> bd = BeanDescriptor.getBeanDescriptor(User.class);
        
        BeanProperty<?> beanProperty = null;
        
        beanProperty = bd.getBeanProperty("age");
        assertEquals(new Integer(18), beanPropertyConversion.toObject("18", beanProperty));
        assertEquals("18", beanPropertyConversion.toString(18, beanProperty));

        beanProperty = bd.getBeanProperty("sex");
        assertEquals(Sex.male, beanPropertyConversion.toObject("male", beanProperty));
        assertEquals("female", beanPropertyConversion.toString(Sex.female, beanProperty));
    }
    @Test
    public void testFormatConversion() {
        BeanPropertyConversion beanPropertyConversion = new BeanPropertyConversion();
        beanPropertyConversion.setConversionPolicy(policy);
        
        BeanDescriptor<User> bd = BeanDescriptor.getBeanDescriptor(User.class);
        
        BeanProperty<?> beanProperty = bd.getBeanProperty("date");
        Date date1 = DateUtils.getTime(2000, 1, 1, 0, 0 , 0);
        Date date2 = DateUtils.getTime(2012, 12, 12, 0, 0 , 0);
        assertNull(beanPropertyConversion.toObject("2000年1月1日", beanProperty));
        assertNull(beanPropertyConversion.toObject("2000年01月1日", beanProperty));
        assertNull(beanPropertyConversion.toString(date2, beanProperty));        
        
        beanPropertyConversion.setConversionPolicy(ConversionPolicys.getFormatConversionPolicy());        
        assertEquals(date1.toString(), beanPropertyConversion.toObject("2000年1月1日", beanProperty).toString());
        assertEquals("2012年12月12日", beanPropertyConversion.toString(date2, beanProperty));

        beanProperty = bd.getBeanProperty("salary");
        Integer salary = new Integer(1234567890);
        String s = "1234567890";
        String s2 = "1,234,567,890";
        assertEquals(s2, beanPropertyConversion.toString(salary, beanProperty));
        assertEquals(salary, beanPropertyConversion.toObject(s, beanProperty));
        assertEquals(salary, beanPropertyConversion.toObject(s2, beanProperty));
        
        beanProperty = bd.getBeanProperty("age");
        int age = 12345;
        String a1 = "12345";
        String a2 = "1,23,45";
        assertEquals(a2, beanPropertyConversion.toString(age, beanProperty));
        assertEquals(age, beanPropertyConversion.toObject(a1, beanProperty));
        assertEquals(age, beanPropertyConversion.toObject(a2, beanProperty));
        
        String ds1 = "2000年1月1日,2002-2-2";
        String ds2 = "2000-01-01,2002-02-02";
        date1 = DateUtils.getTime(2000, 1, 1, 0, 0 , 0);
        date2 = DateUtils.getTime(2002, 2, 2, 0, 0 , 0);
        beanProperty = bd.getBeanProperty("dates");
        assertEquals(ArrayUtils.toString(date1, date2)
                , ArrayUtils.toString(beanPropertyConversion.toObject(ds1, beanProperty)));
        assertEquals(ds2, beanPropertyConversion.toString(new Date[] {date1, date2}, beanProperty));
    }
    
    @Test(expectedExceptions = ConversionException.class)
    public void testAssignConversion() {
        BeanPropertyConversion beanPropertyConversion = new BeanPropertyConversion();
        beanPropertyConversion.setConversionPolicy(policy);
        
        BeanDescriptor<User> bd = BeanDescriptor.getBeanDescriptor(User.class);
        
        BeanProperty<?> beanProperty = bd.getBeanProperty("name");
        System.out.println(beanPropertyConversion.toObject("yufei", beanProperty));
        System.out.println(beanPropertyConversion.toString("yufei", beanProperty));
    }
}
