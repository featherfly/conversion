
package cn.featherfly.conversion;

/**
 * <p>
 * TypePolity
 * </p>
 *
 * @author zhongj
 */
public interface TypePolicy {
    /**
     * support
     *
     * @param sourceType
     * @param checkedType
     * @return
     */
    boolean support(Class<?> sourceType, Class<?> checkedType);
}
