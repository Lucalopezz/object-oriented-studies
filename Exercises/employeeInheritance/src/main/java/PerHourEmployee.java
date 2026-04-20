import java.time.LocalDate;
import java.util.Objects;

public final class PerHourEmployee extends Employee{
    private final double hourlyRate;
    private final double workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, double workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return hourlyRate * workedHour;
    }

    @Override
    public String toString() {
        return String.format("%s, hourlyRate=%.2f, workedHour=%.2f", super.toString(), hourlyRate, workedHour);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerHourEmployee that = (PerHourEmployee) o;
        return Double.compare(hourlyRate, that.hourlyRate) == 0 && Double.compare(workedHour, that.workedHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlyRate, workedHour);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getWorkedHour() {
        return workedHour;
    }
}
