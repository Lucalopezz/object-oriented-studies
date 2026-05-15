package shared.domain.repositories;

public interface Repository <K, T>{
    void save(T item);
    T getById(K id);
    void deleteById(K id);
    void updateById(T item);
    T[] getAll();
    double[] salaryReport();
}
