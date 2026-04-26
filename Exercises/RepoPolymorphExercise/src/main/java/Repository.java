public interface Repository <K, T>{
    void save(T item);
    T getById(K id);
}
