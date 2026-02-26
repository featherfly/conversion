
package cn.featherfly.conversion.string.basic;

/**
 * Short[]转换器.
 *
 * @author 钟冀
 */
public class ShortArrayConvertor extends GenericTypeArrayConvertor<Short[], Short> {

    /**
     * Instantiates a new short array convertor.
     */
    public ShortArrayConvertor() {
        super(new ShortWrapperConvertor());
    }
}
