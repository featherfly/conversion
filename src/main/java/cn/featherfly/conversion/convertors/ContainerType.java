
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-02-25 15:50:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.convertors;

import cn.featherfly.common.lang.reflect.Type;

/**
 * OptionalType.
 *
 * @author zhongj
 * @param <C> the container type
 * @param <I> the inner type
 */
public class ContainerType<C, I> implements Type<C> {

    private final Class<C> type;

    private final Class<I> innerType;

    /**
     * Instantiates a new container type.
     *
     * @param type the type
     * @param innerType the inner type
     */
    public ContainerType(Class<C> type, Class<I> innerType) {
        super();
        this.type = type;
        this.innerType = innerType;
    }

    /**
     * Gets the inner type.
     *
     * @return the inner type
     */
    public Class<I> getInnerType() {
        return innerType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<C> getType() {
        return type;
    }

}
