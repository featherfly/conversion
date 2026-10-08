
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-17 17:30:17
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Iterables;

/**
 * TypeMetadataImpl.
 *
 * @author zhongj
 */
public class TypeMetadataImpl implements TypeMetadata {

    private final String name;

    private final TypeMetadata elementType;

    private final boolean isEnum;

    private final Iterables iterables;

    /**
     * Instantiates a new type metadata impl.
     *
     * @param type the type
     */
    public TypeMetadataImpl(Class<?> type) {
        this(type, type.isArray() ? new TypeMetadataImpl(type.getComponentType()) : (TypeMetadata) null);
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
        name = type.getName();
        isEnum = type.isEnum();
        if (type.isArray()) {
            iterables = Iterables.ARRAY;
        } else if (ClassUtils.isParent(List.class, type)) {
            iterables = Iterables.LIST;
        } else if (ClassUtils.isParent(Set.class, type)) {
            iterables = Iterables.SET;
        } else if (ClassUtils.isParent(Queue.class, type)) {
            iterables = Iterables.QUEUE;
        } else if (ClassUtils.isParent(Collection.class, type)) {
            iterables = Iterables.COLLECTION;
        } else {
            iterables = null;
        }
        this.elementType = elementType;
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
        this(name, isEnum, null, null);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param name the name
     * @param iterables the iterables
     * @param elementType the element type
     */
    public TypeMetadataImpl(String name, Iterables iterables, TypeMetadata elementType) {
        this(name, false, iterables, elementType);
    }

    /**
     * Instantiates a new type metadata impl.
     *
     * @param name the name
     * @param isEnum the is enum
     * @param iterables the iterables
     * @param elementType the element type
     */
    private TypeMetadataImpl(String name, boolean isEnum, Iterables iterables, TypeMetadata elementType) {
        super();
        this.name = name;
        this.elementType = elementType;
        this.isEnum = isEnum;
        this.iterables = iterables;
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
        return iterables == Iterables.ARRAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollection() {
        return iterables != null && iterables != Iterables.ARRAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIterable() {
        return iterables != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeMetadata elementType() {
        return elementType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterables getIterables() {
        return iterables;
    }

}
