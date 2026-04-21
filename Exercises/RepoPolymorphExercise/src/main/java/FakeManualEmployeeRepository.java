public class FakeManualEmployeeRepository implements Repository<String, Employee>{
    Employee[] employees = new Employee[10];
    int count = 0;

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
}
