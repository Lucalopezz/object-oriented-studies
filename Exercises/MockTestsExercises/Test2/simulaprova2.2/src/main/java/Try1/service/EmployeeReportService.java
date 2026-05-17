package Try1.service;

import Try1.model.Consultant;
import Try1.model.Employee;
import Try1.persistence.Repository;

public class EmployeeReportService {
    private final Repository<String, Employee> repository;

    public EmployeeReportService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public String reportOf(String id) {
        Employee employee = repository.findById(id).orElseThrow();

        StringBuilder sb = new StringBuilder();

        generateReport(employee, sb, 0);

        return sb.toString();

    }

    private void generateReport(Employee employee, StringBuilder builder, int level) {
        builder.repeat("  ", level).append(employee).append("\n");

        if (employee instanceof Consultant consultant) {
            consultant.getEmployees().forEach(s -> generateReport(s, builder, level + 1));
        }
    }
}
