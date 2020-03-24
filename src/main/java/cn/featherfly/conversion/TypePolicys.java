
package cn.featherfly.conversion;

import cn.featherfly.common.lang.ClassUtils;

/**
 * <p>
 * TypePolicys
 * </p>
 *
 * @author zhongj
 */
public enum TypePolicys implements TypePolicy {
    /**
     * class level, use sourceType == checkedType
     */
    CLASS,
    /**
     * class level, use sourceType.isAssignableFrom(checkedType)
     */
    INSTANCE;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean support(Class<?> sourceType, Class<?> checkedType) {
        switch (this) {
            case CLASS:
                return sourceType == checkedType;
            case INSTANCE:
                return ClassUtils.isParent(sourceType, checkedType);
            default:
                return sourceType == checkedType;
        }
    }

}
