
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-14 17:45:14
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import cn.featherfly.common.lang.AssertIllegalArgument;

/**
 * MethodMetadataImpl.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class MethodMetadataImpl implements MethodMetadata {

    private final String name;

    private final MethodType methodType;

    private final boolean givenArgument;

    /**
     * Instantiates a new method metadata impl.
     *
     * @param name the name
     */
    public MethodMetadataImpl(String name) {
        this(name, MethodType.METHOD);
    }

    /**
     * Instantiates a new method metadata impl.
     *
     * @param name the name
     * @param methodType the method type
     */
    public MethodMetadataImpl(String name, MethodType methodType) {
        this(name, methodType, false);
    }

    /**
     * Instantiates a new method metadata impl.
     *
     * @param name the name
     * @param givenArgument the given argument
     */
    public MethodMetadataImpl(String name, boolean givenArgument) {
        this(name, MethodType.METHOD, givenArgument);
    }

    /**
     * Instantiates a new method metadata impl.
     *
     * @param name the name
     * @param methodType the method type
     * @param givenArgument the given argument
     */
    public MethodMetadataImpl(String name, MethodType methodType, boolean givenArgument) {
        super();
        AssertIllegalArgument.isNotNull(name, "name");
        AssertIllegalArgument.isNotNull(methodType, "methodType");
        this.name = name;
        this.methodType = methodType;
        this.givenArgument = givenArgument;
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
    public MethodType methodType() {
        return methodType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStatic() {
        return methodType == MethodType.STATIC_METHOD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConstructor() {
        return methodType == MethodType.CONSTRUCTOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isGivenArgument() {
        return givenArgument;
    }

}
