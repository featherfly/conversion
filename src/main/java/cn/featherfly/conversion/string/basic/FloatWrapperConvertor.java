package cn.featherfly.conversion.string.basic;

/**
 * 单精度浮点数包装类转换器.
 *
 * @author 钟冀
 */
public class FloatWrapperConvertor extends NumberConvertor<Float> {

    /**
     * Instantiates a new float wrapper convertor.
     */
    public FloatWrapperConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Float> getSourceType() {
        return Float.class;
    }
}
