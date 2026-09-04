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