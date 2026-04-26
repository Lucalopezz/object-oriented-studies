package employee.application.services;

import employee.domein.Employee;
import shared.application.ServiceContract;
import shared.domain.repositories.Repository;

public class FindEmployeeService implements ServiceContract<String, Employee> {

    private final Repository<String, Employee> repository;

    public FindEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    @Override
    public Employee execute(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID is required.");
        return repository.getById(id);
    }
}
