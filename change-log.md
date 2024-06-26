下一步实现	
	1.实现原子类型(线程池包中Atomic开头的类）

# 1.5.0 2024-05-05
1. ToStringConversion加入String sourceToString(S)|String sourceToString(S,G)
2. common-core:1.12.0不兼容升级

# 1.4.3 2022-12-09
1. common-core不兼容升级

# 1.4.2 2022-04-06
1. 修复废弃API调用
2. 构建时jackson使用implementation关系

# 1.4.1 2020-11-30
1. 升级依赖，修复废弃API调用
	
# 1.4.0 2020-4-11
1. 加入Optional支持
1. 升级依赖
    
# 1.3.4 2019-12-03
1. 升级依赖
    
# 1.3.3 2019-12-03
1. 升级依赖
    
# 1.3.2 2019-08-28
1. ConversionPolicys实现了1.8的支持
    	
# 1.3.1 2019-08-26 
1. 实现ClassFieldParser,ClassMethodParser,YamlParser
2. 升级featherfly-common到1.7.7    

# 1.3.0 2019-08-20
1. 支持jdk8,把jdk8包内的内容直接移植到此包
2. 升级featherfly-common到1.7.5    

# 1.2.2 2017-04-13
1. ConversionPolicy加入add(ConversionPolicy conversionPolicy)和put(ConversionPolicy conversionPolicy)方法
   
# 1.2.1 2017-04-12
1. 加入java.sql.Date,java.sql.Time,java.sql.Timestamp实现
2. 异常输出使用properties文件支持国际化    
        
# 1.2.0 2015-04-24
1. 重构程序
2. 加入parse
        
# 1.1.1 2014-06-17
1. 移植到cn.featherfly    

# 1.1.0 2012-12-27
1. 加入指派转换器功能，只有BeanPropertyConvertor有效，在属性上使用@Assign进行特定转换器指派
2. 加入ConversionPolicys类，用于存放常见的转换策略

# 1.0.0 2012-3-24
1. 实现基本类型的转换器（包含数组）  
    convertor的 基本类型转换策略
    ```
    public static final ConversionPolicy BASIC_CONVERSION_POLICY
                = new ConversionPolicy(
                    new BooleanConversion(), new BooleanWrapperConversion(), new BooleanArrayConversion()
                    , new ByteConversion(), new ByteWrapperConversion(), new ByteArrayConversion()
                    , new ShortConversion(), new ByteWrapperConversion(), new ByteArrayConversion()
                    , new IntConversion(), new IntegerConversion(), new IntArrayConversion()
                    , new LongConversion(), new LongWrapperConversion(), new LongArrayConversion()
                    , new FloatConversion(), new FloatWrapperConversion(), new FloatArrayConversion()
                    , new DoubleConversion(), new DoubleWrapperConversion(), new DoubleArrayConversion()
                    , new StringConversion(), new StringArrayConversion()
                    , new StringBufferConversion(), new StringBufferArrayConversion()
                    , new StringBuilderConversion(), new StringBuilderArrayConversion()
                    , new DateConversion(), new DateArrayConversion()
                    , new ClassConversion(), new ClassArrayConversion()
                    , new EnumConversion(), new EnumArrayConversion()
                    , new BigDecimalConversion(), new BigDecimalArrayConversion()
                    , new BigIntegerConversion(), new BigIntegerArrayConversion()
                );
    ```
2. 实现数字和日期带格式的转换
    DateFormatConversion Double.. Float... Integer... Long..., Short...
