void main() {
       IO.println("teste");
       int x = 10+1;
       long y = x-6;
       long z = x*7;
       float r = (float) x/y;
       double w = x % r;

       IO.println("X= " + x);
       IO.println("Y= " + y);
       IO.println("Z= "+ z);
       IO.println("R= " + r);
       IO.println("W= " + w);


       //Constante
       final boolean CONST_1 = true;

       // Enum
       enum MaritalStatus {SINGLE, MARRIED, DIVORCED, WIDOWED}
        MaritalStatus status = MaritalStatus.SINGLE;
        if (status == MaritalStatus.MARRIED)
            System.out.println("Stay home");
        else
            System.out.println("Go to the pub");

        Scanner scanner = new Scanner(System.in); // Only one scanner is necessary to read multiple times
        String value = scanner.nextLine(); // Reads a line from the system input - console
        System.out.println("Hello " + value); // Writes a line in the system output - console
        double doubleValue = scanner.nextDouble(); // Reads a double
        // There are similar methods for boolean, byte, short, long e float
        System.out.println("doubleValue = " + doubleValue); // The value is converted to String before printing
}