import employee.application.services.DeleteEmployeeService;
import employee.application.services.FindEmployeeService;
import employee.application.services.ListEmployeeService;
import employee.application.services.RegisterEmployeeService;
import employee.application.services.SalaryReportService;
import employee.application.services.UpdateEmployeeService;
import employee.domein.Employee;
import employee.infrastructure.database.arraylist.FakeArrayListEmployeeRepository;
import shared.application.ServiceContract;
import shared.domain.repositories.Repository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // There are 2 types of repos -> manual(Array) and auto(ArrayList)
//      Repository<String, Models.Employee> repository = new FakeManualEmployeeRepository();
        Repository<String, Employee> repository = new FakeArrayListEmployeeRepository();
        ServiceContract<String, Employee> findService = new FindEmployeeService(repository);
        ServiceContract<Employee, Void> registerService = new RegisterEmployeeService(repository);
        ServiceContract<Void, Employee[]> listService = new ListEmployeeService(repository);
        ServiceContract<Employee, Void> updateService = new UpdateEmployeeService(repository);
        ServiceContract<String, Void> deleteService = new DeleteEmployeeService(repository);
        ServiceContract<Void, double[]> salaryReportService = new SalaryReportService(repository);

        registerService.execute(new Employee("1", "Rocha", "Treinador",
                100000, LocalDate.of(2020, 1, 1)));

        // Demonstrates duplicate handling without stopping the app.
        try {
            registerService.execute(new Employee("1", "Rocha", "Treinador",
                    100000, LocalDate.of(2020, 1, 1)));
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

        registerService.execute(new Employee("2", "Pacho", "Treinador",
                150000, LocalDate.of(2020, 1, 1)));
        registerService.execute(new Employee("3", "Ramon", "Atleta",
                200000, LocalDate.of(2020, 1, 1)));

        Employee found = findService.execute("2");
        if (found != null) {
            System.out.println("The best coach has been found: " + found.getName());
        }

        System.out.println("\nAll employees:");
        Employee[] employees = listService.execute(null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        updateService.execute(new Employee("2", "Pacho Updated", "Treinador",
                180000, LocalDate.of(2020, 1, 1)));

        Employee updated = findService.execute("2");
        if (updated != null) {
            System.out.println("\nUpdated employee 2: " + updated.getName());
        }

        deleteService.execute("3");
        System.out.println("\nEmployees after deleting id 3:");
        for (Employee employee : listService.execute(null)) {
            System.out.println(employee);
        }

        double[] report = salaryReportService.execute(null);
        System.out.println("\nSalary report -> sum bonus: " + report[0] + ", higher bonus: " + report[1]);


    }
}
