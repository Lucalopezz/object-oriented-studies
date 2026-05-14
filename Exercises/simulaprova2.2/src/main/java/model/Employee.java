package model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits Consultant, Reseller {
    private final String id;
    private String name;
    private LocalDate dateOfBirth;
    private double soldValue;

    public Employee(String id, String name, LocalDate dateOfBirth, double soldValue) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.soldValue = soldValue;
    }

    public abstract double getCommision();
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("model.Employee: id='%s', name='%s', dateOfBirth=%s, soldValue=%.2f", id, name, dateOfBirth, soldValue);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSoldValue(double soldValue) {
        this.soldValue = soldValue;
    }
}
