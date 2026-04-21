import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // There are 2 types of repos -> manual(Array) and auto(ArrayList)
//        Repository<String, Employee> repository = new FakeManualEmployeeRepository();
        Repository<String, Employee> repository = new FakeArrayListEmployeeRepository();
        FindEmployeeService findService = new FindEmployeeService(repository);
        RegisterEmployeeService registerService = new RegisterEmployeeService(repository);

        registerService.register(new Employee("1", "Rocha", "Treinador",
                100000, LocalDate.of(2020, 1, 1)));
        // It will not be registered
        registerService.register(new Employee("1", "Rocha", "Treinador",
                100000, LocalDate.of(2020, 1, 1)));
        registerService.register(new Employee("2", "Pacho", "Treinador",
                150000, LocalDate.of(2020, 1, 1)));
        registerService.register(new Employee("3", "Ramon", "Atleta",
                200000, LocalDate.of(2020, 1, 1)));

        Employee found = findService.findById("2");
        if (found != null) {
            System.out.println("The best coach has been found: " + found.getName());
        }


    }
}
