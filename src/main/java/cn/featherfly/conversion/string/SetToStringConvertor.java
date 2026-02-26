
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-02-25 17:58:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.string;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * ToStringCollectionConvertor.
 *
 * @author zhongj
 */
public class SetToStringConvertor extends CollectionToStringConvertor<Set<?>> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Collection<Object> create() {
        return new HashSet<>();
    }
}
