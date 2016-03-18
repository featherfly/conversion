
package cn.featherfly.conversion.core.basic;



/**
 * <p>
 * StringBuffer[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBufferArrayConvertor extends GenericTypeArrayConvertor<StringBuffer[], StringBuffer> {

    /**
     */
    public StringBufferArrayConvertor() {
        super(new StringBufferConvertor());
    }
}
