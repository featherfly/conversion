
package cn.featherfly.conversion.string.basic;

/**
 * 双精度浮点数包装类转换器.
 *
 * @author 钟冀
 */
public class DoubleWrapperConvertor extends NumberConvertor<Double> {

    /**
     * Instantiates a new double wrapper convertor.
     */
    public DoubleWrapperConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Double> getSourceType() {
        return Double.class;
    }
}
