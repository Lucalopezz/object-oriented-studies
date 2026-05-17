package Try2.model;

import java.time.LocalDate;

public final class Reseller extends Employee {
    public Reseller(String id, String name, LocalDate dateOfBirth, double soldValue) {
        super(id, name, dateOfBirth, soldValue);
    }

    @Override
    public double getCommission() {
        return getSoldValue() * 0.15;
    }
}
