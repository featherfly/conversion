
package cn.featherfly.conversion.string.basic;


/**
 * <p>
 * Boolean[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class BooleanArrayConvertor extends GenericTypeArrayConvertor<Boolean[], Boolean> {

    /**
     */
    public BooleanArrayConvertor() {
        super(new BooleanWrapperConvertor());
    }

    
}
