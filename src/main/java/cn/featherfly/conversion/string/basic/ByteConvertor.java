
package cn.featherfly.conversion.string.basic;

/**
 * 字节转换器.
 *
 * @author 钟冀
 */
public class ByteConvertor extends NumberBasicTypeConvertor<Byte> {

    /**
     * Instantiates a new byte convertor.
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
