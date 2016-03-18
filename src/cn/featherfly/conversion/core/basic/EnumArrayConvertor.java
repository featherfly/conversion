package cn.featherfly.conversion.core.basic;



/**
 * <p>
 * Enum[]转换器
 * </p>
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class EnumArrayConvertor extends GenericClassArrayConvertor<Enum[], Enum> {

    /**
     */
    public EnumArrayConvertor() {
        super(new EnumConvertor());
    }
}
