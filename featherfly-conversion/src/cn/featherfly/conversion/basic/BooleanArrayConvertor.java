
package cn.featherfly.conversion.basic;


/**
 * <p>
 * Boolean[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class BooleanArrayConvertor extends GenericClassArrayConvertor<Boolean[], Boolean> {

    /**
     */
    public BooleanArrayConvertor() {
        super(new BooleanWrapperConvertor());
    }

    
}
