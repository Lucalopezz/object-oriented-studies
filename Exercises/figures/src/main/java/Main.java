public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[150];
        for (int i = 0; i < 50; i++) {
            figures[i] = new Circle(1, 1, i);
            figures[50 + i] = new Rectangle(1, 1, i+1, i+2);
            figures[100 + i] = new Triangle(1, 1, i+1, i+2, i+3);
        }
        double area = 0.0;
        for (int i = 0; i < 150; i++) {
            System.out.printf(figures[i].toString() + "\n");
            area += figures[i].area();
        }
        System.out.println(area);
    }
}
