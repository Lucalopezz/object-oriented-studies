package Try3.persistence;

import Try2.domain.EntityAlreadyExists;

import java.util.*;

public abstract class GenericDAO<K,T extends Entidade<K>> {
    Map<K,T> entidades = new LinkedHashMap<>();
    public void salvar(T entidade){
        if(entidades.containsKey(entidade.getId())) throw new EntityAlreadyExists("This entity already exists");
        entidades.put(entidade.getId(), entidade);
    }
    public Optional<T> getEntidade(K id){
        if(id == null) throw new IllegalArgumentException();
        return Optional.ofNullable(entidades.get(id));
    }
    public List<T> getEntidades() {
        return List.copyOf(entidades.values());
    }
    public void removerEntidade(K id){
        if(!entidades.containsKey(id)) throw new EntityAlreadyExists("This entity does not exists");
        entidades.remove(id);
    }
    public void atualizar(T entidade){
        if(!entidades.containsKey(entidade.getId())) throw new EntityAlreadyExists("This entity does not exists");
        entidades.put(entidade.getId(), entidade);
    }
}
