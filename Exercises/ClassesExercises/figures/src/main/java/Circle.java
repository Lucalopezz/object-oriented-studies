import java.util.Objects;

public final class Circle extends Figure{
    private final double radius;
    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0
                && Double.compare(this.getX(), circle.getX()) == 0
                && Double.compare(this.getY(), circle.getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, this.getX(), this.getY());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", radius=%f", radius);
    }

    public double getRadius() {
        return radius;
    }
}
