package remake;

public class Room {
    private int number;
    private double price;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public String asString() {
        return "Room " + number + " - Price: $" + price;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
}
