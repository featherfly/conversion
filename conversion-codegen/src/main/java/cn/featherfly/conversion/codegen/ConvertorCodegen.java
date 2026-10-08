package cn.featherfly.conversion.codegen;

/**
 * The type ConvertorCodegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public interface ConvertorCodegen extends Convertible {

    /**
     * Checks if is inverse.
     *
     * @return true, if is inverse
     */
    boolean isInverse();

    /**
     * Generate to target.
     *
     * @param property the property
     * @param source the source
     * @param target the target
     * @return the string
     */
    String generateToTarget(ConvertibleProperty property, String source, String target);

    /**
     * Generate to source.
     *
     * @param property the property
     * @param target the target
     * @param source the source
     * @return the string
     */
    String generateToSource(ConvertibleProperty property, String target, String source);
}
