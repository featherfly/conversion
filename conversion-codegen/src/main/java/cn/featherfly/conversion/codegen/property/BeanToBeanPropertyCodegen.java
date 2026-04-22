package cn.featherfly.conversion.codegen.property;

import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.PropertyConverterCodegen;
import cn.featherfly.conversion.codegen.convertor.BeanToBeanConvertorCodegen;

/**
 * bean to bean property codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class BeanToBeanPropertyCodegen extends ConvertorPropertyCodegen implements PropertyConverterCodegen {

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    public BeanToBeanPropertyCodegen(String sourceType, String targetType) {
        this(sourceType, targetType, null, null);
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param inverse the inverse
     */
    public BeanToBeanPropertyCodegen(String sourceType, String targetType, boolean inverse) {
        this(sourceType, targetType, null, null, inverse);
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     */
    public BeanToBeanPropertyCodegen(String sourceType, String targetType, String toSourceName,
        String toTargetName) {
        this(sourceType, targetType, toSourceName, toTargetName, false);
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     * @param inverse the inverse
     */
    public BeanToBeanPropertyCodegen(String sourceType, String targetType, String toSourceName,
        String toTargetName, boolean inverse) {
        super(sourceType, targetType,
            new BeanToBeanConvertorCodegen(sourceType, targetType, toSourceName, toTargetName, inverse));
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param targetType the target type
     */
    public <E extends Enum<?>> BeanToBeanPropertyCodegen(Class<E> sourceType, Class<E> targetType) {
        this(CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType));
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param targetType the target type
     * @param inverse the inverse
     */
    public <E extends Enum<?>> BeanToBeanPropertyCodegen(Class<E> sourceType, Class<E> targetType, boolean inverse) {
        this(sourceType, targetType, null, null, inverse);
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     */
    public <E extends Enum<?>> BeanToBeanPropertyCodegen(Class<E> sourceType, Class<E> targetType, String toSourceName,
        String toTargetName) {
        this(CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType), toSourceName, toTargetName);
    }

    /**
     * Instantiates a new enum to long property codegen.
     *
     * @param <E> the element type
     * @param sourceType the source type
     * @param targetType the target type
     * @param toSourceName the to source name
     * @param toTargetName the to target name
     * @param inverse the inverse
     */
    public <E extends Enum<?>> BeanToBeanPropertyCodegen(Class<E> sourceType, Class<E> targetType, String toSourceName,
        String toTargetName, boolean inverse) {
        this(CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType), toSourceName, toTargetName,
            inverse);
    }
}
