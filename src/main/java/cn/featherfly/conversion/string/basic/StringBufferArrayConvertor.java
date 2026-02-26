
package cn.featherfly.conversion.string.basic;

/**
 * StringBuffer[]转换器.
 *
 * @author 钟冀
 */
public class StringBufferArrayConvertor extends GenericTypeArrayConvertor<StringBuffer[], StringBuffer> {

    /**
     * Instantiates a new string buffer array convertor.
     */
    public StringBufferArrayConvertor() {
        super(new StringBufferConvertor());
    }
}
