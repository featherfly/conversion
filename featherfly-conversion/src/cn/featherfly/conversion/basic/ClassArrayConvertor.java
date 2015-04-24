
package cn.featherfly.conversion.basic;


/**
 * <p>
 * Class[]转换器
 * </p>
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class ClassArrayConvertor extends GenericClassArrayConvertor<Class[], Class> {

    /**
     */
    public ClassArrayConvertor() {
        super(new ClassConvertor());
    }
}
