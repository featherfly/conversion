
package cn.featherfly.conversion.string.basic;

/**
 * Class[]转换器.
 *
 * @author 钟冀
 */
@SuppressWarnings("rawtypes")
public class ClassArrayConvertor extends GenericTypeArrayConvertor<Class[], Class> {

    /**
     * Instantiates a new class array convertor.
     */
    public ClassArrayConvertor() {
        super(new ClassConvertor());
    }
}
