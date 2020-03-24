
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * Short[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class ShortArrayConvertor extends GenericTypeArrayConvertor<Short[], Short> {

    /**
     */
    public ShortArrayConvertor() {
        super(new ShortWrapperConvertor());
    }
}
