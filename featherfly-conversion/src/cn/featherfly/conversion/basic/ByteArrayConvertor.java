
package cn.featherfly.conversion.basic;


/**
 * <p>
 * Byte[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class ByteArrayConvertor extends GenericClassArrayConvertor<Byte[], Byte> {

    /**
     */
    public ByteArrayConvertor() {
        super(new ByteWrapperConvertor());
    }
}
