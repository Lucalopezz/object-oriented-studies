import java.time.LocalDate;
import java.util.Objects;

public final class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    public FullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double monthlySalary) {
        super(id, name, jobTitle, dateOfEmployment);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double salary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return String.format("%s, monthlySalary=%.2f", super.toString(), monthlySalary);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FullTimeEmployee that = (FullTimeEmployee) o;
        return Double.compare(monthlySalary, that.monthlySalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monthlySalary);
    }
}
