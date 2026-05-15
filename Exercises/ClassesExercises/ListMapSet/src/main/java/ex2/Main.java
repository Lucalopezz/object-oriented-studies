package ex2;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    void main(){
        Company company = new Company();
        company.hire("1", "Alice", "Developer", 5000, LocalDate.of(2020, 1, 15));
        company.hire("2", "Bob", "Designer", 4500, LocalDate.of(2019, 3, 10));
        company.hire("3", "Charlie", "Developer", 5500, LocalDate.of(2021, 6, 5));

        System.out.println("All Employees:");
        Iterator<Employee> allEmployees = company.getEmployees();
        while (allEmployees.hasNext()) {
            System.out.println(allEmployees.next());
        }

        System.out.println("\nDevelopers:");
        Iterator<Employee> developers = company.getEmployees("Developer");
        while (developers.hasNext()) {
            System.out.println(developers.next());
        }

        company.pay("1");
        company.increaseSalary("2", 4800);
    }
}
