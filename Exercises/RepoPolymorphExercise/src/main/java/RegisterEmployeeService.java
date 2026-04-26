public class RegisterEmployeeService {

    private final Repository<String, Employee> repository;

    public RegisterEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee e){
        if (e == null) throw new IllegalArgumentException("Employee must not be null.");
        if (e.getId() == null) throw new IllegalArgumentException("ID is required.");
        if (e.getName() == null || e.getName().isBlank()) throw new IllegalArgumentException("Name is required.");

        if (repository.getById(e.getId()) != null) {
            throw new IllegalStateException("Employee " + e.getId() + " already exists.");
        }
        repository.save(e);
    }
}
