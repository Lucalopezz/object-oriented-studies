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

        // ERRO aqui
        Reseller reseller =
                new Reseller(id, name, birthDate, soldValue);


        if (consultantId == null) {
            repository.save(reseller);
            return;
        }

        Employee responsible = repository.findById(consultantId)
                .orElseThrow(() -> new IllegalArgumentException("Responsible employee not found"));

        Consultant consultant;

        // se já for consultant
        if (responsible instanceof Consultant c) {

            consultant = c;

        } else {

            // promove reseller para consultant
            consultant = new Consultant(
                    responsible.getId(),
                    responsible.getName(),
                    responsible.getDateOfBirth(),
                    responsible.getSoldValue()
            );

            repository.update(consultant);
        }


        consultant.addEmployee(reseller);

        // salva novo reseller
        repository.save(reseller);

        // atualiza consultant
        repository.update(consultant);
    }
}