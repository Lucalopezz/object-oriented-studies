package Try2.services;

import Try2.model.Reseller;
import Try2.model.Consultant;
import Try2.model.Employee;
import Try2.persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final Repository<String, Employee> repository;

    public EmployeeRegistrationService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void registerEmployee(String id, String name, LocalDate dateOfBirth, double soldValue, String idSuperior) {
        if (id == null || id.isEmpty() || name == null
                || name.isEmpty() || dateOfBirth == null || soldValue <= 0)
            throw new IllegalArgumentException();

        Employee newEmployee = new Reseller(id, name, dateOfBirth, soldValue);

        repository.save(newEmployee);

        if (idSuperior == null || idSuperior.isEmpty()) return;

        Employee boss = repository.findById(idSuperior).orElseThrow();



        Consultant consultant;
        if (boss instanceof Consultant c){
            consultant = c;
            consultant.addEmployee(newEmployee);
        }else {
            Reseller reseller = (Reseller) boss;

            consultant = new Consultant(
                    reseller.getId(),
                    reseller.getName(),
                    reseller.getDateOfBirth(),
                    reseller.getSoldValue()
            );
            consultant.addEmployee(newEmployee);
            repository.update(consultant);
        }
    }

}
