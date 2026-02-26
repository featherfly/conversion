
package cn.featherfly.conversion.string.basic;

/**
 * Long[]转换器.
 *
 * @author 钟冀
 */
public class LongArrayConvertor extends GenericTypeArrayConvertor<Long[], Long> {

    /**
     * Instantiates a new long array convertor.
     */
    public LongArrayConvertor() {
        super(new LongWrapperConvertor());
    }
}
