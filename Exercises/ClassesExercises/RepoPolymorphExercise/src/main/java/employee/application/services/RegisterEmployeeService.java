package employee.application.services;

import employee.domein.Employee;
import shared.application.ServiceContract;
import shared.domain.repositories.Repository;

public class RegisterEmployeeService implements ServiceContract<Employee, Void> {

    private final Repository<String, Employee> repository;

    public RegisterEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(Employee e) {
        if (e == null) throw new IllegalArgumentException("Employee must not be null.");
        if (e.getId() == null || e.getId().isBlank()) throw new IllegalArgumentException("ID is required.");
        if (e.getName() == null || e.getName().isBlank()) throw new IllegalArgumentException("Name is required.");

        if (repository.getById(e.getId()) != null) {
            throw new IllegalStateException("Employee " + e.getId() + " already exists.");
        }
        repository.save(e);
        return null;
    }
}
