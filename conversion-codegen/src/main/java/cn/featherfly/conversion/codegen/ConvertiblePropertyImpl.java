
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-14 17:48:14
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

/**
 * ConvertiblePropertyImpl.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class ConvertiblePropertyImpl implements ConvertibleProperty {

    private final String name;

    private final TypeMetadata sourceType;

    private final TypeMetadata targetType;

    /**
     * Instantiates a new convertible property impl.
     *
     * @param name the name
     * @param sourceType the source type
     * @param targetType the target type
     */
    public ConvertiblePropertyImpl(String name, TypeMetadata sourceType, TypeMetadata targetType) {
        super();
        this.name = name;
        this.sourceType = sourceType;
        this.targetType = targetType;
    }

    /**
     * Instantiates a new convertible property impl.
     *
     * @param name the name
     * @param sourceType the source type
     * @param targetType the target type
     */
    public ConvertiblePropertyImpl(String name, Class<?> sourceType, Class<?> targetType) {
        super();
        this.name = name;
        this.sourceType = new TypeMetadataImpl(sourceType.getName(), sourceType.isEnum());
        this.targetType = new TypeMetadataImpl(targetType.getName(), targetType.isEnum());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeMetadata sourceType() {
        return sourceType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeMetadata targetType() {
        return targetType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return name;
    }

}
