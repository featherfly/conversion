
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * 单精度浮点数转换器
 * </p>
 *
 * @author 钟冀
 */
public class FloatConvertor extends NumberBasicTypeConvertor<Float>{

    /**
     */
    public FloatConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Float> getSourceType() {
        return float.class;
    }

//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected Float doToObject(String value, GenericType<Float> genericType) {
//        if (StringUtils.isNotBlank(value)) {
//            return Float.parseFloat(value);
//        }
//        return -1f;
//    }
}
