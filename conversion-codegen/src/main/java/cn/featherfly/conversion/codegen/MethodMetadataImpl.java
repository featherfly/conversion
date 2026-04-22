
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-14 17:45:14
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

/**
 * MethodMetadataImpl.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class MethodMetadataImpl implements MethodMetadata {

    private final String name;

    private final boolean isStatic;

    private final boolean isConstructor;

    /**
     * Instantiates a new method metadata impl.
     *
     * @param name the name
     */
    public MethodMetadataImpl(String name) {
        this(name, false, false);
    }

    /**
     * Instantiates a new method metadata impl.
     *
     * @param name the name
     * @param isConstructor the is constructor
     */
    public MethodMetadataImpl(String name, boolean isConstructor) {
        this(name, isConstructor, false);
    }

    /**
     * Instantiates a new method metadata impl.
     *
     * @param name the name
     * @param isConstructor the is constructor
     * @param isStatic the is static
     */
    public MethodMetadataImpl(String name, boolean isConstructor, boolean isStatic) {
        super();
        if (isConstructor && isStatic) {
            throw new IllegalArgumentException("isConstructor and isStatic both true");
        }
        this.name = name;
        this.isStatic = isStatic;
        this.isConstructor = isConstructor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStatic() {
        return isStatic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConstructor() {
        return isConstructor;
    }

}
