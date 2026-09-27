
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-09-25 00:58:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import org.testng.annotations.Test;

import cn.featherfly.conversion.codegen.domain.Role;
import cn.featherfly.conversion.codegen.domain.User;
import cn.featherfly.conversion.codegen.vo.RoleDto;
import cn.featherfly.conversion.codegen.vo.RoleDto2;
import cn.featherfly.conversion.codegen.vo.UserDto;

/**
 * ClassGeneratorTest.
 *
 * @author zhongj
 */
public class ClassGeneratorTest {

    @Test
    void test0000() {
        BeanCodegen codegen = BeanCodegenImpl.builder().setIndentStart(1).build();
        BeanConvertorGenerator generator = new BeanConvertorGenerator(codegen, RoleDto2.class, Role.class);
        //        generator.getMethods().add(new MethodMetadataImpl("copy", MethodType.STATIC_METHOD, false));
        //        generator.getMethods().add(new MethodMetadataImpl("copy", MethodType.STATIC_METHOD, true));

        System.out.println(generator.generate(RoleDto2.class.getPackage().getName() + ".RoleDtoToRoleConvertor"));
    }

    @Test
    void test() {
        BeanCodegen codegen = BeanCodegenImpl.builder().setIndentStart(1).build();
        BeanConvertorGenerator generator = new BeanConvertorGenerator(codegen, RoleDto.class, Role.class);
        //        generator.getMethods().add(new MethodMetadataImpl("copy", MethodType.STATIC_METHOD, false));
        //        generator.getMethods().add(new MethodMetadataImpl("copy", MethodType.STATIC_METHOD, true));

        System.out.println(generator.generate(RoleDto.class.getPackage().getName() + ".RoleDtoToRoleConvertor"));
    }

    @Test
    void test2() {
        BeanCodegen codegen = BeanCodegenImpl.builder().setIndentStart(1).build();

        BeanConvertorGenerator generator = new BeanConvertorGenerator(codegen, UserDto.class, User.class);
        System.out.println(generator.generate(UserDto.class.getPackage().getName() + ".UserDtoToUserConvertor"));

    }
}
