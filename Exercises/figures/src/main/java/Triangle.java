import java.util.Objects;

public non-sealed class Triangle extends Figure {

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(a, triangle.a) == 0
                && Double.compare(b, triangle.b) == 0
                && Double.compare(c, triangle.c) == 0
                && Double.compare(this.getX(), triangle.getX()) == 0
                && Double.compare(this.getY(), triangle.getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, this.getX(), this.getY());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", a=%f, b=%f, c=%f", a, b, c);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
