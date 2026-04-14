package cn.featherfly.conversion.codegen;

/**
 * The Interface PropertyMetadata.
 *
 * @author zhongj
 * @since 0.1.0
 */
public interface ConvertibleProperty {

    /**
     * Name.
     *
     * @return the string
     */
    String name();

    /**
     * Source type.
     *
     * @return the string
     */
    TypeMetadata sourceType();

    /**
     * Target type.
     *
     * @return the string
     */
    TypeMetadata targetType();
}
