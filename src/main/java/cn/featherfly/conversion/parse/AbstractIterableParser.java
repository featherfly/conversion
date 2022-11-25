
package cn.featherfly.conversion.parse;

import java.lang.reflect.Array;
import java.util.Collection;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.common.lang.Lang;


/**
 * <p>
 * 可迭代对象抽象解析器，完成可迭代对象（数组，集合）配置的解析，具体解析方式由子类实现类实现。
 * </p>
 * @param <G> 解析的目标类型描述
 * @author 钟冀
 */
public abstract class AbstractIterableParser<G extends Type<?>> extends AbstractParser<G>{
//    /**
//     * 协议字符串常量
//     */
//    public static final String CLASS_PROTOCOL = "constant";

    /**
     */
    public AbstractIterableParser() {
    }
    /**
     * <p>
     * 解析传入的字符串
     * </p>
     * @param <T> 返回类型
     * @param content 需要解析的内容
     * @param to 解析的目标类型描述
     * @return 解析后的对象
     */
    protected abstract <T> T doParseContent(String content, G to);
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T doParse(String content, G to) {
        if (Lang.isEmpty(content)) {
            return null;
        }
        try {
            String splitSign = Chars.COMMA;
            if (content.contains(splitSign) || isMultyType(to.getType())) {
                String[] contents = content.split(splitSign);
                if (to.getType().isArray()) {
                    Object array = Array.newInstance(to.getType(), contents.length);
                    for (int i = 0; i < contents.length; i++) {
                        String c = contents[i].trim();
                        Array.set(array, i, doParseContent(c, to));
                    }
                    return (T) array;
                } else if (ClassUtils.isParent(Collection.class, to.getType())) {
                    Collection<Object> collection = CollectionUtils.newInstance(to.getType());
                    for (int i = 0; i < contents.length; i++) {
                        String c = contents[i].trim();
                        collection.add(doParseContent(c, to));
                    }
                    return (T) collection;
                } else {
                    throw new ParseException("目标类型不是Array也不是Collection,但是转换值包含半角逗号（,）,无法进行转换");
                }
            } else {
                return (T) doParseContent(content, to);
            }
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    /**
     * <p>
     * 判断传入类型是否是多对象
     * </p>
     * @param type type
     * @return 否是多对象
     */
    protected boolean isMultyType(Class<?> type) {
        return type.isArray()
                || ClassUtils.isParent(Collection.class, type);
    }
}
