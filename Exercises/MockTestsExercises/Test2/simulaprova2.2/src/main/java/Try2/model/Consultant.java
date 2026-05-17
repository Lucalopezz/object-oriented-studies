package Try2.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> subordinados = new HashSet<>();

    public Consultant(String id, String name, LocalDate dateOfBirth, double soldValue) {
        super(id, name, dateOfBirth, soldValue);
    }

    @Override
    public double getCommission() {
        return 0;
    }

    public void addEmployee(Employee employee) {
        subordinados.remove(employee);
        subordinados.add(employee);
    }

    public Set<Employee> getEmployees() {
        return subordinados;
    }
}
