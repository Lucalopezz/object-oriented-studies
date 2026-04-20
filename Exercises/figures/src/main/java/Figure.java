import java.util.Objects;

public abstract sealed class Figure permits Circle, Rectangle, Triangle {
    private final double x;
    private final double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Figure in x=%f, y=%f", x, y);
    }

    public abstract double area();
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
