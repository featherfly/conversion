
package cn.featherfly.conversion.string.basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.conversion.string.ToStringConvertor;


/**
 * <p>
 * 数组转换器
 * </p>
 * @param <A> 数组自身类型
 * @param <G> 描述类型
 * @param <E> 数组项类型
 * @param <GT> 描述类型
 * @author 钟冀
 */
public abstract class ArrayConvertor<A, G extends GenericType<A>, E, GT extends GenericType<E>> 
    extends AbstractBasicConvertor<A, G>{

    /**
     * @param convertor conversion
     */
    public ArrayConvertor(ToStringConvertor<E> convertor) {
        this.convertor = convertor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public String doToString(A value, G genericType) {
        if (value != null) {
            Class<?> type = value.getClass();
            if (type.isArray()) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < Array.getLength(value); i++) {
                    // TODO 这里只能使用null
                    result.append(convertor.sourceToTarget((E) Array.get(value, i), getArrayItemGenericType(genericType)))
                              .append(Chars.COMMA);
                }
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
                return result.toString();
            }
        }
        return "";
    }
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public A doToObject(String value, G genericType) {
        Class<A> type = getSourceType();
        if (StringUtils.isNotBlank(value) && type != null) {
            String[] values = StringUtils.split(value, Chars.COMMA);
            List<String> valueList = Arrays.asList(values);
            Iterator<String> it = valueList.iterator();
            while (it.hasNext()) {
                String v = it.next();
                if (StringUtils.isBlank(v)) {
                    it.remove();
                }
            }
            Object result = Array.newInstance(type.getComponentType(), valueList.size());
            for (int i = 0; i < valueList.size(); i++) {
                String v = valueList.get(i).trim();
                Array.set(result, i
                        , convertor.targetToSource(v , getArrayItemGenericType(genericType)));
            }
            return (A) result;
        }
        return null;
    }
    /**
     * <p>
     * 获取数组元素GenericType
     * </p>
     * @param genericType genericType
     * @return 数组元素GenericType
     */
    protected abstract GT getArrayItemGenericType(G genericType);

//    /**
//     * <p>
//     * 字符串到数组
//     * </p>
//     * @param value 字符串
//     * @param type 数组自身类型
//     * @return 数组
//     */
//    @SuppressWarnings("unchecked")
//    protected A stringToArray(String value, Class<?> type) {
//        if (StringUtils.isNotBlank(value) && type != null) {
//            String[] values = null;
//            if (value.contains(Chars.COMMA)) {
//                values = value.split(Chars.COMMA);
//            } else {
//                values = new String[]{value};
//            }
//            List<String> valueList = Arrays.asList(values);
//            Iterator<String> it = valueList.iterator();
//            while (it.hasNext()) {
//                String v = it.next();
//                if (StringUtils.isBlank(v)) {
//                    it.remove();
//                }
//            }
//            Object result = Array.newInstance(type.getComponentType(), valueList.size());
//            for (int i = 0; i < valueList.size(); i++) {
//                String v = valueList.get(i).trim();
//                Array.set(result, i, convertor.toObject(v
//                        , (Class<E>) type.getComponentType()));
//            }
//            return (A) result;
//        }
//        return null;
//    }
//
//    /**
//     * <p>
//     * 字符串到数组
//     * </p>
//     * @param value 字符串
//     * @param beanProperty beanProperty
//     * @return 数组
//     */
//    @SuppressWarnings("unchecked")
//    protected A stringToArray(String value, BeanProperty beanProperty) {
//        if (StringUtils.isNotBlank(value) && beanProperty != null) {
//            String[] values = null;
//            if (value.contains(Chars.COMMA)) {
//                values = value.split(Chars.COMMA);
//            } else {
//                values = new String[]{value};
//            }
//            List<String> valueList = Arrays.asList(values);
//            Iterator<String> it = valueList.iterator();
//            while (it.hasNext()) {
//                String v = it.next();
//                if (StringUtils.isBlank(v)) {
//                    it.remove();
//                }
//            }
//            Object result = Array.newInstance(beanProperty.getType().getComponentType(), valueList.size());
//            for (int i = 0; i < valueList.size(); i++) {
//                String v = valueList.get(i).trim();
//                Array.set(result, i, convertor.toObject(v, beanProperty));
//            }
//            return (A) result;
//        }
//        return null;
//    }
//
//    /**
//     * <p>
//     * 数组到字符串
//     * </p>
//     * @param value 数组
//     * @param type 数组自身类型
//     * @return 数组
//     */
//    public String arrayToString(E[] value, Class<?> type) {
//        if (value != null) {
//            for (E e : value) {
//                StringBuilder result = new StringBuilder();
//                for (int i = 0; i < value.length; i++) {
//                    result.append(convertor.toString(e, null))
//                        .append(Chars.COMMA);
//                }
//                result.deleteCharAt(result.length() - 1);
//                return result.toString();
//            }
//        }
//        return null;
//    }
//
//    /**
//     * <p>
//     * 数组到字符串
//     * </p>
//     * @param value 数组
//     * @param beanProperty beanProperty
//     * @return 数组
//     */
//    public String arrayToString(E[] value, BeanProperty beanProperty) {
//        if (value != null) {
//            for (E e : value) {
//                StringBuilder result = new StringBuilder();
//                for (int i = 0; i < value.length; i++) {
//                    result.append(convertor.toString(e, beanProperty))
//                        .append(Chars.COMMA);
//                }
//                result.deleteCharAt(result.length() - 1);
//                return result.toString();
//            }
//        }
//        return null;
//    }

    private ToStringConvertor<E> convertor;

    /**
     * 返回conversion
     * @return conversion
     */
    public ToStringConvertor<E> getConvertor() {
        return convertor;
    }
}
