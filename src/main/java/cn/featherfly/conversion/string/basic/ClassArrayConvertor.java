
package cn.featherfly.conversion.string.basic;


/**
 * <p>
 * Class[]转换器
 * </p>
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class ClassArrayConvertor extends GenericTypeArrayConvertor<Class[], Class> {

    /**
     */
    public ClassArrayConvertor() {
        super(new ClassConvertor());
    }
}
