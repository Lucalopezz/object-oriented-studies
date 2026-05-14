package model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> subordinates;

    public Consultant(String id, String name, LocalDate dateOfBirth, double soldValue) {
        super(id, name, dateOfBirth, soldValue);
        subordinates = new LinkedHashSet<>();
    }

    public void addEmployee(Employee employee) {
        if (employee instanceof Consultant) throw new IllegalArgumentException("Consultant cannot have subordinates");
        if (employee.getId().equals(getId())) {
            throw new IllegalArgumentException(
                    "Employee cannot be subordinate of itself"
            );
        }
        subordinates.add(employee);
    }

    public Set<Employee> getEmployees() {
        return Set.copyOf(subordinates);
    }

    @Override
    public double getCommision() {
        return getSoldValue() * 0.15 + (subordinates.stream().mapToDouble(Employee::getCommision).sum() * 0.3);
    }
}
