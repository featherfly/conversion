
package cn.featherfly.conversion.string.basic;

/**
 * Byte[]转换器.
 *
 * @author 钟冀
 */
public class ByteArrayConvertor extends GenericTypeArrayConvertor<Byte[], Byte> {

    /**
     * Instantiates a new byte array convertor.
     */
    public ByteArrayConvertor() {
        super(new ByteWrapperConvertor());
    }
}
