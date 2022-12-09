
package cn.featherfly.conversion;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.conversion.string.ToStringBeanPropertyConversion;
import cn.featherfly.conversion.string.ToStringConversionPolicy;
import cn.featherfly.conversion.string.ToStringConversionPolicys;

/**
 * @author 钟冀
 */
public class BasicTest3 {

    ToStringConversionPolicy policy;

    @BeforeClass
    public void setUp() {
        policy = ToStringConversionPolicys.getFormatConversionPolicy();
    }

    @Test(expectedExceptions = ConversionException.class)
    public void test1() {
        ToStringBeanPropertyConversion c = new ToStringBeanPropertyConversion(policy);

        System.out.println(c.targetToSource("123456", new ClassType<>(Long.class)));

    }
}
