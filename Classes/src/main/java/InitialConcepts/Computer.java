package InitialConcepts;

public class Computer {
    String serialNumber, brand;
    Employee employee; // attribute to store an Employee memory reference

    public Computer(String serialNumber, String brand, Employee employee) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.employee = employee; // receives a reference by value and assigns it to the employee attribute
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee; // receives a reference by value and assigns it to the employee attribute
    }
}
