package cn.featherfly.conversion.codegen;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Iterables;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.structure.ChainMap;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.conversion.codegen.convertor.BeanToBeanConvertorCodegen;
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

    private static final DirectAssignPropertyCodegen ASSIGN_PROPERTY_CODEGEN = new DirectAssignPropertyCodegen();

    private static final String INDENT = "    ";

    private final Map<String, PropertyCodegen> propertyCodegenMap;

    private final Map<String, ConvertorCodegen> convertorMap;

    private final int indentStart;

    private boolean noConvertorException;

    /**
     * Instantiates a new bean codegen impl.
     */
    public BeanCodegenImpl() {
        this(Collections.emptyMap());
    }

    /**
     * Instantiates a new bean codegen impl.
     *
     * @param indentStart the indent start
     */
    public BeanCodegenImpl(int indentStart) {
        this(indentStart, Collections.emptyMap());
    }

    /**
     * Instantiates a new bean codegen impl.
     *
     * @param propertyCodegenMap the property codegen map
     */
    public BeanCodegenImpl(Map<String, PropertyCodegen> propertyCodegenMap) {
        this(0, propertyCodegenMap);
    }

    /**
     * Instantiates a new bean codegen impl.
     *
     * @param indentStart the indent start
     * @param propertyCodegenMap the property codegen map
     */
    public BeanCodegenImpl(int indentStart, Map<String, PropertyCodegen> propertyCodegenMap) {
        this(indentStart, propertyCodegenMap, Collections.emptyMap());
    }

    /**
     * Instantiates a new bean codegen impl.
     *
     * @param indentStart the indent start
     * @param propertyCodegenMap the property codegen map
     * @param convertorMap the convertor map
     */
    public BeanCodegenImpl(int indentStart, Map<String, PropertyCodegen> propertyCodegenMap,
        Map<String, ConvertorCodegen> convertorMap) {
        super();
        this.indentStart = indentStart;
        // 先加入默认实现，用户自定义实现优先级更高，会覆盖相同类型转换的默认实现
        this.propertyCodegenMap = addTime(addSqlTimestamp(addSqlTime(addSqlDate(
            addDate(new ChainMapImpl<>())))));
        this.propertyCodegenMap.putAll(propertyCodegenMap);
        // 先加入默认实现，用户自定义实现优先级更高，会覆盖相同类型转换的默认实现
        this.convertorMap = addTimeConvertor(addSqlTimestampConvertor(addSqlTimeConvertor(addSqlDateConvertor(
            addDateConvertor(new ChainMapImpl<>())))));
        this.convertorMap.putAll(convertorMap);
    }

    // ****************************************************************************************************************

    private static ChainMap<String, ConvertorCodegen> addTimeConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        return convertorCodegens
            // java.time.LocalDateTime
            .putChain(LocalDateTime.class.getName() + "#" + String.class.getName(),
                new LocalDateTimeToStringConvertorCodegen())
            .putChain(String.class.getName() + "#" + LocalDateTime.class.getName(),
                new LocalDateTimeToStringConvertorCodegen(true))
            // java.time.LocalDate
            .putChain(LocalDate.class.getName() + "#" + String.class.getName(),
                new LocalDateToStringConvertorCodegen())
            .putChain(String.class.getName() + "#" + LocalDate.class.getName(),
                new LocalDateToStringConvertorCodegen(true))
            // java.time.LocalTime
            .putChain(LocalTime.class.getName() + "#" + String.class.getName(),
                new LocalTimeToStringConvertorCodegen())
            .putChain(String.class.getName() + "#" + LocalTime.class.getName(),
                new LocalTimeToStringConvertorCodegen(true));
    }

    private static ChainMap<String, ConvertorCodegen> addSqlTimeConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.sql.Time
        return convertorCodegens.putChain(Time.class.getName() + "#" + String.class.getName(),
            new DateToStringConvertorCodegen(Time.class, Dates.FORMAT_TIME))
            .putChain(String.class.getName() + "#" + Time.class.getName(),
                new DateToStringConvertorCodegen(Time.class, Dates.FORMAT_TIME, true))
            //
            .putChain(Time.class.getName() + "#" + long.class.getName(),
                new DateToLongConvertorCodegen(Time.class))
            .putChain(long.class.getName() + "#" + Time.class.getName(),
                new DateToLongConvertorCodegen(Time.class, true))
            //
            .putChain(Time.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperConvertorCodegen(Time.class))
            .putChain(Long.class.getName() + "#" + Time.class.getName(),
                new DateToLongWrapperConvertorCodegen(Time.class, true))
            //
            .putChain(Time.class.getName() + "#" + LocalTime.class.getName(),
                new TimeToLocalTimeConvertorCodegen())
            .putChain(LocalTime.class.getName() + "#" + Time.class.getName(),
                new TimeToLocalTimeConvertorCodegen(true));
    }

    private static ChainMap<String, ConvertorCodegen> addSqlTimestampConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.sql.Timestamp
        return convertorCodegens.putChain(Timestamp.class.getName() + "#" + String.class.getName(),
            new DateToStringConvertorCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME))
            .putChain(String.class.getName() + "#" + Timestamp.class.getName(),
                new DateToStringConvertorCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(Timestamp.class.getName() + "#" + long.class.getName(),
                new DateToLongConvertorCodegen(Timestamp.class))
            .putChain(long.class.getName() + "#" + Timestamp.class.getName(),
                new DateToLongConvertorCodegen(Timestamp.class, true))
            //
            .putChain(Timestamp.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperConvertorCodegen(Timestamp.class))
            .putChain(Long.class.getName() + "#" + Timestamp.class.getName(),
                new DateToLongWrapperConvertorCodegen(Timestamp.class, true))
            //
            .putChain(Timestamp.class.getName() + "#" + LocalDateTime.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(Timestamp.class))
            .putChain(LocalDateTime.class.getName() + "#" + Timestamp.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(Timestamp.class, true));
    }

    private static ChainMap<String, ConvertorCodegen> addSqlDateConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.sql.Date
        return convertorCodegens.putChain(java.sql.Date.class.getName() + "#" + String.class.getName(),
            new DateToStringConvertorCodegen(java.sql.Date.class, Dates.FORMAT_DATE))
            .putChain(String.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToStringConvertorCodegen(java.sql.Date.class, Dates.FORMAT_DATE, true))
            //
            .putChain(java.sql.Date.class.getName() + "#" + long.class.getName(),
                new DateToLongConvertorCodegen(java.sql.Date.class))
            .putChain(long.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToLongConvertorCodegen(java.sql.Date.class, true))
            //
            .putChain(java.sql.Date.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperConvertorCodegen(java.sql.Date.class))
            .putChain(Long.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToLongWrapperConvertorCodegen(java.sql.Date.class, true))
            //
            .putChain(java.sql.Date.class.getName() + "#" + LocalDate.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(java.sql.Date.class))
            .putChain(LocalDate.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(java.sql.Date.class, true));
    }

    private static ChainMap<String, ConvertorCodegen> addDateConvertor(
        ChainMap<String, ConvertorCodegen> convertorCodegens) {
        // java.util.Date
        return convertorCodegens.putChain(Date.class.getName() + "#" + String.class.getName(),
            new DateToStringConvertorCodegen(Date.class, Dates.FORMAT_DATE_TIME))
            .putChain(String.class.getName() + "#" + Date.class.getName(),
                new DateToStringConvertorCodegen(Date.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(Date.class.getName() + "#" + long.class.getName(),
                new DateToLongConvertorCodegen(Date.class))
            .putChain(long.class.getName() + "#" + Date.class.getName(),
                new DateToLongConvertorCodegen(Date.class, true))
            //
            .putChain(Date.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperConvertorCodegen(Date.class))
            .putChain(Long.class.getName() + "#" + Date.class.getName(),
                new DateToLongWrapperConvertorCodegen(Date.class, true))
            //
            .putChain(Date.class.getName() + "#" + LocalDateTime.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(Date.class))
            .putChain(LocalDateTime.class.getName() + "#" + Date.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(Date.class, true))
            //
            .putChain(Date.class.getName() + "#" + LocalDate.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(Date.class))
            .putChain(LocalDate.class.getName() + "#" + Date.class.getName(),
                new DateToLocalDateTimeConvertorCodegen(Date.class, true));
    }

    // ****************************************************************************************************************

    private static ChainMap<String, PropertyCodegen> addTime(
        ChainMap<String, PropertyCodegen> propertyCodegens) {
        return propertyCodegens
            // java.time.LocalDateTime
            .putChain(LocalDateTime.class.getName() + "#" + String.class.getName(),
                new LocalDateTimeToStringPropertyCodegen())
            .putChain(String.class.getName() + "#" + LocalDateTime.class.getName(),
                new LocalDateTimeToStringPropertyCodegen(true))
            // java.time.LocalDate
            .putChain(LocalDate.class.getName() + "#" + String.class.getName(),
                new LocalDateToStringPropertyCodegen())
            .putChain(String.class.getName() + "#" + LocalDate.class.getName(),
                new LocalDateToStringPropertyCodegen(true))
            // java.time.LocalTime
            .putChain(LocalTime.class.getName() + "#" + String.class.getName(),
                new LocalTimeToStringPropertyCodegen())
            .putChain(String.class.getName() + "#" + LocalTime.class.getName(),
                new LocalTimeToStringPropertyCodegen(true));
    }

    private static ChainMap<String, PropertyCodegen> addSqlTime(ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.sql.Time
        return propertyCodegens.putChain(Time.class.getName() + "#" + String.class.getName(),
            new DateToStringPropertyCodegen(Time.class, Dates.FORMAT_TIME))
            .putChain(String.class.getName() + "#" + Time.class.getName(),
                new DateToStringPropertyCodegen(Time.class, Dates.FORMAT_TIME, true))
            //
            .putChain(Time.class.getName() + "#" + long.class.getName(),
                new DateToLongPropertyCodegen(Time.class))
            .putChain(long.class.getName() + "#" + Time.class.getName(),
                new DateToLongPropertyCodegen(Time.class, true))
            //
            .putChain(Time.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperPropertyCodegen(Time.class))
            .putChain(Long.class.getName() + "#" + Time.class.getName(),
                new DateToLongWrapperPropertyCodegen(Time.class, true))
            //
            .putChain(Time.class.getName() + "#" + LocalTime.class.getName(),
                new TimeToLocalTimePropertyCodegen())
            .putChain(LocalTime.class.getName() + "#" + Time.class.getName(),
                new TimeToLocalTimePropertyCodegen(true));
    }

    private static ChainMap<String, PropertyCodegen> addSqlTimestamp(
        ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.sql.Timestamp
        return propertyCodegens.putChain(Timestamp.class.getName() + "#" + String.class.getName(),
            new DateToStringPropertyCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME))
            .putChain(String.class.getName() + "#" + Timestamp.class.getName(),
                new DateToStringPropertyCodegen(Timestamp.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(Timestamp.class.getName() + "#" + long.class.getName(),
                new DateToLongPropertyCodegen(Timestamp.class))
            .putChain(long.class.getName() + "#" + Timestamp.class.getName(),
                new DateToLongPropertyCodegen(Timestamp.class, true))
            //
            .putChain(Timestamp.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperPropertyCodegen(Timestamp.class))
            .putChain(Long.class.getName() + "#" + Timestamp.class.getName(),
                new DateToLongWrapperPropertyCodegen(Timestamp.class, true))
            //
            .putChain(Timestamp.class.getName() + "#" + LocalDateTime.class.getName(),
                new DateToLocalDateTimePropertyCodegen(Timestamp.class))
            .putChain(LocalDateTime.class.getName() + "#" + Timestamp.class.getName(),
                new DateToLocalDateTimePropertyCodegen(Timestamp.class, true));
    }

    private static ChainMap<String, PropertyCodegen> addSqlDate(ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.sql.Date
        return propertyCodegens.putChain(java.sql.Date.class.getName() + "#" + String.class.getName(),
            new DateToStringPropertyCodegen(java.sql.Date.class, Dates.FORMAT_DATE))
            .putChain(String.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToStringPropertyCodegen(java.sql.Date.class, Dates.FORMAT_DATE, true))
            //
            .putChain(java.sql.Date.class.getName() + "#" + long.class.getName(),
                new DateToLongPropertyCodegen(java.sql.Date.class))
            .putChain(long.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToLongPropertyCodegen(java.sql.Date.class, true))
            //
            .putChain(java.sql.Date.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperPropertyCodegen(java.sql.Date.class))
            .putChain(Long.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToLongWrapperPropertyCodegen(java.sql.Date.class, true))
            //
            .putChain(java.sql.Date.class.getName() + "#" + LocalDate.class.getName(),
                new DateToLocalDateTimePropertyCodegen(java.sql.Date.class))
            .putChain(LocalDate.class.getName() + "#" + java.sql.Date.class.getName(),
                new DateToLocalDateTimePropertyCodegen(java.sql.Date.class, true));
    }

    private static ChainMap<String, PropertyCodegen> addDate(ChainMap<String, PropertyCodegen> propertyCodegens) {
        // java.util.Date
        return propertyCodegens.putChain(Date.class.getName() + "#" + String.class.getName(),
            new DateToStringPropertyCodegen(Date.class, Dates.FORMAT_DATE_TIME))
            .putChain(String.class.getName() + "#" + Date.class.getName(),
                new DateToStringPropertyCodegen(Date.class, Dates.FORMAT_DATE_TIME, true))
            //
            .putChain(Date.class.getName() + "#" + long.class.getName(),
                new DateToLongPropertyCodegen(Date.class))
            .putChain(long.class.getName() + "#" + Date.class.getName(),
                new DateToLongPropertyCodegen(Date.class, true))
            //
            .putChain(Date.class.getName() + "#" + Long.class.getName(),
                new DateToLongWrapperPropertyCodegen(Date.class))
            .putChain(Long.class.getName() + "#" + Date.class.getName(),
                new DateToLongWrapperPropertyCodegen(Date.class, true))
            //
            .putChain(Date.class.getName() + "#" + LocalDateTime.class.getName(),
                new DateToLocalDateTimePropertyCodegen(Date.class))
            .putChain(LocalDateTime.class.getName() + "#" + Date.class.getName(),
                new DateToLocalDateTimePropertyCodegen(Date.class, true))
            //
            .putChain(Date.class.getName() + "#" + LocalDate.class.getName(),
                new DateToLocalDateTimePropertyCodegen(Date.class))
            .putChain(LocalDate.class.getName() + "#" + Date.class.getName(),
                new DateToLocalDateTimePropertyCodegen(Date.class, true));
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
        } else if ((st.isArray() || st.isIterable()) && (tt.isArray() || tt.isIterable())) {
            propertyCodegen = new IterablePropertyCodegen(getElementConvertorCodegen(st, tt),
                st.isArray() ? Iterables.ARRAY : Iterables.LIST,
                tt.isArray() ? Iterables.ARRAY : Iterables.LIST);
        }
        return getPropertyCodegen(property, propertyCodegen);
    }

    private PropertyCodegen getPropertyCodegen(ConvertibleProperty property, PropertyCodegen propertyCodegen) {
        if (propertyCodegen != null) {
            return propertyCodegen;
        }
        propertyCodegen = propertyCodegenMap.get(property.sourceType().name() + "#" + property.targetType().name());
        if (propertyCodegen == null) {
            propertyCodegen = propertyCodegenMap.get(property.targetType().name() + "#" + property.sourceType().name());
        }
        if (propertyCodegen != null) {
            return propertyCodegen;
        }

        if (property.sourceType().name().startsWith("java") || property.sourceType().name().indexOf('.') == -1
            || property.targetType().name().startsWith("java") || property.targetType().name().indexOf('.') == -1) {
            if (noConvertorException) {
                throw new IllegalArgumentException(Str.format("未找到转换属性{0}的转换器[{1} <-> {2}]",
                    property.name(), property.sourceType().name(), property.targetType().name()));
            }
            return new CommentPropertyCodegen(property.sourceType().name(), property.targetType().name());
        }
        return new BeanToBeanPropertyCodegen(property.sourceType().name(), property.targetType().name());
    }

    private ConvertorCodegen getElementConvertorCodegen(TypeMetadata souceType, TypeMetadata targetType) {
        if (souceType.elementType().name().equals(targetType.elementType().name())) {
            return new DirectAssignConvertorCodegen(targetType.elementType().name());
        }
        ConvertorCodegen convertorCodegen = null;
        TypeMetadata st = souceType.elementType();
        TypeMetadata tt = targetType.elementType();
        if (st.isEnum() && tt.isEnum()) {
            convertorCodegen = new EnumToEnumConvertorCodegen(CodegenUtils.getClassName(st.name()),
                CodegenUtils.getClassName(tt.name()));
        } else if (st.isEnum()) {
            convertorCodegen = CodegenUtils.getEnumToTargetConvertorCodegen(st, tt);
        } else if (tt.isEnum()) {
            convertorCodegen = CodegenUtils.getEnumFromTargetConvertorCodegen(st, tt);
        } else if ((st.isArray() || st.isIterable()) && (tt.isArray() || tt.isIterable())) {
            throw new NotImplementedException("nested array or iterable is not implement");
        }
        if (convertorCodegen != null) {
            return convertorCodegen;
        }

        convertorCodegen = convertorMap.get(st.name() + "#" + tt.name());
        if (convertorCodegen == null) {
            convertorCodegen = convertorMap.get(tt.name() + "#" + st.name());
        }
        if (convertorCodegen == null) {
            convertorCodegen = new BeanToBeanConvertorCodegen(st.name(), tt.name());
        }
        return convertorCodegen;
    }

    private String getIndent(int size) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < size; i++) {
            indent.append(INDENT);
        }
        return indent.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        List<ConvertibleProperty> properties, String sourceObjectName, String targetObjectName) {
        String indent = getIndent(indentStart);
        String indent2 = getIndent(indentStart + 1);
        StringBuilder src = new StringBuilder();
        src.append(indent).append("public ").append(method.isStatic() ? "static " : "").append(targetObjectType)
            .append(" ")
            .append(method.name());
        if (method.isStatic()) {
            AssertIllegalArgument.isNotEmpty(sourceObjectName, "when method is static, sourceObjectName");
            src.append("(").append(sourceObjectType).append(" ").append(sourceObjectName).append(") {\n");
        } else {
            src.append("() {\n");
        }
        src.append(indent2).append(targetObjectType).append(" ").append(targetObjectName).append(" = ").append("new ")
            .append(targetObjectType)
            .append("();\n");
        if (method.isStatic()) {
            src.append(indent2).append("if (").append(sourceObjectName).append(" == null) return ")
                .append(targetObjectName).append(";\n");
        }
        for (ConvertibleProperty prop : properties) {
            PropertyCodegen pc = getPropertyCodegen(prop);
            for (String line : pc.generateToTarget(prop.name(), sourceObjectName, targetObjectName).split("\n")) {
                src.append(indent2).append(line).append("\n");
            }
        }
        src.append(indent2).append("return ").append(targetObjectName).append(";\n");
        src.append(indent).append("}");
        return src.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateFromTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        List<ConvertibleProperty> properties, String sourceObjectName, String targetObjectName) {
        StringBuilder src = new StringBuilder();
        String indent = getIndent(indentStart);
        String indent2 = getIndent(indentStart + 1);
        if (method.isConstructor()) {
            src.append(indent).append("public ").append(method.name()).append("(").append(targetObjectType).append(" ")
                .append(targetObjectName).append(") {\n");
        } else {
            src.append(indent).append("public ").append(method.isStatic() ? "static " : "").append(sourceObjectType)
                .append(" ").append(method.name()).append("(").append(targetObjectType).append(" ")
                .append(targetObjectName).append(") {\n");
        }
        if (method.isConstructor()) {
            src.append(indent2).append("if (").append(targetObjectName).append(" == null) return;\n");
        } else {
            src.append(indent2).append(sourceObjectType).append(" ").append(sourceObjectName).append(" = ")
                .append("new ")
                .append(sourceObjectType)
                .append("();\n");
            src.append(indent2).append("if (").append(targetObjectName).append(" == null) return ")
                .append(sourceObjectName).append(";\n");
        }
        for (ConvertibleProperty prop : properties) {
            PropertyCodegen pc = getPropertyCodegen(prop);
            for (String line : pc.generateFromTarget(prop.name(), sourceObjectName, targetObjectName).split("\n")) {
                src.append(indent2).append(line).append("\n");
            }
        }
        if (!method.isConstructor()) {
            src.append(indent2).append("return ").append(sourceObjectName).append(";\n");
        }
        src.append(indent).append("}");
        return src.toString();
    }

    public boolean isNoConvertorException() {
        return noConvertorException;
    }

    public void setNoConvertorException(boolean noConvertorException) {
        this.noConvertorException = noConvertorException;
    }
}
