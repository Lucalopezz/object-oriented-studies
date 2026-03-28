package org.example;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Hotel {
    private String name;
    private Room[] rooms;
    private Reservation[] reservations = new Reservation[100];
    private int countReservations = 0;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    private boolean isAvailableAt(Room room, LocalDate checkin, LocalDate checkout) {
        for (int i = 0; i < countReservations; i++) {
            if (room.equals(reservations[i].getRoom()) && (checkin.isBefore(reservations[i].getCheckout()) && checkout.isAfter(reservations[i].getCheckin()))) {
                return false;
            }
        }
        return true;
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkin, LocalDate checkout) {
        if (guest.getSsn().isEmpty() || roomNumber < 0 || checkin.isAfter(checkout)) {
            return null;
        }
        for (int i = 0; i < roomNumber; i++) {
            if (rooms[i].getNumber() == roomNumber) {
                if (isAvailableAt(rooms[i], checkin, checkout)) {
                    Reservation reservation = new Reservation(checkin, checkout, guest, rooms[i]);
                    reservations[countReservations] = reservation;
                    countReservations++;
                    return reservation;
                }
            }
        }
        return null;
    }

    public Reservation cancelReservation(String reservationId) {
        if (reservationId.isEmpty()) {
            return null;
        }
        for (int i = 0; i < countReservations; i++) {
            if (reservations[i].getId().equals(reservationId)) {
                Reservation findedReservation = reservations[i];
                reservations[i] = reservations[countReservations - 1];
                reservations[countReservations - 1] = null;
                countReservations--;
                return findedReservation;
            }
        }
        return null;
    }

    public Room[] getRoomsAvailable(LocalDate date){
        Room[] availableRooms = new Room[rooms.length];
        int countAvailableRooms = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (isAvailableAt(rooms[i], date, date.plusDays(1))){
                availableRooms[countAvailableRooms] = rooms[i];
                countAvailableRooms++;
            }
        }

        return availableRooms;
    }
}
