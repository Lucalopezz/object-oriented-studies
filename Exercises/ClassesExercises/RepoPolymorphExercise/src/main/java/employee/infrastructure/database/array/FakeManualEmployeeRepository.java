package employee.infrastructure.database.array;

import employee.domein.Employee;
import shared.domain.repositories.Repository;

public class FakeManualEmployeeRepository implements Repository<String, Employee> {
    private final Employee[] employees = new Employee[10];
    private int count = 0;

    @Override
    public void save(Employee item) {
        if (count < employees.length) {
            employees[count] = item;
            count++;
        }
    }

    @Override
    public Employee getById(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equals(id)) {
                employees[i] = employees[count];
                employees[count] = employees[count -1];
                employees[count] = null;
                count--;
                break;
            }
        }
    }

    @Override
    public void updateById(Employee item) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equals(item.getId())) {
                employees[i] = item;
                break;
            }
        }
    }

    @Override
    public Employee[] getAll() {
        return employees;
    }

    @Override
    public double[] salaryReport() {
        double sum = 0;
        double higher = employees[0].calculateBonus();
        for (int i = 0; i < count; i++) {
            Employee employee = employees[i];
            double sal = employee.calculateBonus();
            sum +=  sal;
            if (sal > higher) {
                higher = sal;
            }
        }
        return new double[]{sum, higher};
    }
}
