package employee.application.services;

import employee.domein.Employee;
import shared.application.ServiceContract;
import shared.domain.repositories.Repository;

public class DeleteEmployeeService implements ServiceContract<String, Void> {
    private final Repository<String, Employee> repository;

    public DeleteEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID is required.");

        repository.deleteById(id);
        return null;
    }
}
