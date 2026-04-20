import java.time.LocalDate;
import java.util.Objects;

public abstract sealed class Employee permits FullTimeEmployee, PerHourEmployee {
    private static final long employeeId = 1;
    private final String id;
    private final String name;
    private final String jobTitle;
    private final LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {
        if (id.isEmpty()){
            this.id = employeeId + LocalDate.now().toString();
        }else {
            this.id = id;
        }
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    public abstract double salary();

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
}
