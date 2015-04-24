
package cn.featherfly.conversion.core.basic;



/**
 * <p>
 * 长整数转换器
 * </p>
 *
 * @author 钟冀
 */
public class LongConvertor extends NumberBasicTypeConvertor<Long>{

    /**
     */
    public LongConvertor() {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Long> getType() {        
        return long.class;
    }
    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected Long doToObject(String value, GenericType<Long> genericType) {
//        if (StringUtils.isNotBlank(value)) {
//            return Long.parseLong(value);
//        }
//        return -1L;
//    }
}
