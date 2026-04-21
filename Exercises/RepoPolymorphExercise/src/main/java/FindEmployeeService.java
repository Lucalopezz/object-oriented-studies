public class FindEmployeeService {

    private final Repository<String, Employee> repository;

    public FindEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id) {
        return repository.getById(id);
    }
}
