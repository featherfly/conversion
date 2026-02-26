
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-02-25 17:58:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ToStringCollectionConvertor.
 *
 * @author zhongj
 */
public class ListToStringConvertor extends CollectionToStringConvertor<List<?>> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Collection<Object> create() {
        return new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object getFirst(List<?> source) {
        return source.get(0);
    }
}
