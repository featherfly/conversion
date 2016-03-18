
package cn.featherfly.conversion.core.basic;



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
