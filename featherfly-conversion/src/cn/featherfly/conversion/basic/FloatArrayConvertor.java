
package cn.featherfly.conversion.basic;



/**
 * <p>
 * Float[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class FloatArrayConvertor extends GenericClassArrayConvertor<Float[], Float> {

    /**
     */
    public FloatArrayConvertor() {
        super(new FloatWrapperConvertor());
    }
}
