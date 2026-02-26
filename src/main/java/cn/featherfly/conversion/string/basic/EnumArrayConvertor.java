package cn.featherfly.conversion.string.basic;

/**
 * Enum[]转换器.
 *
 * @author 钟冀
 * @param <T> the generic type
 */
public class EnumArrayConvertor<T extends Enum<T>> extends GenericClassArrayConvertor<T[], T> {

    /**
     * Instantiates a new enum array convertor.
     */
    public EnumArrayConvertor() {
        super(new EnumConvertor<>());
    }
}
