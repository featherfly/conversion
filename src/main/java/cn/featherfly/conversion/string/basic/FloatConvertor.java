package cn.featherfly.conversion.string.basic;

/**
 * 单精度浮点数转换器.
 *
 * @author 钟冀
 */
public class FloatConvertor extends NumberBasicTypeConvertor<Float> {

    /**
     * Instantiates a new float convertor.
     */
    public FloatConvertor() {
        super();
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
    //    protected Float doToObject(String value, Type<Float> genericType) {
    //        if (StringUtils.isNotBlank(value)) {
    //            return Float.parseFloat(value);
    //        }
    //        return -1f;
    //    }
}
