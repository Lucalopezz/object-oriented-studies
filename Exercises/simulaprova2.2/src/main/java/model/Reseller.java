package model;

import java.time.LocalDate;

public final class Reseller extends Employee {
    private final String idResponsavel;
    public Reseller(String id, String name, LocalDate dateOfBirth, double soldValue, String idResponsavel) {
        super(id, name, dateOfBirth, soldValue);
        this.idResponsavel = idResponsavel;
    }

    @Override
    public double getCommision() {
        return getSoldValue() * 0.15;
    }

    public String getIdResponsavel() {
        return idResponsavel;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", idResponsavel='%s'", idResponsavel);
    }
}
