
package cn.featherfly.conversion.string.basic;

/**
 * Float[]转换器.
 *
 * @author 钟冀
 */
public class FloatArrayConvertor extends GenericTypeArrayConvertor<Float[], Float> {

    /**
     * Instantiates a new float array convertor.
     */
    public FloatArrayConvertor() {
        super(new FloatWrapperConvertor());
    }
}
