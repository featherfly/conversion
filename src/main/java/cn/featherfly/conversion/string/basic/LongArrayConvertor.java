
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * Long[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LongArrayConvertor extends GenericTypeArrayConvertor<Long[], Long> {

    /**
     */
    public LongArrayConvertor() {
        super(new LongWrapperConvertor());
    }
}
