
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-13 15:10:13
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.property;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * BigDecimalToLongPropertyCodegenTest.
 *
 * @author zhongj
 */
public class BigDecimalToLongPropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void testPrimitive() {
        BigDecimalToLongPropertyCodegen dateToLong = new BigDecimalToLongPropertyCodegen(Long.TYPE);
        fromTarget = dateToLong.generateFromTarget("price", "orderDto", "order");
        toTarget = dateToLong.generateToTarget("price", "orderDto", "order");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(order.getPrice())) orderDto.setPrice(java.math.BigDecimal.valueOf(order.getPrice()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(orderDto.getPrice())) order.setPrice(orderDto.getPrice().longValue());");

        BigDecimalToLongPropertyCodegen stringToDate = new BigDecimalToLongPropertyCodegen(Long.TYPE, true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(user.getCreateTime().longValue());");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(java.math.BigDecimal.valueOf(userDto.getCreateTime()));");
    }

    @Test
    public void testWrapper() {
        BigDecimalToLongPropertyCodegen dateToLong = new BigDecimalToLongPropertyCodegen(Long.class);
        fromTarget = dateToLong.generateFromTarget("price", "orderDto", "order");
        toTarget = dateToLong.generateToTarget("price", "orderDto", "order");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(order.getPrice())) orderDto.setPrice(java.math.BigDecimal.valueOf(order.getPrice()));");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(orderDto.getPrice())) order.setPrice(orderDto.getPrice().longValue());");

        BigDecimalToLongPropertyCodegen stringToDate = new BigDecimalToLongPropertyCodegen(Long.TYPE, true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) userDto.setCreateTime(user.getCreateTime().longValue());");
        assertEquals(toTarget,
            "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) user.setCreateTime(java.math.BigDecimal.valueOf(userDto.getCreateTime()));");
    }
}
