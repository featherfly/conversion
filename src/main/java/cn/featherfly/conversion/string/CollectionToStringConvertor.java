
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-02-25 17:58:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.string;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.conversion.ConversionException;
import cn.featherfly.conversion.Convertor;
import cn.featherfly.conversion.convertors.CollectionConvertor;
import cn.featherfly.conversion.convertors.ContainerType;

/**
 * ToStringCollectionConvertor.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public abstract class CollectionToStringConvertor<S extends Collection<?>> extends CollectionConvertor<S, String>
    implements ToStringConvertor<S> {

    private String splitSign = Chars.COMMA;

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected S doTargetToSource(String target, Type<S> sourceType) {
        if (Str.isBlank(target) || sourceType == null) {
            return (S) Collections.emptyList();
        }
        Convertor<Object, String> convertor = null;
        ClassType<Object> ct = null;
        if (sourceType instanceof BeanProperty) {
            BeanProperty<?, List<?>> bp = (BeanProperty<?, List<?>>) sourceType;
            convertor = getConvertor(bp.getGenericType());
            ct = new ClassType<>((Class<Object>) bp.getGenericType());
        } else if (sourceType instanceof ContainerType) {
            ContainerType<List<?>, ?> cp = (ContainerType<List<?>, ?>) sourceType;
            convertor = getConvertor(cp.getInnerType());
            ct = new ClassType<>((Class<Object>) cp.getInnerType());
        } else {
            throw new ConversionException("#container_not_support_type",
                new Object[] { List.class.getName(), sourceType.getClass().getName() });
        }

        Collection<Object> collection = create();
        String[] values = Str.split(target, splitSign);
        for (String value : values) {
            collection.add(convertor.targetToSource(value, ct));
        }
        return (S) collection;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected String doSourceToTarget(S source, Type<S> sourceType) {
        if (Lang.isEmpty(source)) {
            return Str.EMPTY;
        }
        Object src0 = getFirst(source);
        Class<?> type = src0.getClass();
        ClassType<Object> ct = new ClassType<>((Class<Object>) type);
        Convertor<Object, String> convertor = getConvertor(type);

        StringBuilder result = new StringBuilder();
        for (Object src : source) {
            result.append(convertor.sourceToTarget(src, ct)).append(splitSign);
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    /**
     * Creates the.
     *
     * @return the collection
     */
    protected abstract Collection<Object> create();

    /**
     * Gets the first.
     *
     * @param source the source
     * @return the first
     */
    protected Object getFirst(S source) {
        return source.stream().findFirst().orElse(null);
    }

    public String getSplitSign() {
        return splitSign;
    }

    public void setSplitSign(String splitSign) {
        this.splitSign = splitSign;
    }
}
