package cn.featherfly.conversion.codegen;

/**
 * The type AbstractConvertible.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class AbstractConvertible implements Convertible {

    /** The source type. */
    protected final String sourceType;

    /** The target type. */
    protected final String targetType;

    /**
     * Instantiates a new abstract convertible.
     *
     * @param sourceType the source type
     * @param targetType the target type
     */
    protected AbstractConvertible(String sourceType, String targetType) {
        this.sourceType = sourceType;
        this.targetType = targetType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String sourceType() {
        return sourceType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String targetType() {
        return targetType;
    }
}
