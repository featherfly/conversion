
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-16 15:29:16
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import cn.featherfly.conversion.codegen.convertor.EnumToIntConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToIntegerConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToLongConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToLongWrapperConvertorCodegen;
import cn.featherfly.conversion.codegen.convertor.EnumToStringConvertorCodegen;
import cn.featherfly.conversion.codegen.property.EnumToIntPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToIntegerPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToLongPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToLongWrapperPropertyCodegen;
import cn.featherfly.conversion.codegen.property.EnumToStringPropertyCodegen;

/**
 * CodegenUtils.
 *
 * @author zhongj
 */
public final class CodegenUtils {

    private CodegenUtils() {

    }

    /**
     * Gets the class name.
     *
     * @param type the type
     * @return the class name
     */
    public static String getClassName(Class<?> type) {
        if (type.getPackage() == null) {
            // 处理 primitive type
            return type.getName();
        } else if ("java.lang".equals(type.getPackage().getName())) {
            // 优化 自动导入的java.lang包
            return type.getSimpleName();
        }
        return getClassName(type.getName());
    }

    /**
     * Gets the class name.
     *
     * @param typeName the type name
     * @return the class name
     */
    public static String getClassName(String typeName) {
        int lastDotIndex = typeName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            // 处理 primitive type
            return typeName;
        }
        if ("java.lang".equals(typeName.substring(0, lastDotIndex))) {
            // 优化 自动导入的java.lang包
            return typeName.substring(lastDotIndex + 1, typeName.length());
        }
        // 处理内部类，内部类的Class.getName()会包含$,而在代码中，是用.进行导航
        return typeName.replace("$", ".");
    }

    /**
     * Gets the class simple name.
     *
     * @param typeName the type name
     * @return the class name
     */
    public static String getClassSimpleName(String typeName) {
        final String name = typeName.replace("$", ".");
        int lastDotIndex = name.lastIndexOf('.');
        if (lastDotIndex == -1) {
            // 处理 primitive type
            return name;
        }
        return name.substring(lastDotIndex + 1, name.length());
    }

    public static String getToTypeMethod(String type) {
        return "to" + CodegenUtils.getClassSimpleName(type);
    }

    public static String getNewConstructor(String type) {
        return "new " + type;
    }

    public static PropertyCodegen getEnumToTargetPropertyCodegen(TypeMetadata st, TypeMetadata tt) {
        String typeName = CodegenUtils.getClassName(st.name());
        if (tt.name().equals(String.class.getName()) || tt.name().equals(String.class.getSimpleName())) {
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

    public static PropertyCodegen getEnumFromTargetPropertyCodegen(TypeMetadata st, TypeMetadata tt) {
        String typeName = CodegenUtils.getClassName(tt.name());
        if (st.name().equals(String.class.getName()) || st.name().equals(String.class.getSimpleName())) {
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

    public static ConvertorCodegen getEnumToTargetConvertorCodegen(TypeMetadata st, TypeMetadata tt) {
        String typeName = CodegenUtils.getClassName(st.name());
        if (tt.name().equals(String.class.getName()) || tt.name().equals(String.class.getSimpleName())) {
            return new EnumToStringConvertorCodegen(typeName);
        } else if (tt.name().equals(int.class.getName())) {
            return new EnumToIntConvertorCodegen(typeName);
        } else if (tt.name().equals(Integer.class.getName()) || tt.name().equals(Integer.class.getSimpleName())) {
            return new EnumToIntegerConvertorCodegen(typeName);
        } else if (tt.name().equals(long.class.getName())) {
            return new EnumToLongConvertorCodegen(typeName);
        } else if (tt.name().equals(Long.class.getName()) || tt.name().equals(Long.class.getSimpleName())) {
            return new EnumToLongWrapperConvertorCodegen(typeName);
        }
        return null;
    }

    public static ConvertorCodegen getEnumFromTargetConvertorCodegen(TypeMetadata st, TypeMetadata tt) {
        String typeName = CodegenUtils.getClassName(tt.name());
        if (st.name().equals(String.class.getName()) || st.name().equals(String.class.getSimpleName())) {
            return new EnumToStringConvertorCodegen(typeName, true);
        } else if (st.name().equals(int.class.getName())) {
            return new EnumToIntConvertorCodegen(typeName, true);
        } else if (st.name().equals(Integer.class.getName()) || st.name().equals(Integer.class.getSimpleName())) {
            return new EnumToIntegerConvertorCodegen(typeName, true);
        } else if (st.name().equals(long.class.getName())) {
            return new EnumToLongConvertorCodegen(typeName, true);
        } else if (st.name().equals(Long.class.getName()) || st.name().equals(Long.class.getSimpleName())) {
            return new EnumToLongWrapperConvertorCodegen(typeName, true);
        }
        return null;
    }
}
