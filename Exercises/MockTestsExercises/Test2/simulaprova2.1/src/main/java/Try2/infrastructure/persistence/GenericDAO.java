package Try2.infrastructure.persistence;

import Try2.domain.EntityAlreadyExists;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class GenericDAO <K, V extends Entidade<K>>  {
    private final Map<K, V> db = new LinkedHashMap<>();

    public void salvar(V value){
        final K id = value.getId();
        if(db.containsKey(id)) throw new EntityAlreadyExists("Entidade já cadastrada: " + id);
        db.put(id, value);
    }

    public void atualizar(V value){
        final K id = value.getId();
        if(!db.containsKey(id)) throw new NoSuchElementException("Entidade não cadastrada: " + id);
        db.replace(id, value);
    }

    public void remover(V value){
        remover(value.getId());
    }

    public void remover(K id){
        if(!db.containsKey(id)) throw new NoSuchElementException("Entidade não cadastrada: " + id);
        db.remove(id);
    }

    public Optional<V> buscarPorId(K id){
        return Optional.ofNullable(db.get(id));
    }
}
