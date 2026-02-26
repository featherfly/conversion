
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-02-25 15:50:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.convertors;

import java.util.Optional;

import cn.featherfly.common.lang.ClassUtils;

/**
 * OptionalType.
 *
 * @author zhongj
 * @param <I> the inner type
 */
public class OptionalType<I> extends ContainerType<Optional<I>, I> {

    /**
     * Instantiates a new optional type.
     *
     * @param innerType the inner type
     */
    public OptionalType(Class<I> innerType) {
        this(Optional.empty(), innerType);
    }

    private OptionalType(Optional<I> optType, Class<I> innerType) {
        super(ClassUtils.castGenericType(Optional.class, optType), innerType);
    }

}
