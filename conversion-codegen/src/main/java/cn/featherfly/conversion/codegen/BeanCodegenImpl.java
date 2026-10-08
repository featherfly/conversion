package cn.featherfly.conversion.codegen;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.structure.ChainMap;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.conversion.codegen.MethodMetadata.MethodType;
import cn.featherfly.conversion.codegen.convertor.BeanToBeanConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.BigDecimalToDoubleConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.BigDecimalToLongConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.BigIntegerToLongConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.CommentConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToLocalDateTimeConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToLongConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToLongWrapperConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.DateToStringConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.DirectAssignConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToEnumConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.LocalDateTimeToStringConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.LocalDateToStringConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.LocalTimeToStringConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.TimeToLocalTimeConvertorCodegen;
import cn.featherfly.conversion.codegen.property.BeanToBeanPropertyCodegen;
import cn.featherfly.conversion.codegen.property.BigDecimalToDoublePropertyCodegen;
import cn.featherfly.conversion.codegen.property.BigDecimalToLongPropertyCodegen;
import cn.featherfly.conversion.codegen.property.BigIntegerToLongPropertyCodegen;
import cn.featherfly.conversion.codegen.property.BooleanDirectAssignPropertyCodegen;
import cn.featherfly.conversion.codegen.property.CommentPropertyCodegen;
import cn.featherfly.conversion.codegen.property.DateToLocalDateTimePropertyCodegen;
import cn.featherfly.conversion.codegen.property.DateToLongPropertyCodegen;
import cn.featherfly.conversion.codegen.property.DateToLongWrapperPropertyCodegen;
import cn.featherfly.conversion.codegen.property.DateToStringPropertyCodegen;
import cn.featherfly.conversion.codegen.property.DirectAssignPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToEnumPropertyCodegen;
import cn.featherfly.conversion.codegen.property.IterablePropertyCodegen;
import cn.featherfly.conversion.codegen.property.LocalDateTimeToStringPropertyCodegen;
import cn.featherfly.conversion.codegen.property.LocalDateToStringPropertyCodegen;
import cn.featherfly.conversion.codegen.property.LocalTimeToStringPropertyCodegen;
import cn.featherfly.conversion.codegen.property.TimeToLocalTimePropertyCodegen;

