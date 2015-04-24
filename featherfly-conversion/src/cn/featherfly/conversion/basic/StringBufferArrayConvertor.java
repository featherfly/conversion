
package cn.featherfly.conversion.basic;



/**
 * <p>
 * StringBuffer[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBufferArrayConvertor extends GenericClassArrayConvertor<StringBuffer[], StringBuffer> {

    /**
     */
    public StringBufferArrayConvertor() {
        super(new StringBufferConvertor());
    }
}
