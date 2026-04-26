package employee.infrastructure.database.arraylist;

import employee.domein.Employee;
import shared.domain.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class FakeArrayListEmployeeRepository implements Repository<String, Employee> {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee getById(String id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(String id) {
        employees.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public void updateById(Employee item) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(item.getId())) {
                employees.set(i, item);
                break;
            }
        }
    }

    @Override
    public Employee[] getAll() {
        return employees.toArray(new Employee[0]);
    }

    @Override
    public double[] salaryReport() {
        double sum = 0;
        double higher = employees.getFirst().calculateBonus();
        for (Employee employee : employees) {
            double sal = employee.calculateBonus();
            sum += sal;
            if (sal > higher) {
                higher = sal;
            }
        }
        return new double[]{sum, higher};
    }

}