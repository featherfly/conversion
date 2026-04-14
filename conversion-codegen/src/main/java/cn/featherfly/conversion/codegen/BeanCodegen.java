package cn.featherfly.conversion.codegen;

import java.util.List;

/**
 * The Interface PropertyCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public interface BeanCodegen {

    /**
     * Generate to target.
     *
     * @param method the method
     * @param sourceObjectType the source object type
     * @param targetObjectType the target object type
     * @param properties the properties
     * @param sourceObjectName the source object name.
     *        can be null or empty string
     * @param targetObjectName the target object name.
     *        cant not be null or empty string
     * @return the string
     */
    String generateToTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        List<ConvertibleProperty> properties, String sourceObjectName,
        String targetObjectName);

    /**
     * Generate from target.
     *
     * @param method the method
     * @param sourceObjectType the source object type
     * @param targetObjectType the target object type
     * @param properties the properties
     * @param sourceObjectName the source object name.
     *        can be null or empty string
     * @param targetObjectName the target object name
     *        cant not be null or empty string
     * @return the string
     */
    String generateFromTarget(MethodMetadata method, String sourceObjectType, String targetObjectType,
        List<ConvertibleProperty> properties, String sourceObjectName,
        String targetObjectName);
}
