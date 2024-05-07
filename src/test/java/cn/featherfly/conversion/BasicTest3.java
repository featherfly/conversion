
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        long num = 123456L;
        long result = c.targetToSource(num + "", Long.class);
        assertEquals(result, num);
        //        System.out.println(c.targetToSource("123456", new ClassType<>(Long.class)));

    }
}
