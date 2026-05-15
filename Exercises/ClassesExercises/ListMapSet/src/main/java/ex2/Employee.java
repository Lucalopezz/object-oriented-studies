package ex2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Employee {

    private static final long employeeIdCount = 1;
    private final String id;
    private final String name;
    private final String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;

    private final List<Paycheck> paychecks = new ArrayList<>();

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        if (id.isEmpty()) {
            this.id = employeeIdCount + LocalDate.now().toString();
        } else {
            this.id = id;
        }
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
        this.salary = salary;
    }

    public double getYearsOfService() {
        return LocalDate.now().getYear() - dateOfEmployment.getYear();
    }

    public void createPaycheck(LocalDate payday){
        // Notice that the method restricts the form in which paychecks are added
        paychecks.add(new Paycheck(payday, salary));
    }
    public void removePaycheck(Paycheck paycheck){
        paychecks.remove(paycheck);
    }
    public Iterator<Paycheck> iteratorPaychecks(){
        return paychecks.iterator();
        // the Collection provides a method that returns an Iterator of its type
    }


    @Override
    public String toString() {
        return String.format("Employee: id='%s', name='%s', jobTitle='%s', dateOfEmployment=%s", id, name, jobTitle, dateOfEmployment);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(dateOfEmployment, employee.dateOfEmployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jobTitle, dateOfEmployment);
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
