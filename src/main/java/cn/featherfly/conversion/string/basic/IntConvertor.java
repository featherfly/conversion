
package cn.featherfly.conversion.string.basic;

/**
 * 整数转换器.
 *
 * @author 钟冀
 */
public class IntConvertor extends NumberBasicTypeConvertor<Integer> {

    /**
     * Instantiates a new int convertor.
     */
    public IntConvertor() {
        super();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected Integer doToObject(String value, Type<Integer> genericType) {
    //        if (StringUtils.isNotBlank(value)) {
    //            return Integer.parseInt(value);
    //        }
    //        return -1;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Integer> getSourceType() {
        return int.class;
    }
}
