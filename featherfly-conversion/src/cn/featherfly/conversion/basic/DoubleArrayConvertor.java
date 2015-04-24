
package cn.featherfly.conversion.basic;



/**
 * <p>
 * Double[]转换器
 * </p>
 * <p>
 * copyright featherfly 2010-2020, all rights reserved.
 * </p>
 *
 * @author 钟冀
 */
public class DoubleArrayConvertor extends GenericClassArrayConvertor<Double[], Double> {

    /**
     */
    public DoubleArrayConvertor() {
        super(new DoubleWrapperConvertor());
    }
}
