package Try1.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> subordinates;

    public Consultant(String id, String name, LocalDate dateOfBirth, double soldValue) {
        super(id, name, dateOfBirth, soldValue);
        subordinates = new LinkedHashSet<>();
    }

    public void addEmployee(Employee e) {
        subordinates.remove(e);
        subordinates.add(e);
    }

    public Set<Employee> getEmployees() {
        return Set.copyOf(subordinates);
    }

    @Override
    public double getCommision() {
        return getSoldValue() * 0.15 + (subordinates.stream().mapToDouble(Employee::getCommision).sum() * 0.3);
    }
}
