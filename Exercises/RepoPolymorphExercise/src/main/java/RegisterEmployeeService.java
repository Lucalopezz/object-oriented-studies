public class RegisterEmployeeService {

    private final Repository<String, Employee> repository;

    public RegisterEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee e){
        if (repository.getById(e.getId()) == null) {
            repository.save(e);
        }
    }
}
