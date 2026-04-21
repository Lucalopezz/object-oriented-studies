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

}