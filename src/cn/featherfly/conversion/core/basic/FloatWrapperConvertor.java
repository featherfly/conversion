
package cn.featherfly.conversion.core.basic;



/**
 * <p>
 * 单精度浮点数包装类转换器
 * </p>
 *
 * @author 钟冀
 */
public class FloatWrapperConvertor extends NumberConvertor<Float>{

    /**
     */
    public FloatWrapperConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Float> getType() {
        return Float.class;
    }
}
