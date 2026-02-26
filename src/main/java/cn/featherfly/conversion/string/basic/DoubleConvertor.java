
package cn.featherfly.conversion.string.basic;

/**
 * 双精度浮点数转换器.
 *
 * @author 钟冀
 */
public class DoubleConvertor extends NumberBasicTypeConvertor<Double> {

    /**
     * Instantiates a new double convertor.
     */
    public DoubleConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Double> getSourceType() {
        return double.class;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected Double doToObject(String value, Type<Double> genericType) {
    //        if (StringUtils.isNotBlank(value)) {
    //            return Double.parseDouble(value);
    //        }
    //        return -1d;
    //    }
}
