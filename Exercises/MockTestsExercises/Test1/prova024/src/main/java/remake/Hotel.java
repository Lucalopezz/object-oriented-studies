package remake;

import java.time.LocalDate;
import java.util.Objects;

public class Hotel {
    private String name;
    private Room[] rooms;
    private int countRooms = 0;
    private Reservation[] reservations;
    private int reservationCount = 0;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
        countRooms = rooms.length;
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        for (int i = 0; i < countRooms; i++) {
            Room r = rooms[i];
            if (r.getNumber() == roomNumber) {
                if (isAvailableAt(r, checkIn, checkOut)) {
                    reservations[reservationCount++] = new Reservation(guest, r, checkIn, checkOut);
                }
            }
        }
        return null;
    }

    public Reservation cancelReservation(String reservationId) {
        for (int i = 0; i < reservationCount; i++) {
            Reservation r = reservations[i];
            if (r.getId().equals(reservationId)) {
                reservations[i] = reservations[reservationCount - 1];
                reservations[--reservationCount] = null;
                return r;
            }
        }
        return null;
    }

    public boolean isAvailableAt(Room room, LocalDate checkIn, LocalDate checkOut) {
        for (int i = 0; i < reservationCount; i++) {
            Reservation r = reservations[i];
            if (r.getRoom().getNumber() == room.getNumber() && checkIn.isBefore(r.getCheckout()) && checkOut.isAfter(r.getCheckin())) {
                return false;
            }
        }
        return true;
    }

    public Room[] getRoomsAvailableAt(LocalDate date) {
        Room[] availableRooms = new Room[countRooms];
        int countAvailableRooms = 0;
        for (int i = 0; i < countRooms; i++) {
            if (isAvailableAt(rooms[i], date, date.plusDays(1))){
                availableRooms[countAvailableRooms] = rooms[i];
                countAvailableRooms++;
            }
        }

        return availableRooms;
    }
}
