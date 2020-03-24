
package cn.featherfly.conversion;

import java.util.Date;
import java.util.Optional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
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
        u.setUsername(Optional.of("yufei"));

        ToStringBeanPropertyConversion c = new ToStringBeanPropertyConversion(policy);
        BeanProperty<Optional<String>> bpUsername = BeanDescriptor.getBeanDescriptor(u.getClass())
                .getBeanProperty("username");
        BeanProperty<Optional<Date>> bpData1 = BeanDescriptor.getBeanDescriptor(u.getClass()).getBeanProperty("date1");

        System.out.println(c.sourceToTarget(Optional.of("yufei"), bpUsername));
        System.out.println(c.sourceToTarget(Optional.of(new Date()), bpData1));
    }
}
