
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.Dates;
import cn.featherfly.conversion.string.ToStringBeanPropertyConversion;
import cn.featherfly.conversion.string.ToStringConversionPolicy;
import cn.featherfly.conversion.string.ToStringConversionPolicys;
import cn.featherfly.conversion.vo.User;

/**
 * <p>
 * BasicTest 类的说明放这里
 * </p>
 *
 * @author 钟冀
 */
public class BasicTest2 {

    ToStringConversionPolicy policy;

    @BeforeClass
    public void setUp() {
        policy = ToStringConversionPolicys.getBasicConversionPolicy();
    }

    @Test
    public void testOptional() {
        User u = new User();
        String username = "yufei";
        u.setUsername(Optional.of(username));

        ToStringBeanPropertyConversion c = new ToStringBeanPropertyConversion(policy);
        BeanProperty<User,
            Optional<String>> bpUsername = BeanDescriptor.getBeanDescriptor(u.getClass()).getBeanProperty("username");
        BeanProperty<User,
            Optional<Date>> bpData1 = BeanDescriptor.getBeanDescriptor(u.getClass()).getBeanProperty("date1");

        String strdate = "2000-01-02 03:04:05";
        Date date = Dates.parseTime(strdate);

        assertEquals(c.sourceToTarget(Optional.of(username), bpUsername, String.class), username);
        assertEquals(c.sourceToString(Optional.of("yufei"), bpUsername), username);
        assertEquals(c.sourceToTarget(Optional.of(date), bpData1, String.class), strdate);
        assertEquals(c.sourceToString(Optional.of(date), bpData1), strdate);

        //        System.out.println(c.sourceToTarget(Optional.of("yufei"), bpUsername, String.class));
        //        System.out.println(c.sourceToString(Optional.of("yufei"), bpUsername));
        //        System.out.println(c.sourceToTarget(Optional.of(date), bpData1, String.class));
        //        System.out.println(c.sourceToString(Optional.of(date), bpData1));
    }
}
