
package cn.featherfly.conversion.string;

import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.conversion.Conversion;

/**
 * 转换器.
 *
 * @author 钟冀
 */
public interface ToStringConversion extends Conversion<String> {

    /**
     * 指定类型转换为目标类型 .
     *
     * @param <S> the generic type
     * @param source the source
     * @return string
     */
    default <S> String sourceToTarget(S source) {
        return sourceToTarget(source, ClassType.STRING);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <S> String sourceToTarget(S source, Class<String> targetType) {
        return sourceToTarget(source, ClassType.STRING);
    }
}
