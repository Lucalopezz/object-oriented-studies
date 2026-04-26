public class FindEmployeeService {

    private final Repository<String, Employee> repository;

    public FindEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id) {
        if (id.isEmpty()) throw new IllegalArgumentException("ID is required.");

        return repository.getById(id);
    }
}
