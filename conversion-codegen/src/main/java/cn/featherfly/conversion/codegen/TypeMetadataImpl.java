
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-17 17:30:17
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

/**
 * TypeMetadataImpl.
 *
 * @author zhongj
 */
public class TypeMetadataImpl implements TypeMetadata {

    private final String name;

    private boolean isEnum;

    /**
     * Instantiates a new type metadata impl.
     *
     * @param type the type
     */
    public TypeMetadataImpl(Class<?> type) {
        this(type.getName(), type.isEnum());
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
        super();
        this.name = name;
        this.isEnum = isEnum;
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

}
