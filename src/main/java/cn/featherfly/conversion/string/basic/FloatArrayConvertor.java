
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * Float[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class FloatArrayConvertor extends GenericTypeArrayConvertor<Float[], Float> {

    /**
     */
    public FloatArrayConvertor() {
        super(new FloatWrapperConvertor());
    }
}
