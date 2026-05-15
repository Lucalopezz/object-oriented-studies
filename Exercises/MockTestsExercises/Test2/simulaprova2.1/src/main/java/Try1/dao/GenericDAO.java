package Try1.dao;

import Try1.Entidade;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GenericDAO<K, T extends Entidade<K>> {
    // Shared in-memory "database" for the whole application.
    private static final Map<Class<?>, Map<Object, Object>> DATABASE = new ConcurrentHashMap<>();

    private final Class<T> entityClass;

    protected GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings("unchecked")
    private Map<K, T> tabela() {
        Map<?, ?> tabelaBruta = DATABASE.computeIfAbsent(entityClass, c -> new LinkedHashMap<>());
        return (Map<K, T>) tabelaBruta;
    }

    public void salvar(T entidade) {
        tabela().put(entidade.getId(), entidade);
    }

    public Optional<T> buscarPorId(K id) {
        return Optional.ofNullable(tabela().get(id));
    }

    public List<T> listarTodos() {
        return new ArrayList<>(tabela().values());
    }

    public boolean removerPorId(K id) {
        return tabela().remove(id) != null;
    }
}


