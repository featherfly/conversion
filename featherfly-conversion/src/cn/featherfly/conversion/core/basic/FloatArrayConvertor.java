
package cn.featherfly.conversion.core.basic;



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
