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
     * @param source the source
     * @return the string
     */
    String generateToTarget(String source);

    /**
     * Generate to source.
     *
     * @param target the target
     * @return the string
     */
    String generateToSource(String target);
}
