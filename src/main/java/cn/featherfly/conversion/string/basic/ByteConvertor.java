
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * 字节转换器
 * </p>
 *
 * @author 钟冀
 */
public class ByteConvertor extends NumberBasicTypeConvertor<Byte>{

    /**
     */
    public ByteConvertor() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Byte> getSourceType() {
        return byte.class;
    }
}
