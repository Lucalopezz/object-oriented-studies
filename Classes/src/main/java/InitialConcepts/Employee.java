package InitialConcepts;

public class Employee {
    String employeeId, name, jobTitle;
    double salary;
    int yearsOfService;
    Computer computer;

    public Employee() {
    } // default constructor

    public Employee(String employeeId, String name, double salary, String jobTitle, int yearsOfService) { // canonical constructor
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.yearsOfService = yearsOfService;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer; // receives a reference by value and assigns it to the computer attribute
    }

    void increaseSalary(double percentage) {
        salary = salary * (1 + percentage / 100);
    }

    double calculateBonus() {
        double bonusPercentage = 0.05; // 5% bonus for all employees
        if (yearsOfService >= 5) bonusPercentage += 0.1; // Additional 10% bonus for employees with 5+ of service
        return salary * bonusPercentage;
    }
}