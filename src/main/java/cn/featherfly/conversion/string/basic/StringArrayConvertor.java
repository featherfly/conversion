
package cn.featherfly.conversion.string.basic;

/**
 * String[]转换器.
 *
 * @author 钟冀
 */
public class StringArrayConvertor extends GenericTypeArrayConvertor<String[], String> {

    /**
     * Instantiates a new string array convertor.
     */
    public StringArrayConvertor() {
        super(new StringConvertor());
    }

}
