
package cn.featherfly.conversion.string.basic;


/**
 * <p>
 * Byte[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class ByteArrayConvertor extends GenericTypeArrayConvertor<Byte[], Byte> {

    /**
     */
    public ByteArrayConvertor() {
        super(new ByteWrapperConvertor());
    }
}
