
package cn.featherfly.conversion.string.basic;

/**
 * Integer[]转换器.
 *
 * @author 钟冀
 */
public class IntArrayConvertor extends GenericTypeArrayConvertor<Integer[], Integer> {

    /**
     * Instantiates a new int array convertor.
     */
    public IntArrayConvertor() {
        super(new IntegerConvertor());
    }

}
