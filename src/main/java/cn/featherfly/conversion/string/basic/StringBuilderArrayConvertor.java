
package cn.featherfly.conversion.string.basic;



/**
 * <p>
 * StringBuilder[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBuilderArrayConvertor extends GenericTypeArrayConvertor<StringBuilder[], StringBuilder> {

    /**
     */
    public StringBuilderArrayConvertor() {
        super(new StringBuilderConvertor());
    }
}
