import java.awt.*;
import java.util.Objects;

public final class Rectangle extends Figure {
    private final double width;
    private final double length;
    public Rectangle(double x, double y,  double width, double length) {
        super(x, y);

        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0
                && Double.compare(length, rectangle.length) == 0
                && Double.compare(this.getX(), rectangle.getX()) == 0
                && Double.compare(this.getY(), rectangle.getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, this.getX(), this.getY());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", width=%f, length=%f", width, length);
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
