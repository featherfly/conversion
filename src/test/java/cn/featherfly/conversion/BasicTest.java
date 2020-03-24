
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.DateUtils;
import cn.featherfly.conversion.string.ToStringBeanPropertyConversion;
import cn.featherfly.conversion.string.ToStringConversionPolicy;
import cn.featherfly.conversion.string.ToStringConversionPolicys;
import cn.featherfly.conversion.string.ToStringTypeConversion;
import cn.featherfly.conversion.string.basic.ClassConvertor;
import cn.featherfly.conversion.string.basic.EnumConvertor;
import cn.featherfly.conversion.string.basic.IntArrayConvertor;
import cn.featherfly.conversion.string.basic.IntConvertor;
import cn.featherfly.conversion.string.basic.IntegerConvertor;
import cn.featherfly.conversion.string.basic.StringConvertor;
import cn.featherfly.conversion.string.format.DateFormatConvertor;
import cn.featherfly.conversion.vo.Sex;
import cn.featherfly.conversion.vo.User;

/**
 * <p>
 * BasicTest 类的说明放这里
 * </p>
 *
 * @author 钟冀
 */
public class BasicTest {

    ToStringConversionPolicy policy;

    @BeforeClass
    public void setUp() {
        //        policy = ToStringConversionPolicys.getBasicConversionPolicy();
        policy = new ToStringConversionPolicy();
        policy.addConvertors(new IntConvertor(), new IntegerConvertor(), new ClassConvertor(), new StringConvertor(),
                new DateFormatConvertor(), new IntArrayConvertor(), new EnumConvertor<>());
    }

    @Test
    public void testTypeConversion() {
        ToStringTypeConversion convertor = new ToStringTypeConversion();
        //        convertor.setConversionPolicy(policy);

        assertEquals(new Integer(12), convertor.targetToSource("12", Integer.class));
        assertEquals("12", convertor.sourceToTarget(12, Integer.class));

        assertEquals(Sex.male, convertor.targetToSource("male", Sex.class));
        assertEquals("female", convertor.sourceToTarget(Sex.female, Sex.class));

        assertEquals(new Integer[] { 1, 2, 3, 4, 5 }, convertor.targetToSource("1,2,3,4,5", Integer[].class));
        assertEquals("5,4,3,2,1", convertor.sourceToTarget(new Integer[] { 5, 4, 3, 2, 1 }, Integer[].class));

        String className = User.class.getName();
        assertEquals(User.class, convertor.targetToSource(className, Class.class));

        assertEquals(className, convertor.sourceToTarget(User.class, Class.class));
    }

    @Test
    public void testBeanPropertyConversion() {
        ToStringBeanPropertyConversion beanPropertyConversion = new ToStringBeanPropertyConversion();
        beanPropertyConversion.setConversionPolicy(policy);

        BeanDescriptor<User> bd = BeanDescriptor.getBeanDescriptor(User.class);

        BeanProperty<Integer> beanProperty = null;

        beanProperty = bd.getBeanProperty("age");
        assertEquals(new Integer(18), beanPropertyConversion.targetToSource("18", beanProperty));
        assertEquals("18", beanPropertyConversion.sourceToTarget(18, beanProperty));

        BeanProperty<Sex> beanProperty2 = null;
        beanProperty2 = bd.getBeanProperty("sex");
        assertEquals(Sex.male, beanPropertyConversion.targetToSource("male", beanProperty2));
        assertEquals(Sex.male, beanPropertyConversion.targetToSource("0", beanProperty2));
        assertEquals("female", beanPropertyConversion.sourceToTarget(Sex.female, beanProperty2));
    }

