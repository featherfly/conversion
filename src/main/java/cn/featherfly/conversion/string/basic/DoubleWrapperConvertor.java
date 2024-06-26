
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * 双精度浮点数包装类转换器
 * </p>
 *
 * @author 钟冀
 */
public class DoubleWrapperConvertor extends NumberConvertor<Double>{

    /**
     */
    public DoubleWrapperConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Double> getSourceType() {
        return Double.class;
    }
}
