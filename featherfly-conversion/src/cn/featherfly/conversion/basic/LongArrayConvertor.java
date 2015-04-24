
package cn.featherfly.conversion.basic;



/**
 * <p>
 * Long[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class LongArrayConvertor extends GenericClassArrayConvertor<Long[], Long> {

    /**
     */
    public LongArrayConvertor() {
        super(new LongWrapperConvertor());
    }
}
