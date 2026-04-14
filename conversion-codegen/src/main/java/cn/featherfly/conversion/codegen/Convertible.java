package cn.featherfly.conversion.codegen;

/**
 * The Interface Convertible.
 *
 * @author zhongj
 * @since 0.1.0
 */
public interface Convertible {

    /**
     * Source type.
     *
     * @return the string
     */
    String sourceType();

    /**
     * Target type.
     *
     * @return the string
     */
    String targetType();
}