/**
 * The Interface PropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class BeanCodegenImpl implements BeanCodegen {

    private static final String JAVADOC_TEMPLATE1 =
        "{0}/**\n{0} * create a new {2} and copy properties from {1}\n{0} * @param {1} {1}\n{0} * @return new {2}\n{0} */\n";

    private static final String METHOD_END = ") {\n";

    private static final String STATIC_KEYWORD = "static ";

    private static final String PUBLIC_KEYWORD = "public ";

    private static final DirectAssignPropertyCodegen ASSIGN_PROPERTY_CODEGEN = new DirectAssignPropertyCodegen();

    private final Map<String, PropertyCodegen> propertyCodegenMap;

    private final Map<String, ConvertorCodegen> convertorMap;

    private final Map<String, ConvertorCodegen> beanToBeanConvertorMap;

    private final List<ConvertorCodegenFinder> convertorFinderList;

    private final int indentStart;

    private boolean noConvertorException;

    private boolean generateJavadoc = true;

    private String indentSymbol;

    /**
     * Instantiates a new bean codegen impl.
     *
     * @param indentStart the indent start
     * @param propertyCodegenMap the property codegen map
     * @param convertorMap the convertor map
     * @param beanToBeanConvertorMap the bean to bean convertor map
     * @param convertorFinderList the convertor finder list
     */
    private BeanCodegenImpl(int indentStart, Map<String, PropertyCodegen> propertyCodegenMap,
        Map<String, ConvertorCodegen> convertorMap, Map<String, ConvertorCodegen> beanToBeanConvertorMap,
        List<ConvertorCodegenFinder> convertorFinderList) {
        super();
        this.indentStart = indentStart;
        // 先加入默认实现，用户自定义实现优先级更高，会覆盖相同类型转换的默认实现
        this.propertyCodegenMap = addPrimitiveType(
            addTime(addSqlTimestamp(addSqlTime(addSqlDate(addDate(addMath(new ChainMapImpl<>())))))));
        this.propertyCodegenMap.putAll(propertyCodegenMap);

        // 先加入默认实现，用户自定义实现优先级更高，会覆盖相同类型转换的默认实现
        this.convertorMap = addTimeConvertor(addSqlTimestampConvertor(
            addSqlTimeConvertor(addSqlDateConvertor(addDateConvertor(addMathConvertor(new ChainMapImpl<>()))))));
        this.convertorMap.putAll(convertorMap);

        this.beanToBeanConvertorMap = beanToBeanConvertorMap;
        this.convertorFinderList = convertorFinderList;
    }

    // ****************************************************************************************************************

    // ****************************************************************************************************************

    private static ChainMap<String, ConvertorCodegen> addTimeConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        return convertorCodegens
            // java.time.LocalDateTime
            .putChain(getKey(LocalDateTime.class, String.class), new LocalDateTimeToStringConvertorCodegen())
            .putChain(getKey(String.class, LocalDateTime.class), new LocalDateTimeToStringConvertorCodegen(true))
            // java.time.LocalDate
            .putChain(getKey(LocalDate.class, String.class), new LocalDateToStringConvertorCodegen())
            .putChain(getKey(String.class, LocalDate.class), new LocalDateToStringConvertorCodegen(true))
            // java.time.LocalTime
            .putChain(getKey(LocalTime.class, String.class), new LocalTimeToStringConvertorCodegen())
            .putChain(getKey(String.class, LocalTime.class), new LocalTimeToStringConvertorCodegen(true));
    }

    private static ChainMap<String, ConvertorCodegen> addSqlTimeConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.sql.Time
        return convertorCodegens
            .putChain(getKey(Time.class, String.class), new DateToStringConvertorCodegen(Time.class, Dates.FORMAT_TIME))
            .putChain(getKey(String.class, Time.class),
                new DateToStringConvertorCodegen(Time.class, Dates.FORMAT_TIME, true))
            //
            .putChain(getKey(Time.class, long.class), new DateToLongConvertorCodegen(Time.class))
            .putChain(getKey(long.class, Time.class), new DateToLongConvertorCodegen(Time.class, true))
            //
            .putChain(getKey(Time.class, Long.class), new DateToLongWrapperConvertorCodegen(Time.class))
            .putChain(getKey(Long.class, Time.class), new DateToLongWrapperConvertorCodegen(Time.class, true))
            //
            .putChain(getKey(Time.class, LocalTime.class), new TimeToLocalTimeConvertorCodegen())
            .putChain(getKey(LocalTime.class, Time.class), new TimeToLocalTimeConvertorCodegen(true));
    }

    private static ChainMap<String, ConvertorCodegen> addSqlTimestampConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.sql.Timestamp
        return convertorCodegens
            .putChain(getKey(Timestamp.class, String.class),
                new DateToStringConvertorCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME))
            .putChain(getKey(String.class, Timestamp.class),
                new DateToStringConvertorCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(getKey(Timestamp.class, long.class), new DateToLongConvertorCodegen(Timestamp.class))
            .putChain(getKey(long.class, Timestamp.class), new DateToLongConvertorCodegen(Timestamp.class, true))
            //
            .putChain(getKey(Timestamp.class, Long.class), new DateToLongWrapperConvertorCodegen(Timestamp.class))
            .putChain(getKey(Long.class, Timestamp.class), new DateToLongWrapperConvertorCodegen(Timestamp.class, true))
            //
            .putChain(getKey(Timestamp.class, LocalDateTime.class),
                new DateToLocalDateTimeConvertorCodegen(Timestamp.class))
            .putChain(getKey(LocalDateTime.class, Timestamp.class),
                new DateToLocalDateTimeConvertorCodegen(Timestamp.class, true));
    }

    private static ChainMap<String, ConvertorCodegen> addSqlDateConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.sql.Date
        return convertorCodegens
            .putChain(getKey(java.sql.Date.class, String.class),
                new DateToStringConvertorCodegen(java.sql.Date.class, Dates.FORMAT_DATE))
            .putChain(getKey(String.class, java.sql.Date.class),
                new DateToStringConvertorCodegen(java.sql.Date.class, Dates.FORMAT_DATE, true))
            //
            .putChain(getKey(java.sql.Date.class, long.class), new DateToLongConvertorCodegen(java.sql.Date.class))
            .putChain(getKey(long.class, java.sql.Date.class),
                new DateToLongConvertorCodegen(java.sql.Date.class, true))
            //
            .putChain(getKey(java.sql.Date.class, Long.class),
                new DateToLongWrapperConvertorCodegen(java.sql.Date.class))
            .putChain(getKey(Long.class, java.sql.Date.class),
                new DateToLongWrapperConvertorCodegen(java.sql.Date.class, true))
            //
            .putChain(getKey(java.sql.Date.class, LocalDate.class),
                new DateToLocalDateTimeConvertorCodegen(java.sql.Date.class))
            .putChain(getKey(LocalDate.class, java.sql.Date.class),
                new DateToLocalDateTimeConvertorCodegen(java.sql.Date.class, true));
    }

    private static ChainMap<String, ConvertorCodegen> addDateConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.util.Date
        return convertorCodegens
            .putChain(getKey(Date.class, String.class),
                new DateToStringConvertorCodegen(Date.class, Dates.FORMAT_DATE_TIME))
            .putChain(getKey(String.class, Date.class),
                new DateToStringConvertorCodegen(Date.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(getKey(Date.class, long.class), new DateToLongConvertorCodegen(Date.class))
            .putChain(getKey(long.class, Date.class), new DateToLongConvertorCodegen(Date.class, true))
            //
            .putChain(getKey(Date.class, Long.class), new DateToLongWrapperConvertorCodegen(Date.class))
            .putChain(getKey(Long.class, Date.class), new DateToLongWrapperConvertorCodegen(Date.class, true))
            //
            .putChain(getKey(Date.class, LocalDateTime.class), new DateToLocalDateTimeConvertorCodegen(Date.class))
            .putChain(getKey(LocalDateTime.class, Date.class),
                new DateToLocalDateTimeConvertorCodegen(Date.class, true))
            //
            .putChain(getKey(Date.class, LocalDate.class), new DateToLocalDateTimeConvertorCodegen(Date.class))
            .putChain(getKey(LocalDate.class, Date.class), new DateToLocalDateTimeConvertorCodegen(Date.class, true));
    }

    private static ChainMap<String, ConvertorCodegen> addMathConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.math.BigDecimal, java.math.BigInteger
        return convertorCodegens
            .putChain(getKey(BigDecimal.class, Long.class), new BigDecimalToLongConvertorCodegen(Long.class))
            .putChain(getKey(Long.class, BigDecimal.class), new BigDecimalToLongConvertorCodegen(Long.class, true))
            .putChain(getKey(BigDecimal.class, Long.TYPE), new BigDecimalToLongConvertorCodegen(Long.TYPE))
            .putChain(getKey(Long.TYPE, BigDecimal.class), new BigDecimalToLongConvertorCodegen(Long.TYPE, true))
            //
            .putChain(getKey(BigDecimal.class, Double.class), new BigDecimalToDoubleConvertorCodegen(Double.class))
            .putChain(getKey(Double.class, BigDecimal.class),
                new BigDecimalToDoubleConvertorCodegen(Double.class, true))
            .putChain(getKey(BigDecimal.class, Double.TYPE), new BigDecimalToDoubleConvertorCodegen(Double.TYPE))
            .putChain(getKey(Double.TYPE, BigDecimal.class), new BigDecimalToDoubleConvertorCodegen(Double.TYPE, true))
            //
            .putChain(getKey(BigInteger.class, Long.class), new BigIntegerToLongConvertorCodegen(Long.class))
            .putChain(getKey(Long.class, BigInteger.class), new BigIntegerToLongConvertorCodegen(Long.class, true))
            .putChain(getKey(BigInteger.class, Long.TYPE), new BigIntegerToLongConvertorCodegen(Long.TYPE))
            .putChain(getKey(Long.TYPE, BigInteger.class), new BigIntegerToLongConvertorCodegen(Long.TYPE, true));
    }

    // ****************************************************************************************************************

    private static ChainMap<String, PropertyCodegen> addPrimitiveType(
        ChainMap<String, PropertyCodegen> propertyCodegens) {
        return propertyCodegens
            // boolean <> Boolean
            .putChain(getKey(Boolean.class, boolean.class),
                new BooleanDirectAssignPropertyCodegen(Boolean.class, boolean.class))
            .putChain(getKey(boolean.class, Boolean.class),
                new BooleanDirectAssignPropertyCodegen(boolean.class, Boolean.class))
            // byte <> Byte
            .putChain(getKey(Byte.class, byte.class), ASSIGN_PROPERTY_CODEGEN)
            .putChain(getKey(byte.class, Byte.class), ASSIGN_PROPERTY_CODEGEN)
            // short <> Short
            .putChain(getKey(Short.class, short.class), ASSIGN_PROPERTY_CODEGEN)
            .putChain(getKey(short.class, Short.class), ASSIGN_PROPERTY_CODEGEN)
            // int <> Integer
            .putChain(getKey(Integer.class, int.class), ASSIGN_PROPERTY_CODEGEN)
            .putChain(getKey(int.class, Integer.class), ASSIGN_PROPERTY_CODEGEN)
            // long <> Long
            .putChain(getKey(Long.class, long.class), ASSIGN_PROPERTY_CODEGEN)
            .putChain(getKey(long.class, Long.class), ASSIGN_PROPERTY_CODEGEN)
            // double <> Double
            .putChain(getKey(Double.class, double.class), ASSIGN_PROPERTY_CODEGEN)
            .putChain(getKey(double.class, Double.class), ASSIGN_PROPERTY_CODEGEN)
            // float <> Float
            .putChain(getKey(Float.class, float.class), ASSIGN_PROPERTY_CODEGEN)
            .putChain(getKey(float.class, Float.class), ASSIGN_PROPERTY_CODEGEN);
    }

    private static ChainMap<String, PropertyCodegen> addTime(ChainMap<String, PropertyCodegen> propertyCodegens) {
        return propertyCodegens
            // java.time.LocalDateTime
            .putChain(getKey(LocalDateTime.class, String.class), new LocalDateTimeToStringPropertyCodegen())
            .putChain(getKey(String.class, LocalDateTime.class), new LocalDateTimeToStringPropertyCodegen(true))
            // java.time.LocalDate
            .putChain(getKey(LocalDate.class, String.class), new LocalDateToStringPropertyCodegen())
            .putChain(getKey(String.class, LocalDate.class), new LocalDateToStringPropertyCodegen(true))
            // java.time.LocalTime
            .putChain(getKey(LocalTime.class, String.class), new LocalTimeToStringPropertyCodegen())
            .putChain(getKey(String.class, LocalTime.class), new LocalTimeToStringPropertyCodegen(true));
    }

    private static ChainMap<String, PropertyCodegen> addSqlTime(ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.sql.Time
        return propertyCodegens
            .putChain(getKey(Time.class, String.class), new DateToStringPropertyCodegen(Time.class, Dates.FORMAT_TIME))
            .putChain(getKey(String.class, Time.class),
                new DateToStringPropertyCodegen(Time.class, Dates.FORMAT_TIME, true))
            //
            .putChain(getKey(Time.class, long.class), new DateToLongPropertyCodegen(Time.class))
            .putChain(getKey(long.class, Time.class), new DateToLongPropertyCodegen(Time.class, true))
            //
            .putChain(getKey(Time.class, Long.class), new DateToLongWrapperPropertyCodegen(Time.class))
            .putChain(getKey(Long.class, Time.class), new DateToLongWrapperPropertyCodegen(Time.class, true))
            //
            .putChain(getKey(Time.class, LocalTime.class), new TimeToLocalTimePropertyCodegen())
            .putChain(getKey(LocalTime.class, Time.class), new TimeToLocalTimePropertyCodegen(true));
    }

    private static ChainMap<String, PropertyCodegen> addSqlTimestamp(
        ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.sql.Timestamp
        return propertyCodegens
            .putChain(getKey(Timestamp.class, String.class),
                new DateToStringPropertyCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME))
            .putChain(getKey(String.class, Timestamp.class),
                new DateToStringPropertyCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(getKey(Timestamp.class, long.class), new DateToLongPropertyCodegen(Timestamp.class))
            .putChain(getKey(long.class, Timestamp.class), new DateToLongPropertyCodegen(Timestamp.class, true))
            //
            .putChain(getKey(Timestamp.class, Long.class), new DateToLongWrapperPropertyCodegen(Timestamp.class))
            .putChain(getKey(Long.class, Timestamp.class), new DateToLongWrapperPropertyCodegen(Timestamp.class, true))
            //
            .putChain(getKey(Timestamp.class, LocalDateTime.class),
                new DateToLocalDateTimePropertyCodegen(Timestamp.class))
            .putChain(getKey(LocalDateTime.class, Timestamp.class),
                new DateToLocalDateTimePropertyCodegen(Timestamp.class, true));
    }

    private static ChainMap<String, PropertyCodegen> addSqlDate(ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.sql.Date
        return propertyCodegens
            .putChain(getKey(java.sql.Date.class, String.class),
                new DateToStringPropertyCodegen(java.sql.Date.class, Dates.FORMAT_DATE))
            .putChain(getKey(String.class, java.sql.Date.class),
                new DateToStringPropertyCodegen(java.sql.Date.class, Dates.FORMAT_DATE, true))
            //
            .putChain(getKey(java.sql.Date.class, long.class), new DateToLongPropertyCodegen(java.sql.Date.class))
            .putChain(getKey(long.class, java.sql.Date.class), new DateToLongPropertyCodegen(java.sql.Date.class, true))
            //
            .putChain(getKey(java.sql.Date.class, Long.class),
                new DateToLongWrapperPropertyCodegen(java.sql.Date.class))
            .putChain(getKey(Long.class, java.sql.Date.class),
                new DateToLongWrapperPropertyCodegen(java.sql.Date.class, true))
            //
            .putChain(getKey(java.sql.Date.class, LocalDate.class),
                new DateToLocalDateTimePropertyCodegen(java.sql.Date.class))
            .putChain(getKey(LocalDate.class, java.sql.Date.class),
                new DateToLocalDateTimePropertyCodegen(java.sql.Date.class, true));
    }

    private static ChainMap<String, PropertyCodegen> addDate(ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.util.Date
        return propertyCodegens
            .putChain(getKey(Date.class, String.class),
                new DateToStringPropertyCodegen(Date.class, Dates.FORMAT_DATE_TIME))
            .putChain(getKey(String.class, Date.class),
                new DateToStringPropertyCodegen(Date.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(getKey(Date.class, long.class), new DateToLongPropertyCodegen(Date.class))
            .putChain(getKey(long.class, Date.class), new DateToLongPropertyCodegen(Date.class, true))
            //
            .putChain(getKey(Date.class, Long.class), new DateToLongWrapperPropertyCodegen(Date.class))
            .putChain(getKey(Long.class, Date.class), new DateToLongWrapperPropertyCodegen(Date.class, true))
            //
            .putChain(getKey(Date.class, LocalDateTime.class), new DateToLocalDateTimePropertyCodegen(Date.class))
            .putChain(getKey(LocalDateTime.class, Date.class), new DateToLocalDateTimePropertyCodegen(Date.class, true))
            //
            .putChain(getKey(Date.class, LocalDate.class), new DateToLocalDateTimePropertyCodegen(Date.class))
            .putChain(getKey(LocalDate.class, Date.class), new DateToLocalDateTimePropertyCodegen(Date.class, true));
    }

    private static ChainMap<String, PropertyCodegen> addMath(ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.math.BigDecimal, java.math.BigInteger
        return propertyCodegens
            .putChain(getKey(BigDecimal.class, Long.class), new BigDecimalToLongPropertyCodegen(Long.class))
            .putChain(getKey(Long.class, BigDecimal.class), new BigDecimalToLongPropertyCodegen(Long.class, true))
            .putChain(getKey(BigDecimal.class, Long.TYPE), new BigDecimalToLongPropertyCodegen(Long.TYPE))
            .putChain(getKey(Long.TYPE, BigDecimal.class), new BigDecimalToLongPropertyCodegen(Long.TYPE, true))
            //
            .putChain(getKey(BigDecimal.class, Double.class), new BigDecimalToDoublePropertyCodegen(Double.class))
            .putChain(getKey(Double.class, BigDecimal.class), new BigDecimalToDoublePropertyCodegen(Double.class, true))
            .putChain(getKey(BigDecimal.class, Double.TYPE), new BigDecimalToDoublePropertyCodegen(Double.TYPE))
            .putChain(getKey(Double.TYPE, BigDecimal.class), new BigDecimalToDoublePropertyCodegen(Double.TYPE, true))
            //
            .putChain(getKey(BigInteger.class, Long.class), new BigIntegerToLongPropertyCodegen(Long.class))
            .putChain(getKey(Long.class, BigInteger.class), new BigIntegerToLongPropertyCodegen(Long.class, true))
            .putChain(getKey(BigInteger.class, Long.TYPE), new BigIntegerToLongPropertyCodegen(Long.TYPE))
            .putChain(getKey(Long.TYPE, BigInteger.class), new BigIntegerToLongPropertyCodegen(Long.TYPE, true));
    }

    private static String getKey(Class<?> source, Class<?> target) {
        return getKey(source.getName(), target.getName());
    }

    private static String getKey(String source, String target) {
        return source + "#" + target;
    }

    private PropertyCodegen getPropertyCodegen(ConvertibleProperty property) {
        if ((property.sourceType().elementType() == null || property.targetType().elementType() == null)
            && property.sourceType().name().equals(property.targetType().name())) {
            return ASSIGN_PROPERTY_CODEGEN;
        }
        PropertyCodegen propertyCodegen = null;
        TypeMetadata st = property.sourceType();
        TypeMetadata tt = property.targetType();
        if (st.isEnum() && tt.isEnum()) {
            propertyCodegen = new EnumToEnumPropertyCodegen(CodegenUtils.getClassName(st.name()),
                CodegenUtils.getClassName(tt.name()));
        } else if (st.isEnum()) {
            propertyCodegen = CodegenUtils.getEnumToTargetPropertyCodegen(st, tt);
        } else if (tt.isEnum()) {
            propertyCodegen = CodegenUtils.getEnumFromTargetPropertyCodegen(st, tt);
        } else if (st.getIterables() != null && tt.getIterables() != null) {
            propertyCodegen =
                new IterablePropertyCodegen(getElementConvertorCodegen(property), st.getIterables(),
                    tt.getIterables());
        }
        return getPropertyCodegen(property, propertyCodegen);
    }

    private PropertyCodegen getPropertyCodegen(ConvertibleProperty property, PropertyCodegen propertyCodegen) {
        if (propertyCodegen != null) {
            return propertyCodegen;
        }
        propertyCodegen = propertyCodegenMap.get(getKey(property.sourceType().name(), property.targetType().name()));
        if (propertyCodegen == null) {
            propertyCodegen = propertyCodegenMap
                .get(getKey(property.targetType().name(), property.sourceType().name()));
        }
        if (propertyCodegen != null) {
            return propertyCodegen;
        }

        if (property.sourceType().name().startsWith("java") || property.sourceType().name().indexOf('.') == -1
            || property.targetType().name().startsWith("java") || property.targetType().name().indexOf('.') == -1) {
            if (noConvertorException) {
                throw new IllegalArgumentException(Str.format("未找到转换属性{0}的转换器[{1} <-> {2}]", property.name(),
                    property.sourceType().name(), property.targetType().name()));
            }
            return new CommentPropertyCodegen(property.sourceType().name(), property.targetType().name());
        }
        return new BeanToBeanPropertyCodegen(property.sourceType().name(), property.targetType().name(),
            getBeanToBeanConvertorCodegen(property, property.sourceType().name(), property.targetType().name(),
                indentStart,
                false));
    }

    private ConvertorCodegen getEnumConvertorCodegen(TypeMetadata st, TypeMetadata tt) {
        if (st.isEnum() && tt.isEnum()) {
            return new EnumToEnumConvertorCodegen(CodegenUtils.getClassName(st.name()),
                CodegenUtils.getClassName(tt.name()));
        } else if (st.isEnum()) {
            return CodegenUtils.getEnumToTargetConvertorCodegen(st, tt);
        } else if (tt.isEnum()) {
            return CodegenUtils.getEnumFromTargetConvertorCodegen(st, tt);
        } else if (st.isIterable() && tt.isIterable()) {
            throw new NotImplementedException("nested array or iterable is not implement");
        }
        return null;
    }

    private ConvertorCodegen getConfirmedConvertorCodegen(TypeMetadata st, TypeMetadata tt) {
        ConvertorCodegen convertorCodegen = convertorMap.get(getKey(st.name(), tt.name()));
        if (convertorCodegen == null) {
            convertorCodegen = convertorMap.get(getKey(tt.name(), st.name()));
        }
        return convertorCodegen;
    }

    private ConvertorCodegen getElementConvertorCodegen(ConvertibleProperty property) {
        TypeMetadata souceType = property.sourceType();
        TypeMetadata targetType = property.targetType();
        if (souceType.elementType().name().equals(targetType.elementType().name())) {
            return new DirectAssignConvertorCodegen(targetType.elementType().name());
        }
        TypeMetadata st = souceType.elementType();
        TypeMetadata tt = targetType.elementType();
        ConvertorCodegen convertorCodegen = getEnumConvertorCodegen(st, tt);
        if (convertorCodegen != null) {
            return convertorCodegen;
        }
        convertorCodegen = getConfirmedConvertorCodegen(st, tt);
        if (convertorCodegen != null) {
            return convertorCodegen;
        }
        if (st.name().startsWith("java") || st.name().indexOf('.') == -1 || tt.name().startsWith("java")
            || tt.name().indexOf('.') == -1) {
            if (noConvertorException) {
                throw new IllegalArgumentException(Str.format("未找到属性转换器[{0} <-> {1}]", st.name(), tt.name()));
            }
            return new CommentConvertorCodegen(st.name(), tt.name());
        }
        return getBeanToBeanConvertorCodegen(property, st.name(), tt.name(), indentStart + 1, true);
    }

    private ConvertorCodegen getBeanToBeanConvertorCodegen(ConvertibleProperty property, String source, String target,
        int indentStart,
        boolean isElement) {
        ConvertorCodegen codegen = beanToBeanConvertorMap.get(getKey(source, target));
        if (codegen != null) {
            return codegen;
        }
        for (ConvertorCodegenFinder convertorFinder : convertorFinderList) {
            codegen = convertorFinder.find(property, source, target, indentStart + 1);
            if (codegen != null) {
                return codegen;
            }
        }
        return new BeanToBeanConvertorCodegen(builder().setIndentStart(indentStart - 1)
            .setIndentSymbol(indentSymbol)
            .setNoConvertorException(noConvertorException)
            .setGenerateJavadoc(false)
            .build(), source, target, indentStart, false, isElement);
    }

    private String getIndent(int size) {
        StringBuilder indents = new StringBuilder();
        for (int i = 0; i < size; i++) {
            indents.append(indentSymbol);
        }
        return indents.toString();
    }

    private String generateToTargetJavadoc(MethodMetadata method, String sourceObjectType, String targetObjectType,
        String sourceObjectName, String targetObjectName) {
        String indent = getIndent(indentStart);
        StringBuilder javadoc = new StringBuilder();
        if (method.isStatic()) {
            if (method.isGivenArgument()) {
                javadoc.append(Str.format(
                    "{0}/**\n{0} * copy properties from argument {1} to argument {3}\n{0} * @param {1} {1}\n{0} * @param {3} {3}\n{0} * @return the argument {3}\n{0} */\n",
                    indent, sourceObjectName, targetObjectType, targetObjectName));
            } else {
                javadoc.append(Str.format(
                    JAVADOC_TEMPLATE1,
                    indent, sourceObjectName, targetObjectType));
            }
        } else {
            if (method.isGivenArgument()) {
                javadoc.append(Str.format(
                    "{0}/**\n{0} * copy properties from this to argument {1}\n{0} * @param {1} {1}\n{0} * @return the argument {1}\n{0} */\n",
                    indent, targetObjectName, targetObjectType));
            } else {
                javadoc.append(Str.format(
                    "{0}/**\n{0} * create a new {1} and copy properties from this\n{0} * @return new {1}\n{0} */\n",
                    indent, targetObjectType));
            }
        }
        return javadoc.toString();
    }

    private String generateToTargetMethodDefine(MethodMetadata method, String sourceObjectType, String targetObjectType,
        String sourceObjectName, String targetObjectName) {
        String indent = getIndent(indentStart);
        String targetDefine = targetObjectType + " " + targetObjectName;
        StringBuilder methodDefine = new StringBuilder();
        methodDefine.append(indent).append(PUBLIC_KEYWORD).append(method.isStatic() ? STATIC_KEYWORD : "")
            .append(targetObjectType).append(" ").append(method.name());
        if (method.isStatic()) {
            AssertIllegalArgument.isNotEmpty(sourceObjectName, "when method is static, sourceObjectName");
            methodDefine.append("(").append(sourceObjectType).append(" ").append(sourceObjectName)
                .append(method.isGivenArgument() ? ", " + targetDefine : "").append(METHOD_END);
        } else {
            methodDefine.append("(").append(method.isGivenArgument() ? targetDefine : "").append(METHOD_END);
        }
        return methodDefine.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        List<ConvertibleProperty> properties, String sourceObjectName, String targetObjectName) {
        return generateToTarget(method, sourceObjectType, targetObjectType, indent -> {
            String targetDefine = targetObjectType + " " + targetObjectName;
            StringBuilder src = new StringBuilder();
            if (method != null) {
                if (method.isGivenArgument()) {
                    src.append(indent).append("if (").append(targetObjectName).append(" == null");
                    if (method.isStatic()) {
                        src.append(" || ").append(sourceObjectName).append(" == null");
                    }
                    src.append(") return ").append(targetObjectName).append(";\n");
                } else {
                    if (method.isStatic()) {
                        src.append(indent).append("if (").append(sourceObjectName).append(" == null) return null;\n");
                    }
                    src.append(indent).append(targetDefine).append(" = new ").append(targetObjectType).append("();\n");
                }
            }
            for (ConvertibleProperty prop : properties) {
                PropertyCodegen pc = getPropertyCodegen(prop);
                for (String line : pc.generateToTarget(prop.name(), sourceObjectName, targetObjectName).split("\n")) {
                    src.append(indent).append(line).append("\n");
                }
            }
            if (method != null) {
                src.append(indent).append("return ").append(targetObjectName).append(";\n");
            }
            return src.toString();
        }, sourceObjectName, targetObjectName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        UnaryOperator<String> content, String sourceObjectName, String targetObjectName) {
        String indent1 = getIndent(indentStart);
        String indent2 = getIndent(indentStart + 1);
        StringBuilder src = new StringBuilder();
        if (method != null) {
            // method start
            if (generateJavadoc) {
                src.append(generateToTargetJavadoc(method, sourceObjectType, targetObjectType, sourceObjectName,
                    targetObjectName));
            }
            src.append(generateToTargetMethodDefine(method, sourceObjectType, targetObjectType, sourceObjectName,
                targetObjectName));
        }
        String c = content.apply(indent2);
        src.append(c);
        if (c.charAt(c.length() - 1) != '\n') {
            src.append("\n");
        }
        if (method != null) {
            // method end
            src.append(indent1).append("}");
        }
        return src.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateFromTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        List<ConvertibleProperty> properties, String sourceObjectName, String targetObjectName) {
        String indent1 = getIndent(indentStart);
        String indent2 = getIndent(indentStart + 1);
        String sourceDefine = sourceObjectType + " " + sourceObjectName;
        StringBuilder src = new StringBuilder();
        if (method != null) {
            // method start
            if (generateJavadoc) {
                if (method.isStatic()) {
                    if (method.isGivenArgument()) {
                        src.append(Str.format(
                            "{0}/**\n{0} * copy properties from {2} to {1}\n{0} * @param {2} {2}\n{0} * @param {1} {1}\n{0} * @return the argument {1}\n{0} */\n",
                            indent1, sourceObjectName, targetObjectName));
                    } else {
                        src.append(Str.format(
                            JAVADOC_TEMPLATE1,
                            indent1, targetObjectName, sourceObjectType));
                    }
                } else {
                    if (method.isConstructor()) {
                        src.append(Str.format(
                            "{0}/**\n{0} * Instantiates a new {1} and copy properties from {2}\n{0} * @param {2} {2}\n{0} */\n",
                            indent1, sourceObjectType, targetObjectName));
                    } else {
                        src.append(Str.format(
                            "{0}/**\n{0} * copy properties from {2} to this\n{0} * @param {2} {2}\n{0} * @return this\n{0} */\n",
                            indent1, method.name(), targetObjectName, sourceObjectType));
                    }
                }
            }
            if (method.isConstructor()) {
                src.append(indent1).append(PUBLIC_KEYWORD).append(method.name()).append("(").append(targetObjectType)
                    .append(" ").append(targetObjectName).append(METHOD_END);
            } else {
                src.append(indent1).append(PUBLIC_KEYWORD).append(method.isStatic() ? STATIC_KEYWORD : "")
                    .append(sourceObjectType)
                    .append(" ").append(method.name()).append("(").append(targetObjectType).append(" ")
                    .append(targetObjectName).append(method.isGivenArgument() ? ", " + sourceDefine : "")
                    .append(METHOD_END);
            }
            if (method.isGivenArgument() && method.isStatic()) {
                src.append(indent2).append("if (").append(targetObjectName).append(" == null || ")
                    .append(sourceObjectName).append(" == null) return ").append(sourceObjectName).append(";\n");
            } else {
                src.append(indent2).append("if (").append(targetObjectName).append(" == null) return");
                if (method.methodType() == MethodType.METHOD) {
                    src.append(" this;\n");
                } else if (method.methodType() == MethodType.STATIC_METHOD) {
                    src.append(" null;\n");
                    src.append(indent2).append(sourceDefine).append(" = ").append("new ").append(sourceObjectType)
                        .append("();\n");
                } else if (method.methodType() == MethodType.CONSTRUCTOR) {
                    src.append(";\n");
                }
            }
        }
        for (ConvertibleProperty prop : properties) {
            PropertyCodegen pc = getPropertyCodegen(prop);
            for (String line : pc
                //                .generateFromTarget(prop.name(), method.isStatic() ? sourceObjectName : null, targetObjectName)
                .generateFromTarget(prop.name(), sourceObjectName, targetObjectName).split("\n")) {
                src.append(indent2).append(line).append("\n");
            }
        }
        if (method != null) {
            // method end
            if (!method.isConstructor()) {
                src.append(indent2).append("return ").append(method.isStatic() ? sourceObjectName : "this")
                    .append(";\n");
            }
            src.append(indent1).append("}");
        }
        return src.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateFromTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        UnaryOperator<String> content, String sourceObjectName, String targetObjectName) {
        String indent1 = getIndent(indentStart);
        String indent2 = getIndent(indentStart + 1);
        String sourceDefine = sourceObjectType + " " + sourceObjectName;
        StringBuilder src = new StringBuilder();
        if (generateJavadoc) {
            if (method.isStatic()) {
                if (method.isGivenArgument()) {
                    src.append(Str.format(
                        "{0}/**\n{0} * copy properties from {2} to {1}\n{0} * @param {2} {2}\n{0} * @param {1} {1}\n{0} * @return the argument {1}\n{0} */\n",
                        indent1, sourceObjectName, targetObjectName));
                } else {
                    src.append(Str.format(
                        JAVADOC_TEMPLATE1,
                        indent1, targetObjectName, sourceObjectType));
                }
            } else {
                if (method.isConstructor()) {
                    src.append(Str.format(
                        "{0}/**\n{0} * Instantiates a new {1} and copy properties from {2}\n{0} * @param {2} {2}\n{0} */\n",
                        indent1, sourceObjectType, targetObjectName));
                } else {
                    src.append(Str.format(
                        "{0}/**\n{0} * copy properties from {2} to this\n{0} * @param {2} {2}\n{0} * @return this\n{0} */\n",
                        indent1, method.name(), targetObjectName, sourceObjectType));
                }
            }
        }
        if (method.isConstructor()) {
            src.append(indent1).append(PUBLIC_KEYWORD).append(method.name()).append("(").append(targetObjectType)
                .append(" ")
                .append(targetObjectName).append(METHOD_END);
        } else {
            src.append(indent1).append(PUBLIC_KEYWORD).append(method.isStatic() ? STATIC_KEYWORD : "")
                .append(sourceObjectType)
                .append(" ").append(method.name()).append("(").append(targetObjectType).append(" ")
                .append(targetObjectName).append(method.isGivenArgument() ? ", " + sourceDefine : "")
                .append(METHOD_END);
        }
        String c = content.apply(indent2);
        src.append(c);
        if (c.charAt(c.length() - 1) != '\n') {
            src.append("\n");
        }
        src.append(indent1).append("}");
        return src.toString();
    }

    /**
     * Checks if is no convertor exception.
     *
     * @return true, if is no convertor exception
     */
    public boolean isNoConvertorException() {
        return noConvertorException;
    }

    /**
     * get indentStart value.
     *
     * @return indentStart
     */
    public int getIndentStart() {
        return indentStart;
    }

    /**
     * get generateJavadoc value.
     *
     * @return generateJavadoc
     */
    public boolean isGenerateJavadoc() {
        return generateJavadoc;
    }

    /**
     * Builder.
     *
     * @return the bean codegen builder
     */
    public static BeanCodegenBuilder builder() {
        return new BeanCodegenBuilder();
    }

    /**
     * The Interface ConvertorCodegenFinder.
     *
     * @author zhongj
     */
    public interface ConvertorCodegenFinder {
        ConvertorCodegen find(ConvertibleProperty property, String source, String target, int indentStart);
    }

    /**
     * The Class BeanCodegenBuilder.
     *
     * @author zhongj
     */
    public static class BeanCodegenBuilder {

        private Map<String, PropertyCodegen> propertyCodegenMap = new HashMap<>(0);

        private Map<String, ConvertorCodegen> convertorMap = new HashMap<>(0);

        private Map<String, ConvertorCodegen> beanToBeanConvertorMap = new HashMap<>(0);

        private final List<ConvertorCodegenFinder> convertorFinderList = new ArrayList<>(0);

        private String indentSymbol = "    ";

        private int indentStart;

        private boolean noConvertorException;

        private boolean generateJavadoc = true;

        /**
         * Sets the indent start.
         *
         * @param indentStart the indent start
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder setIndentStart(int indentStart) {
            this.indentStart = indentStart;
            return this;
        }

        /**
         * Sets the indent.
         *
         * @param indentSymbol the indent symbol
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder setIndentSymbol(String indentSymbol) {
            this.indentSymbol = indentSymbol;
            return this;
        }

        /**
         * Sets the no convertor exception.
         *
         * @param noConvertorException the no convertor exception
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder setNoConvertorException(boolean noConvertorException) {
            this.noConvertorException = noConvertorException;
            return this;
        }

        /**
         * set generateJavadoc value.
         *
         * @param generateJavadoc generateJavadoc
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder setGenerateJavadoc(boolean generateJavadoc) {
            this.generateJavadoc = generateJavadoc;
            return this;
        }

        /**
         * Adds the property codegen.
         *
         * @param source the source
         * @param target the target
         * @param propertyCodegen the property codegen
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder addPropertyCodegen(Class<?> source, Class<?> target,
            PropertyCodegen propertyCodegen) {
            propertyCodegenMap.put(getKey(source, target), propertyCodegen);
            return this;
        }

        /**
         * Adds the convertor codegen.
         *
         * @param source the source
         * @param target the target
         * @param convertorCodegen the convertor codegen
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder addConvertorCodegen(Class<?> source, Class<?> target,
            ConvertorCodegen convertorCodegen) {
            convertorMap.put(getKey(source, target), convertorCodegen);
            return this;
        }

        /**
         * Adds the bean to bean convertor codegen.
         *
         * @param source the source
         * @param target the target
         * @param convertorCodegen the convertor codegen
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder addBeanToBeanConvertorCodegen(Class<?> source, Class<?> target,
            ConvertorCodegen convertorCodegen) {
            beanToBeanConvertorMap.put(getKey(source, target), convertorCodegen);
            return this;
        }

        /**
         * Adds the convertor codegen finder.
         *
         * @param convertorFinder the convertor finder
         * @return the bean codegen builder
         */
        public BeanCodegenBuilder addConvertorCodegenFinder(
            ConvertorCodegenFinder convertorFinder) {
            convertorFinderList.add(convertorFinder);
            return this;
        }

        /**
         * build BeanCodegen.
         *
         * @return the bean codegen
         */
        public BeanCodegen build() {
            BeanCodegenImpl beanCodegen = new BeanCodegenImpl(indentStart, propertyCodegenMap, convertorMap,
                beanToBeanConvertorMap, convertorFinderList);
            beanCodegen.noConvertorException = noConvertorException;
            beanCodegen.generateJavadoc = generateJavadoc;
            beanCodegen.indentSymbol = indentSymbol;
            return beanCodegen;
        }
    }
}
