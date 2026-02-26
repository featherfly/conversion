
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.Dates;
import cn.featherfly.conversion.convertors.OptionalType;
import cn.featherfly.conversion.string.ToStringBeanPropertyConversion;
import cn.featherfly.conversion.string.ToStringConversionPolicyImpl;
import cn.featherfly.conversion.string.ToStringConversionPolicys;
import cn.featherfly.conversion.string.ToStringTypeConversion;
import cn.featherfly.conversion.vo.User;

/**
 * <p>
 * BasicTest 类的说明放这里
 * </p>
 *
 * @author 钟冀
 */
public class OptionalTest {

    ToStringConversionPolicyImpl policy;

    @BeforeClass
    public void setUp() {
        policy = ToStringConversionPolicys.getBasicConversionPolicy();
    }

    @Test
    public void optiona() {
        String username = "yufei";
        String strdate = "2000-01-02 03:04:05";
        int age = 18;
        Date date = Dates.parseTime(strdate);

        ToStringTypeConversion c = new ToStringTypeConversion(policy);

        assertEquals(c.sourceToTarget(Optional.of(age), String.class), age + "");
        assertEquals(c.sourceToTarget(Optional.of(username), String.class), username);
        assertEquals(c.sourceToTarget(Optional.of(date), String.class), strdate);

        assertEquals(c.targetToSource("18", int.class), age);
        assertEquals(c.targetToSource("18", new OptionalType<>(int.class)), Optional.of(age));

        assertEquals(c.targetToSource(strdate, Date.class), date);
        assertEquals(c.targetToSource(strdate, new OptionalType<>(Date.class)), Optional.of(date));

        assertEquals(c.targetToSource(username, String.class), username);
        assertEquals(c.targetToSource(username, new OptionalType<>(String.class)), Optional.of(username));
    }

    @Test
    public void optionaBeanProperty() {
        User u = new User();
        String username = "yufei";
        u.setUsername(Optional.of(username));

        ToStringBeanPropertyConversion c = new ToStringBeanPropertyConversion(policy);
        BeanProperty<User,
            Optional<String>> bpUsername = BeanDescriptor.getBeanDescriptor(u.getClass()).getBeanProperty("username");
        BeanProperty<User,
            Optional<Date>> bpDate1 = BeanDescriptor.getBeanDescriptor(u.getClass()).getBeanProperty("date1");

        String strdate = "2000-01-02 03:04:05";
        Date date = Dates.parseTime(strdate);

        assertEquals(c.sourceToTarget(Optional.of(username), bpUsername, String.class), username);
        assertEquals(c.sourceToString(Optional.of("yufei"), bpUsername), username);
        assertEquals(c.sourceToTarget(Optional.of(date), bpDate1, String.class), strdate);
        assertEquals(c.sourceToString(Optional.of(date), bpDate1), strdate);

        assertEquals(c.targetToSource(strdate, bpDate1), Optional.of(date));
        assertEquals(c.targetToSource(username, bpUsername), Optional.of(username));

    }
}
