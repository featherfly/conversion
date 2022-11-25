package cn.featherfly.conversion.string.basic;

/**
 * <p>
 * Enum[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class EnumArrayConvertor<T extends Enum<T>> extends GenericClassArrayConvertor<T[], T> {

    /**
     */
    public EnumArrayConvertor() {
        super(new EnumConvertor<T>());
    }
}
