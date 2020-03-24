
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * Integer[]转换器
 * </p>
 * @author 钟冀
 */
public class IntArrayConvertor extends GenericTypeArrayConvertor<Integer[], Integer> {

    /**
     */
    public IntArrayConvertor() {
        super(new IntegerConvertor());
    }

}
