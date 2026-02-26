
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-02-25 17:58:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.string;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/**
 * ToStringCollectionConvertor.
 *
 * @author zhongj
 */
public class QueueToStringConvertor extends CollectionToStringConvertor<Queue<?>> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Collection<Object> create() {
        return new ArrayDeque<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object getFirst(Queue<?> source) {
        return source.element();
    }
}
