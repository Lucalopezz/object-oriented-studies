public interface Repository <Id, T>{
    void save(T item);
    T getById(Id id);
}
