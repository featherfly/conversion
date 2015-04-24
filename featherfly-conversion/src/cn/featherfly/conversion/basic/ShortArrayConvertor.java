
package cn.featherfly.conversion.basic;



/**
 * <p>
 * Short[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class ShortArrayConvertor extends GenericClassArrayConvertor<Short[], Short> {

    /**
     */
    public ShortArrayConvertor() {
        super(new ShortWrapperConvertor());
    }
}
