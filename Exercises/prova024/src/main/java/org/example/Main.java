package org.example;


import java.time.LocalDate;

public class Main {
    static void main() {
        Room[] rooms = new Room[10];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(i + 1, 100.0 + i * 20);
        }
        Hotel hotel = new Hotel("Hotel California", rooms);

        Guest guest1 = new Guest("123-45-6789", "John Doe", "tetse");
        Room[] availableRooms = hotel.getRoomsAvailable(LocalDate.now());
        for (Room availableRoom : availableRooms) {
            System.out.println(availableRoom.asString());
        }
        System.out.println("Making reservation for guest: " + guest1.getName());
        Reservation g1R = hotel.makeReservation(guest1, 1, LocalDate.now(), LocalDate.now().plusDays(4));
        System.out.println(g1R.asString());

        System.out.println("Remove reservation");
        System.out.println(hotel.cancelReservation(g1R.getId()).asString());
        availableRooms = hotel.getRoomsAvailable(LocalDate.now());
        for (Room availableRoom : availableRooms) {
            System.out.println(availableRoom.asString());
        }




    }
}
