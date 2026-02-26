
package cn.featherfly.conversion.string.basic;

/**
 * Boolean[]转换器.
 *
 * @author 钟冀
 */
public class BooleanArrayConvertor extends GenericTypeArrayConvertor<Boolean[], Boolean> {

    /**
     * Instantiates a new boolean array convertor.
     */
    public BooleanArrayConvertor() {
        super(new BooleanWrapperConvertor());
    }

}
