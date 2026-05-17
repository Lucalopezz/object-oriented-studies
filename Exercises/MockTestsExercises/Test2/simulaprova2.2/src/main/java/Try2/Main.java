package Try2;

import Try2.persistence.InMemoryEmployeeRepository;
import Try2.services.EmployeeRegistrationService;
import Try2.services.EmployeeReportService;

import java.time.LocalDate;

public class Main {
    void main(){
        InMemoryEmployeeRepository repository = new InMemoryEmployeeRepository();
        EmployeeRegistrationService registrationService = new EmployeeRegistrationService(repository);
        EmployeeReportService reportService = new EmployeeReportService(repository);

        registrationService.registerEmployee("12312312312", "David A. Huffman", LocalDate.parse("1925-08-09"), 7000.0, null);
        registrationService.registerEmployee("32132132131", "Augusta Ada Byron", LocalDate.parse("1852-11-27"), 3000.0, "12312312312");
        registrationService.registerEmployee("21321321313", "Edsger Wybe Dijkstra", LocalDate.parse("1930-05-11"), 1520.0, "12312312312");
        registrationService.registerEmployee("45645645646", "Alan Mathison Turing", LocalDate.parse("1912-06-23"), 780.0, "32132132131");
        registrationService.registerEmployee("90219021902", "Donald Ervin Knuth", LocalDate.parse("1938-01-10"), 432.0, "45645645646");
        registrationService.registerEmployee("54654654654", "Grace Murray Hopper", LocalDate.parse("1906-12-09"), 432.0, "21321321313");
        registrationService.registerEmployee("65465465464", "John von Neumann", LocalDate.parse("1903-12-28"), 300.00, "45645645646");

        System.out.println(reportService.reportOf("12312312312"));

    }
}
