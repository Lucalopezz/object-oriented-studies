package service;

import model.Consultant;
import model.Employee;
import model.Reseller;
import persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {

    private Repository<String, Employee> repository;

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
            String consultantInChargeId
    ) {

        Employee newEmployee = new Reseller(id, name, birthDate, soldValue);

        repository.save(newEmployee);

        if (consultantInChargeId == null) {
            return;
        }

        // Se tiver consultantInChargeId, preciso pegar o 'chefe'
        // e adicionar o novo funcionário como subordinado
        Employee boss = repository.findById(consultantInChargeId)
                .orElseThrow();

        Consultant consultant;

        // Se o 'chefe' for um consultant, posso adicionar o novo funcionário como subordinado
        if (boss instanceof Consultant c) {

            consultant = c;

        } else {
            // Se não for um consultant, criar um novo consultant com os mesmos dados do 'chefe'

            Reseller reseller = (Reseller) boss;

            consultant = new Consultant(
                    reseller.getId(),
                    reseller.getName(),
                    reseller.getDateOfBirth(),
                    reseller.getSoldValue()
            );

            repository.update(consultant);
        }

        consultant.addEmployee(newEmployee);
    }
}