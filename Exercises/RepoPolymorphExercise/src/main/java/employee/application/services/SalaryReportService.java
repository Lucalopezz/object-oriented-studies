package employee.application.services;

import employee.domein.Employee;
import shared.application.ServiceContract;
import shared.domain.repositories.Repository;

public class SalaryReportService implements ServiceContract<Void, double[]> {
    private final Repository<String, Employee> repository;

    public SalaryReportService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    @Override
    public double[] execute(Void input) {
        return repository.salaryReport();
    }
}
