
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-17 17:30:17
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import cn.featherfly.common.lang.ClassUtils;

/**
 * TypeMetadataImpl.
 *
 * @author zhongj
 */
public class TypeMetadataImpl implements TypeMetadata {

    private final String name;

    private final TypeMetadata elementType;

    private final boolean isEnum;

    private final boolean isArray;

    private final boolean isIterable;

    /**
     * Instantiates a new type metadata impl.
     *
     * @param type the type
     */
    public TypeMetadataImpl(Class<?> type) {
        this(CodegenUtils.getClassName(type.getName()), type.isEnum(), type.isArray(),
            ClassUtils.isParent(Iterable.class, type),
            type.isArray() ? new TypeMetadataImpl(type.getComponentType()) : null);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param type the type
     * @param elementType the element type
     */
    public TypeMetadataImpl(Class<?> type, Class<?> elementType) {
        this(type, new TypeMetadataImpl(elementType));
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param type the type
     * @param elementType the element type
     */
    public TypeMetadataImpl(Class<?> type, TypeMetadata elementType) {
        this(CodegenUtils.getClassName(type.getName()), type.isEnum(), type.isArray(),
            ClassUtils.isParent(Iterable.class, type), elementType);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param name the name
     */
    public TypeMetadataImpl(String name) {
        this(name, false);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param name the name
     * @param isEnum the is enum
     */
    public TypeMetadataImpl(String name, boolean isEnum) {
        this(name, isEnum, false, false);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param name the name
     * @param isArray the is array
     * @param isIterable the is iterable
     */
    public TypeMetadataImpl(String name, boolean isArray, boolean isIterable) {
        this(name, false, isArray, isIterable);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param name the name
     * @param isEnum the is enum
     * @param isArray the is array
     * @param isIterable the is iterable
     */
    public TypeMetadataImpl(String name, boolean isEnum, boolean isArray, boolean isIterable) {
        this(name, isEnum, isArray, isIterable, null);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param name the name
     * @param isEnum the is enum
     * @param isArray the is array
     * @param isIterable the is iterable
     * @param elementType the element type
     */
    public TypeMetadataImpl(String name, boolean isEnum, boolean isArray, boolean isIterable,
        TypeMetadata elementType) {
        super();
        this.name = name;
        this.elementType = elementType;
        this.isEnum = isEnum;
        this.isArray = isArray;
        this.isIterable = isIterable;
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
    public boolean isEnum() {
        return isEnum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isArray() {
        return isArray;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIterable() {
        return isIterable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeMetadata elementType() {
        return elementType;
    }

}
