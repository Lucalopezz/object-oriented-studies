package persistence;

import exeption.EntityAlreadyExistsException;
import model.Consultant;
import model.Employee;

import java.util.*;

public class InMemoryEmployeeRepository implements Repository<String, Employee> {
    private final Map<String, Employee> employees = new LinkedHashMap<>();

    @Override
    public void save(Employee value) {
        if (value == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        if (get(value.getId()) != null) {
            throw new EntityAlreadyExistsException(
                    "Employee with id " + value.getId() + " already exists"
            );
        }

        employees.put(value.getId(), value);
    }

    @Override
    public void update(Employee newValue) {
        if (newValue == null) throw new IllegalArgumentException("Employee cannot be null");
        if (get(newValue.getId()) == null) {
            throw new IllegalArgumentException("Employee with id " + newValue.getId() + " does not exist");
        }
        employees.put(newValue.getId(), newValue);
    }

    // Estou com duvidas aqui, desse modo está usando objetos em memória (Map<String, Employee>)
    // e os relacionamentos já estão apontando para os mesmos objetos.
    // Então consigo pegar os subordinados
    // Mas falando com meus amigos e vendo umas soluçoes do gpt, vi que tem uma
    // abordagem que usa recursão
    @Override
    public Optional<Employee> findById(String id) {
        Employee employee = get(id);

        if (employee instanceof Consultant consultant) {

            consultant.getEmployees().forEach(subordinate ->
                    findById(subordinate.getId())
                            .ifPresent(consultant::addEmployee)
            );
        }

        return Optional.of(employee);
    }


    private Employee get(String id) {
        return employees.get(id);
    }
}
