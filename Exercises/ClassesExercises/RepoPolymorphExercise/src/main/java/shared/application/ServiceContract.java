package shared.application;

public interface ServiceContract<T, R> {
    R execute(T input);
}
