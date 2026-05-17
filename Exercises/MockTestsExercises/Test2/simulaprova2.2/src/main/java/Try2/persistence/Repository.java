package Try2.persistence;

import java.util.Optional;

public interface Repository<K, T> {
    void save(T value);
    void update(T newValue);
    Optional<T> findById(K id);
}
