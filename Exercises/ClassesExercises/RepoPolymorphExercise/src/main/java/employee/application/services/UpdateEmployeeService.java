package employee.application.services;

import employee.domein.Employee;
import shared.application.ServiceContract;
import shared.domain.repositories.Repository;

public class UpdateEmployeeService implements ServiceContract<Employee, Void> {
    private final Repository<String, Employee> repository;

    public UpdateEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee is required.");
        if (employee.getId() == null || employee.getId().isBlank()) throw new IllegalArgumentException("ID is required.");

        repository.updateById(employee);
        return null;
    }
}
