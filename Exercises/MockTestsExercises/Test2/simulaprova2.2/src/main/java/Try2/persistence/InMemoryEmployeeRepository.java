package Try2.persistence;

import Try2.model.Consultant;
import Try2.model.Employee;
import Try2.persistence.exceptions.EntityAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryEmployeeRepository implements Repository<String, Employee> {
    private static final Map<String, Employee> DATABASE = new HashMap<>();

    @Override
    public void save(Employee value) {
        if (DATABASE.containsKey(value.getId()))
            throw new EntityAlreadyExistsException("Employee with id " + value.getId() + " already exists");
        DATABASE.put(value.getId(), value);


    }

    @Override
    public void update(Employee newValue) {
        if (!DATABASE.containsKey(newValue.getId())) throw new IllegalArgumentException("Employee with id " + newValue.getId() + " does not exist");
        DATABASE.put(newValue.getId(), newValue);

    }

    @Override
    public Optional<Employee> findById(String id) {
        Employee value = DATABASE.get(id);

        return Optional.ofNullable(value);
    }
}
