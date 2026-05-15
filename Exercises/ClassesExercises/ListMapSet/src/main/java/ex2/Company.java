package ex2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class Company {

    private final Map<String, Employee> employees = new HashMap<>();


    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        if (employees.containsKey(id)) {
            System.out.println("Employee with id " + id + " already exists.");
            return;
        }
        employees.put(id, new Employee(id, name, jobTitle, salary, dateOfEmployment));
        System.out.println("Employee " + name + " hired successfully.");
    }

    public void fire(String id) {
        Employee removed = employees.remove(id);
        if (removed == null) {
            System.out.println("Employee with id " + id + " not found.");
        } else {
            System.out.println("Employee " + removed.getName() + " fired.");
        }
    }

    public Iterator<Employee> getEmployees() {
        return employees.values().iterator();
    }

    public Iterator<Employee> getEmployees(String jobTitle) {
//        Tecnicamente funciona, mas um Stream não é uma
//        Collection — ele é descartável e só pode ser consumido uma vez.
//        O mais seguro é coletar numa lista primeiro e pegar o iterator dela,
//        que é o comportamento esperado de um Iterator de coleção.
        return employees.values()
                .stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .collect(Collectors.toList())
                .iterator();
    }

    public void pay(String id) {
        Employee employee = employees.get(id);
        if (employee == null) {
            System.out.println("Employee with id " + id + " not found.");
            return;
        }
        employee.createPaycheck(LocalDate.now());
        System.out.println("Employee " + employee.getName() + " paid successfully.");
    }

    public void increaseSalary(String id, double newSalary) {
        Employee employee = employees.get(id);
        if (employee == null) {
            System.out.println("Employee with id " + id + " not found.");
            return;
        }
        employee.setSalary(newSalary);
        System.out.println("Employee " + employee.getName() + " salary increased to " + newSalary);
    }

    public double averageSalary(String jobTitle) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
    public double averageSalary(LocalDate initialDate, LocalDate finalDate) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDateOfEmployment().isAfter(initialDate)
                        && employee.getDateOfEmployment().isBefore(finalDate))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }


}
