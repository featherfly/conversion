# 0.6.0 2026-

feat:

1. BeanCodegenImpl support generate javadoc
2. add overload method generate[To|From]Target in BeanCodegen
3. BeanToBean[Convertor|Property]Codegen support generate set bean properties

# 0.5.0 2026-09-17

feats:

1. BeanCodegen支持生成的复制方法传入对象
    ```java
    // source UserDto target User
    // BeanCodegen.generateToTarget
    public cn.featherfly.conversion.codegen.domain.User toUser() {
        cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();
        if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());
        return user;
    }
    public cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.domain.User user) {
        if (user == null) return user;
        if (cn.featherfly.common.lang.Lang.isNotEmpty(getId())) user.setId(getId());
        return user;
    }
    public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto) {
        if (userDto == null) return null;
        cn.featherfly.conversion.codegen.domain.User user = new cn.featherfly.conversion.codegen.domain.User();
        if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());
        return user;
    }
    public static cn.featherfly.conversion.codegen.domain.User toUser(cn.featherfly.conversion.codegen.vo.UserDto userDto, cn.featherfly.conversion.codegen.domain.User user) {
        if (user == null || userDto == null) return user;
        if (cn.featherfly.common.lang.Lang.isNotEmpty(userDto.getId())) user.setId(userDto.getId());
        return user;
    }
    // BeanCodegen.generateFromTarget
    public UserDto(cn.featherfly.conversion.codegen.domain.User user) {
        if (user == null) return;
        if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId());
    }
    public cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {
        if (user == null) return this;
        if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) setId(user.getId());
        return this;
    }
    public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user) {
        if (user == null) return null;
        cn.featherfly.conversion.codegen.vo.UserDto userDto = new cn.featherfly.conversion.codegen.vo.UserDto();
        if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());
        return userDto;
    }
    public static cn.featherfly.conversion.codegen.vo.UserDto fromUser(cn.featherfly.conversion.codegen.domain.User user, cn.featherfly.conversion.codegen.vo.UserDto userDto) {
        if (user == null || userDto == null) return userDto;
        if (cn.featherfly.common.lang.Lang.isNotEmpty(user.getId())) userDto.setId(user.getId());
        return userDto;
    }
    ```

# 0.4.0 2026-09-10

feats:

1. 添加BigDecimal to (Double,Long)，BigInteger to Long的生成器 

# 0.3.0 2026-09-06

feats:

1. 添加基础类型（primitive type）和对应的包装类型（wrapper type）的支持

fixs:

​	1. BooleanDirectAssignPropertyCodegen 类中的 generateToTarget 方法在 sourceObjectName 参数不为空时会丢失 sourceObjectName 信息

# 0.2.0 2026-09-04

1. 使用builder模式创建BeanCodegenImpl
    ```java
    BeanCodegen beancodegen = BeanCodegenImpl.builder().build();
    BeanCodegen codegen = BeanCodegenImpl.builder().setNoConvertorException(true).build();
    ```

# 0.1.3 2026-09-03

1. 修复TypeMetadataImpl参数为Class时不再对类型名称进行处理（删除java.lang等）

# 0.1.2 2026-09-03

1. 修复`CodegenUtils`的方法`getEnumToTargetPropertyCodegen`，`getEnumFromTargetPropertyCodegen`没有判断类型名称为Integer,Long的情况


# 0.1.1 2026-09-03

1. 修复`CodegenUtils`的方法`getEnumToTargetPropertyCodegen`，`getEnumFromTargetPropertyCodegen`没有判断类型名称为String的情况

# 0.1.0 2026-08-18

1. 实现属性类型相同时直接赋值`userDto.setId(user.getId())`
2. 实现属性类型为Enum与int|Integer,long|Long,String,Enum之间的转换设置
3. 实现属性类型为Date与long|Long,String,Local[DateTime|Date|Time]之间的转换设置
4. 实现属性类型为Time与LocalTime之间的转换设置 
5. 实现BEAN转换器
6. 实现Array-Collection之间的互相转换