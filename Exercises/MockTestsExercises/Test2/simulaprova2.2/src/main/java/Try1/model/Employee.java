package Try1.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s] %s | %s | Amount in sales: US$%f | Comission: US$ %f", id, name, dt.format(getDateOfBirth()), soldValue, getCommision());
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
