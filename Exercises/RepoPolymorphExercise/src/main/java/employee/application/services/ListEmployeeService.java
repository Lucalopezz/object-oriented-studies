package employee.application.services;

import employee.domein.Employee;
import shared.application.ServiceContract;
import shared.domain.repositories.Repository;

public class ListEmployeeService implements ServiceContract<Void, Employee[]> {
    private final Repository<String, Employee> repository;

    public ListEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    @Override
    public Employee[] execute(Void input) {
        return repository.getAll();
    }
}
