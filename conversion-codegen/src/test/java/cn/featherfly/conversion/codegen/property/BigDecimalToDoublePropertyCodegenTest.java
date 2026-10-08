
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
 * BigDecimalToDoublePropertyCodegenTest.
 *
 * @author zhongj
 */
public class BigDecimalToDoublePropertyCodegenTest extends PropertyCodegenTest {

    @Test
    public void testPrimitive() {
        BigDecimalToDoublePropertyCodegen dateToLong = new BigDecimalToDoublePropertyCodegen(Double.TYPE);
        fromTarget = dateToLong.generateFromTarget("price", "orderDto", "order");
        toTarget = dateToLong.generateToTarget("price", "orderDto", "order");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(order.getPrice())) {\n" //
            + "    orderDto.setPrice(java.math.BigDecimal.valueOf(order.getPrice()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(orderDto.getPrice())) {\n" //
            + "    order.setPrice(orderDto.getPrice().doubleValue());\n" //
            + "}");

        BigDecimalToDoublePropertyCodegen stringToDate = new BigDecimalToDoublePropertyCodegen(Double.TYPE, true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(user.getCreateTime().doubleValue());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(java.math.BigDecimal.valueOf(userDto.getCreateTime()));\n" //
            + "}");
    }

    @Test
    public void testWrapper() {
        BigDecimalToDoublePropertyCodegen dateToLong = new BigDecimalToDoublePropertyCodegen(Double.class);
        fromTarget = dateToLong.generateFromTarget("price", "orderDto", "order");
        toTarget = dateToLong.generateToTarget("price", "orderDto", "order");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(order.getPrice())) {\n" //
            + "    orderDto.setPrice(java.math.BigDecimal.valueOf(order.getPrice()));\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(orderDto.getPrice())) {\n" //
            + "    order.setPrice(orderDto.getPrice().doubleValue());\n" //
            + "}");

        BigDecimalToDoublePropertyCodegen stringToDate = new BigDecimalToDoublePropertyCodegen(Double.TYPE, true);
        fromTarget = stringToDate.generateFromTarget("createTime", "userDto", "user");
        toTarget = stringToDate.generateToTarget("createTime", "userDto", "user");
        System.out.println(fromTarget);
        System.out.println(toTarget);

        assertEquals(fromTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getCreateTime())) {\n" //
            + "    userDto.setCreateTime(user.getCreateTime().doubleValue());\n" //
            + "}");
        assertEquals(toTarget, "if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getCreateTime())) {\n" //
            + "    user.setCreateTime(java.math.BigDecimal.valueOf(userDto.getCreateTime()));\n" //
            + "}");
    }
}
