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

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.structure.ChainMap;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.conversion.codegen.property.DateToLocalDateTimePropertyCodegen;
import cn.featherfly.conversion.codegen.property.DateToLongPropertyCodegen;
import cn.featherfly.conversion.codegen.property.DateToLongWrapperPropertyCodegen;
import cn.featherfly.conversion.codegen.property.DateToStringPropertyCodegen;
import cn.featherfly.conversion.codegen.property.DirectAssignPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToEnumPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToIntPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToIntegerPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToLongPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToLongWrapperPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToStringPropertyCodegen;
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

    private final int indentStart;

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
        super();
        this.indentStart = indentStart;
        this.propertyCodegenMap = addTime(addSqlTimestamp(addSqlTime(addSqlDate(
            addDate(new ChainMapImpl<>())))));
        this.propertyCodegenMap.putAll(propertyCodegenMap);
    }

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
        if (property.sourceType().name().equals(property.targetType().name())) {
            return ASSIGN_PROPERTY_CODEGEN;
        } else {
            TypeMetadata st = property.sourceType();
            TypeMetadata tt = property.targetType();
            PropertyCodegen propertyCodegen = null;
            if (st.isEnum() && tt.isEnum()) {
                propertyCodegen = new EnumToEnumPropertyCodegen(CodegenUtils.getClassName(st.name()),
                    CodegenUtils.getClassName(tt.name()));
            } else if (st.isEnum()) {
                propertyCodegen = getEnumToTarget(st, tt);
            } else if (tt.isEnum()) {
                propertyCodegen = getEnumFromTarget(st, tt);
            }
            if (propertyCodegen != null) {
                return propertyCodegen;
            }
        }
        PropertyCodegen propertyCodegen =
            propertyCodegenMap.get(property.sourceType().name() + "#" + property.targetType().name());
        if (propertyCodegen == null) {
            propertyCodegen = propertyCodegenMap.get(property.targetType().name() + "#" + property.sourceType().name());
        }
        if (propertyCodegen == null) {
            throw new IllegalArgumentException(
                Str.format("未找到对应类型{} {}的转换实现", property.sourceType().name(), property.targetType().name()));
        }
        return propertyCodegen;
    }

    private PropertyCodegen getEnumToTarget(TypeMetadata st, TypeMetadata tt) {
        String typeName = CodegenUtils.getClassName(st.name());
        if (tt.name().equals(String.class.getName())) {
            return new EnumToStringPropertyCodegen(typeName);
        } else if (tt.name().equals(int.class.getName())) {
            return new EnumToIntPropertyCodegen(typeName);
        } else if (tt.name().equals(Integer.class.getName())) {
            return new EnumToIntegerPropertyCodegen(typeName);
        } else if (tt.name().equals(long.class.getName())) {
            return new EnumToLongPropertyCodegen(typeName);
        } else if (tt.name().equals(Long.class.getName())) {
            return new EnumToLongWrapperPropertyCodegen(typeName);
        }
        return null;
    }

    private PropertyCodegen getEnumFromTarget(TypeMetadata st, TypeMetadata tt) {
        String typeName = CodegenUtils.getClassName(tt.name());
        if (st.name().equals(String.class.getName())) {
            return new EnumToStringPropertyCodegen(typeName, true);
        } else if (st.name().equals(int.class.getName())) {
            return new EnumToIntPropertyCodegen(typeName, true);
        } else if (st.name().equals(Integer.class.getName())) {
            return new EnumToIntegerPropertyCodegen(typeName, true);
        } else if (st.name().equals(long.class.getName())) {
            return new EnumToLongPropertyCodegen(typeName, true);
        } else if (st.name().equals(Long.class.getName())) {
            return new EnumToLongWrapperPropertyCodegen(typeName, true);
        }
        return null;
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
        for (ConvertibleProperty prop : properties) {
            PropertyCodegen pc = getPropertyCodegen(prop);
            src.append(indent2).append(pc.generateToTarget(prop.name(), sourceObjectName, targetObjectName))
                .append(";\n");
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
        if (!method.isConstructor()) {
            src.append(indent2).append(sourceObjectType).append(" ").append(sourceObjectName).append(" = ")
                .append("new ")
                .append(sourceObjectType)
                .append("();\n");
        }
        for (ConvertibleProperty prop : properties) {
            PropertyCodegen pc = getPropertyCodegen(prop);
            src.append(indent2).append(pc.generateFromTarget(prop.name(), sourceObjectName, targetObjectName))
                .append(";\n");
        }
        if (!method.isConstructor()) {
            src.append(indent2).append("return ").append(sourceObjectName).append(";\n");
        }
        src.append(indent).append("}");
        return src.toString();
    }
}
