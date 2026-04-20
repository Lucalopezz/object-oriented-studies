public class Main {
    public static void main(String[] args) {
        Employee employee1 = new FullTimeEmployee("", "John Doe", "Software Engineer",
                java.time.LocalDate.of(2020, 1, 15), 5000);
        Employee employee2 = new PerHourEmployee("", "Jane Smith", "Graphic Designer",
                java.time.LocalDate.of(2021, 5, 10), 20, 160);

        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println(employee1.equals(employee2));

        System.out.println("Emp1: " + employee1.salary());
        System.out.println("Emp2: " + employee2.salary());


    }
}
