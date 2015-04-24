
package cn.featherfly.conversion.basic;



/**
 * <p>
 * String[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringArrayConvertor extends GenericClassArrayConvertor<String[], String> {

    /**
     */
    public StringArrayConvertor() {
        super(new StringConvertor());
    }

}
