package InitialConcepts;

public class HumanResourcesService {
    void main() {
        // Declares the variable and instantiates the object using "new" keyword. Also, it sets the object state.
        Employee employeeToHire = new Employee("SC303234", "Alan Turing", 9000.0, "Jr. Software Engineer", 5);
        employeeToHire.increaseSalary(10); // sends a message to increase the salary by 10%
        System.out.println(employeeToHire.salary); // 9900.0
        // only declares a variable of type Employee
        Employee otherEmployee;
        otherEmployee = new Employee(); // instantiates the object with default state
        System.out.println(otherEmployee.salary); // Error! 'java: variable otherEmployee might not have been initialized'

        Computer newEmployeeComputer = new Computer("2321312", "Dell XPS 43", employeeToHire);
        employeeToHire.setComputer(newEmployeeComputer);
// employeeToHire => newEmployeeComputer => 'brand' attribute
        System.out.println(employeeToHire.getComputer().brand);
// newEmployeeComputer => employeeToHire => 'name' attribute: Alan Turing
        System.out.println(newEmployeeComputer.getEmployee().name);


    }
}