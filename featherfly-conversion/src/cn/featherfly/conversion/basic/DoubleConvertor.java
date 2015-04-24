
package cn.featherfly.conversion.basic;



/**
 * <p>
 * 双精度浮点数转换器
 * </p>
 *
 * @author 钟冀
 */
public class DoubleConvertor extends NumberBasicTypeConvertor<Double>{

    /**
     */
    public DoubleConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Double> getType() {
        return double.class;
    }

//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected Double doToObject(String value, GenericType<Double> genericType) {
//        if (StringUtils.isNotBlank(value)) {
//            return Double.parseDouble(value);
//        }
//        return -1d;
//    }
}
