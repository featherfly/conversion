
package cn.featherfly.conversion.string.basic;

/**
 * 长整数转换器.
 *
 * @author 钟冀
 */
public class LongConvertor extends NumberBasicTypeConvertor<Long> {

    /**
     * Instantiates a new long convertor.
     */
    public LongConvertor() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Long> getSourceType() {
        return long.class;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected Long doToObject(String value, Type<Long> genericType) {
    //        if (StringUtils.isNotBlank(value)) {
    //            return Long.parseLong(value);
    //        }
    //        return -1L;
    //    }
}
