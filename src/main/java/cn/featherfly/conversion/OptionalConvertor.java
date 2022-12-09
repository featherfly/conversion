
package cn.featherfly.conversion;

import java.util.Optional;

/**
 * OptionalConvertor.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <T> the generic type
 */
public interface OptionalConvertor<S, T> extends Convertor<Optional<S>, T> {

}
