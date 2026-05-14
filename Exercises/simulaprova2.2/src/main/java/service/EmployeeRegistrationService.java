package service;

import model.Consultant;
import model.Employee;
import model.Reseller;
import persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {

    private final Repository<String, Employee> repository;

    public EmployeeRegistrationService(
            Repository<String, Employee> repository
    ) {
        this.repository = repository;
    }

    public void register(
            String id,
            String name,
            LocalDate birthDate,
            double soldValue,
            String consultantId
    ) {

        // ERRO aqui  -> devido ao ID que está no reseller
        Reseller reseller =
                new Reseller(id, name, birthDate, soldValue);

    }
}