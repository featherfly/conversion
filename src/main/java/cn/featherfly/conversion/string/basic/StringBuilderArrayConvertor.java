
package cn.featherfly.conversion.string.basic;

/**
 * StringBuilder[]转换器.
 *
 * @author 钟冀
 */
public class StringBuilderArrayConvertor extends GenericTypeArrayConvertor<StringBuilder[], StringBuilder> {

    /**
     * Instantiates a new string builder array convertor.
     */
    public StringBuilderArrayConvertor() {
        super(new StringBuilderConvertor());
    }
}
