
package cn.featherfly.conversion.core.basic;



/**
 * <p>
 * 短整形转换器
 * </p>
 *
 * @author 钟冀
 */
public class ShortConvertor extends NumberBasicTypeConvertor<Short>{

    /**
     */
    public ShortConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Short> getType() {
        return short.class;
    }

//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected Short doToObject(String value, GenericType<Short> genericType) {
//        if (StringUtils.isNotBlank(value)) {
//            return Short.parseShort(value);
//        }
//        return -1;
//    }
}
