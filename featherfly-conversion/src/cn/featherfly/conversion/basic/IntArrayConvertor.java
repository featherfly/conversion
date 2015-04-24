
package cn.featherfly.conversion.basic;



/**
 * <p>
 * Integer[]转换器
 * </p>
 * @author 钟冀
 */
public class IntArrayConvertor extends GenericClassArrayConvertor<Integer[], Integer> {

    /**
     */
    public IntArrayConvertor() {
        super(new IntegerConvertor());
    }

}