    @Test
    public void testFormatConversion() {
        ToStringBeanPropertyConversion beanPropertyConversion = new ToStringBeanPropertyConversion();
        beanPropertyConversion.setConversionPolicy(policy);

        BeanDescriptor<User> bd = BeanDescriptor.getBeanDescriptor(User.class);

        BeanProperty<Date> beanProperty = bd.getBeanProperty("date");
        Date date1 = DateUtils.getTime(2000, 1, 1, 0, 0, 0);
        Date date2 = DateUtils.getTime(2012, 12, 12, 0, 0, 0);
        assertNull(beanPropertyConversion.targetToSource("2000年1月1日", beanProperty));
        assertNull(beanPropertyConversion.targetToSource("2000年01月1日", beanProperty));
        assertNull(beanPropertyConversion.sourceToTarget(date2, beanProperty));

        beanPropertyConversion.setConversionPolicy(ToStringConversionPolicys.getFormatConversionPolicy());
        assertEquals(date1.toString(), beanPropertyConversion.targetToSource("2000年1月1日", beanProperty).toString());
        assertEquals("2012年12月12日", beanPropertyConversion.sourceToTarget(date2, beanProperty));

        BeanProperty<Integer> bpsalary = bd.getBeanProperty("salary");
        Integer salary = new Integer(1234567890);
        String s = "1234567890";
        String s2 = "1,234,567,890";
        assertEquals(s2, beanPropertyConversion.sourceToTarget(salary, bpsalary));
        assertEquals(salary, beanPropertyConversion.targetToSource(s, bpsalary));
        assertEquals(salary, beanPropertyConversion.targetToSource(s2, bpsalary));

        BeanProperty<Integer> bpage = bd.getBeanProperty("age");
        int age = 12345;
        String a1 = "12345";
        String a2 = "1,23,45";
        assertEquals(a2, beanPropertyConversion.sourceToTarget(age, bpage));
        assertEquals(age, (int) beanPropertyConversion.targetToSource(a1, bpage));
        assertEquals(age, (int) beanPropertyConversion.targetToSource(a2, bpage));

        String ds1 = "2000年1月1日,2002-2-2";
        String ds2 = "2000-01-01,2002-02-02";
        date1 = DateUtils.getTime(2000, 1, 1, 0, 0, 0);
        date2 = DateUtils.getTime(2002, 2, 2, 0, 0, 0);
        BeanProperty<Date[]> bpDates = bd.getBeanProperty("dates");
        assertEquals(ArrayUtils.toString(date1, date2),
                ArrayUtils.toString(beanPropertyConversion.targetToSource(ds1, bpDates)));

        assertEquals(ds2, beanPropertyConversion.sourceToTarget(new Date[] { date1, date2 }, bpDates));

        // sql date
        BeanProperty<java.sql.Date> bpsqldate = bd.getBeanProperty("sqlDate");
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        assertEquals(sqlDate.toString(), beanPropertyConversion.targetToSource("2000-1-1", bpsqldate).toString());
        assertEquals("2000-01-01", beanPropertyConversion.sourceToTarget(sqlDate, bpsqldate));

        BeanProperty<java.sql.Date> bpsqldate2 = bd.getBeanProperty("sqlDate2");
        assertEquals(sqlDate.toString(), beanPropertyConversion.targetToSource("2000年1月1日", bpsqldate2).toString());
        assertEquals(sqlDate.toString(), beanPropertyConversion.targetToSource("2000/1/1", bpsqldate2).toString());
        assertEquals("2000年01月01日", beanPropertyConversion.sourceToTarget(sqlDate, bpsqldate2));

        //sql time
        BeanProperty<Time> bptime = bd.getBeanProperty("time");
        Time time = new Time(DateUtils.getTime(2002, 2, 2, 14, 15, 16).getTime());
        assertEquals(time.toString(), beanPropertyConversion.targetToSource("14:15:16", bptime).toString());
        assertEquals("14:15:16", beanPropertyConversion.sourceToTarget(time, bptime));

        BeanProperty<Time> time2 = bd.getBeanProperty("time2");
        assertEquals(time.toString(), beanPropertyConversion.targetToSource("14时15分16秒", time2).toString());
        assertEquals(time.toString(), beanPropertyConversion.targetToSource("14:15:16", time2).toString());
        assertEquals("14时15分16秒", beanPropertyConversion.sourceToTarget(time, time2));

        //sql timestamp
        BeanProperty<Timestamp> bptimestamp = bd.getBeanProperty("timestamp");
        Timestamp timestamp = new Timestamp(DateUtils.getTime(2002, 2, 2, 14, 15, 16).getTime());
        assertEquals(DateUtils.formartTime(timestamp),
                DateUtils.formartTime(beanPropertyConversion.targetToSource("2002-2-2 14:15:16", bptimestamp)));
        assertEquals("2002-02-02 14:15:16", beanPropertyConversion.sourceToTarget(timestamp, bptimestamp));

        BeanProperty<Timestamp> bptimestamp2 = bd.getBeanProperty("timestamp2");
        assertEquals(DateUtils.formartTime(timestamp),
                DateUtils.formartTime(beanPropertyConversion.targetToSource("2002年2月2日 14时15分16秒", bptimestamp2)));
        assertEquals(DateUtils.formartTime(timestamp),
                DateUtils.formartTime(beanPropertyConversion.targetToSource("2002/2/2 14:15:16", bptimestamp2)));
        assertEquals("2002年02月02日 14时15分16秒", beanPropertyConversion.sourceToTarget(timestamp, bptimestamp2));

    }

    @Test(expectedExceptions = ConversionException.class)
    public void testAssignConversion() {
        ToStringBeanPropertyConversion beanPropertyConversion = new ToStringBeanPropertyConversion();
        beanPropertyConversion.setConversionPolicy(policy);

        BeanDescriptor<User> bd = BeanDescriptor.getBeanDescriptor(User.class);

        BeanProperty<String> beanProperty = bd.getBeanProperty("name");
        System.out.println(beanPropertyConversion.targetToSource("yufei", beanProperty));
        System.out.println(beanPropertyConversion.sourceToTarget("yufei", beanProperty));
    }

}
