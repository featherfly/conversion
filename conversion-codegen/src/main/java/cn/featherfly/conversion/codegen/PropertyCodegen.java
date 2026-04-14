package cn.featherfly.conversion.codegen;

/**
 * The Interface PropertyCodegen.
 *
 * @author zhongj
 */
public interface PropertyCodegen {

    /**
     * Generate to target.
     *
     * @param propertyName the property name
     *        cant not be null or empty string
     * @param sourceObjectName the source object name.
     *        can be null or empty string
     * @param targetObjectName the target object name.
     *        cant not be null or empty string
     * @return the string
     */
    String generateToTarget(String propertyName, String sourceObjectName, String targetObjectName);

    /**
     * Generate from target.
     *
     * @param propertyName the property name
     *        cant not be null
     * @param sourceObjectName the source object name.
     *        can be null or empty string
     * @param targetObjectName the target object name
     *        cant not be null or empty string
     * @return the string
     */
    String generateFromTarget(String propertyName, String sourceObjectName, String targetObjectName);
}
