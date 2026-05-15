package remake;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private String id;
    private LocalDate checkin;
    private LocalDate checkout;

    private Guest guest;
    private Room room;

    public Reservation(Guest guest, Room room, LocalDate checkin, LocalDate checkout) {
        this.id = ReservationIdGenerator.generateReservationId();
        this.checkin = checkin;
        this.checkout = checkout;
        this.guest = guest;
        this.room = room;
    }
    public double getPrice(){
        return room.getPrice() * getNights();
    }

    private int getNights() {
        return (int) Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
    }

    public boolean isReservedAt(LocalDate date, Room room){
        if (!room.equals(this.room)){
            return false;
        }
        return (date.equals(checkin) || date.isAfter(checkin)) && date.isBefore(checkout);
    }

    public String asString(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("""
              ------------------------------------------------------------------------
              Reservation: %s       Room number: %d
              Gust name: %s         SSN: %s           Email: %s
              Check-in: %s          Check-out: %s   
              Number od days: %d    Room price: %.2f
              TOTAL: U$ %.2f
              
                """, id, room.getNumber(), guest.getName(), guest.getSsn(), guest.getEmail(), checkin.format(formatter), checkout.format(formatter), getNights(), room.getPrice(), getPrice());

    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public String getId() {
        return id;
    }
}
