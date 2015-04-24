
package cn.featherfly.conversion.core.basic;



/**
 * <p>
 * String[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringArrayConvertor extends GenericTypeArrayConvertor<String[], String> {

    /**
     */
    public StringArrayConvertor() {
        super(new StringConvertor());
    }

}
