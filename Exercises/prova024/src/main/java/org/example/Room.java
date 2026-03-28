package org.example;

public class Room {
    private int number;
    private double price;


    public Room(int number, double price) {
        this.number = number;
        this.price = price;
    }


    public String asString() {
        return String.format("Room %d, price: %.2f", number, price);
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }


}
