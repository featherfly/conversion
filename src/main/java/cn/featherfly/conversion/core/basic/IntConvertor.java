
package cn.featherfly.conversion.core.basic;



/**
 * <p>
 * 整数转换器
 * </p>
 *
 * @author 钟冀
 */
public class IntConvertor extends NumberBasicTypeConvertor<Integer>{

    /**
     */
    public IntConvertor() {
    }
    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected Integer doToObject(String value, GenericType<Integer> genericType) {
//        if (StringUtils.isNotBlank(value)) {
//            return Integer.parseInt(value);
//        }
//        return -1;
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Integer> getType() {
        return int.class;
    }
}
