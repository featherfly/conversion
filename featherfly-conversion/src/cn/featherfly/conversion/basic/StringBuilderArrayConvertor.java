
package cn.featherfly.conversion.basic;



/**
 * <p>
 * StringBuilder[]转换器
 * </p>
 *
 * @author 钟冀
 */
public class StringBuilderArrayConvertor extends GenericClassArrayConvertor<StringBuilder[], StringBuilder> {

    /**
     */
    public StringBuilderArrayConvertor() {
        super(new StringBuilderConvertor());
    }
}
