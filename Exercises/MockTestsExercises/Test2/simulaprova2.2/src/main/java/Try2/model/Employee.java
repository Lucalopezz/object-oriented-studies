package Try2.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract sealed class Employee permits Consultant, Reseller {
    private final String id;
    private final String name;
    private final LocalDate dateOfBirth;
    private final double soldValue;

    public Employee(String id, String name, LocalDate dateOfBirth, double soldValue) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.soldValue = soldValue;
    }

    public abstract double getCommission();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public String toString() {
        return String.format("Employee id='%s', name='%s', dateOfBirth=%s, soldValue=%.2f", id, name, dateOfBirth, soldValue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public double getSoldValue() {
        return soldValue;
    }
}
