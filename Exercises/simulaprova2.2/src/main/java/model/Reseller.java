package model;

import java.time.LocalDate;

public final class Reseller extends Employee {
    public Reseller(String id, String name, LocalDate dateOfBirth, double soldValue) {
        super(id, name, dateOfBirth, soldValue);
    }
    @Override
    public double getCommision() {
        return getSoldValue() * 0.15;
    }
}
