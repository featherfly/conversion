
package cn.featherfly.conversion.string.basic;

/**
 * Double[]转换器.
 *
 * @author 钟冀
 */
public class DoubleArrayConvertor extends GenericTypeArrayConvertor<Double[], Double> {

    /**
     * Instantiates a new double array convertor.
     */
    public DoubleArrayConvertor() {
        super(new DoubleWrapperConvertor());
    }
}
