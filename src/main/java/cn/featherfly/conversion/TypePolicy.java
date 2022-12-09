
package cn.featherfly.conversion;

/**
 * TypePolity.
 *
 * @author zhongj
 */
public interface TypePolicy {

    /**
     * support.
     *
     * @param sourceType  the source type
     * @param checkedType the checked type
     * @return true, if successful
     */
    boolean support(Class<?> sourceType, Class<?> checkedType);
}
