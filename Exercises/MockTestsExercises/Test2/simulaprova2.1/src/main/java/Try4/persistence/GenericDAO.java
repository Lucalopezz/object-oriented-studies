package Try4.persistence;


import Try2.domain.EntityAlreadyExists;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class GenericDAO <K, T extends Entidade<K>>{
    private Map<K, T> DATABASE = new HashMap<>();

    public void save(T entity) {
        if (DATABASE.containsKey(entity.getId())) throw new EntityAlreadyExists("There is already an entity with the id " + entity.getId());
        DATABASE.put(entity.getId(), entity);
    }
    public Optional<T> get(K id) {
        return Optional.ofNullable(DATABASE.get(id));
    }
    public void update(T entity) {
        if (!DATABASE.containsKey(entity.getId())) throw new IllegalArgumentException("There is no entity with the id " + entity.getId());

        DATABASE.put(entity.getId(), entity);
    }
}
